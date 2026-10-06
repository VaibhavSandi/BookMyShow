package com.bookmyshow.demo.ServiceImpl;

import com.bookmyshow.demo.Dto.BookingRequest;
import com.bookmyshow.demo.Dto.BookingResponse;
import com.bookmyshow.demo.Entity.Booking;
import com.bookmyshow.demo.Entity.BookingStatus;
import com.bookmyshow.demo.Entity.Show;
import com.bookmyshow.demo.Entity.ShowSeat;
import com.bookmyshow.demo.Exception.ResourceNotFoundException;
import com.bookmyshow.demo.Exception.SeatUnavaibleException;
import com.bookmyshow.demo.Service.BookingService;
import com.bookmyshow.demo.repository.BookingRepo;
import com.bookmyshow.demo.repository.CustomerRepo;
import com.bookmyshow.demo.repository.ShowRepo;
import com.bookmyshow.demo.repository.ShowSeatRepo;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private final ShowSeatRepo showSeatRepo;

    private final ShowRepo showRepo;

    private final BookingRepo bookingRepo;

    private final CustomerRepo customerRepo;

    public BookingServiceImpl(ShowSeatRepo showSeatRepo, ShowRepo showRepo, BookingRepo bookingRepo,
            CustomerRepo customerRepo) {
        this.showSeatRepo = showSeatRepo;
        this.showRepo = showRepo;
        this.bookingRepo = bookingRepo;
        this.customerRepo = customerRepo;
    }

    @Transactional
    public BookingResponse book(Long showId, BookingRequest request) {

        Show show = showRepo.findById(showId).orElseThrow(() -> new ResourceNotFoundException("Show not found"));

        var customer = customerRepo.findById(request.profileId())
                .orElseThrow(() -> new ResourceNotFoundException("profile not found"));
        List<String> labels = request.seatLables().stream().map(lable -> lable.trim().toUpperCase(Locale.ROOT))
                .toList();

        if (labels.stream().distinct().count() != labels.size()) {
            throw new SeatUnavaibleException("Duplicate seat labels are not allowed");
        }

        List<ShowSeat> seats = showSeatRepo.findForUpdate(showId, labels);

        if (seats.size() != labels.size() || seats.stream().anyMatch(ShowSeat::isReserved)) {
            throw new SeatUnavaibleException("one or more seats are not available");
        }

        seats.forEach(seat -> seat.setReserved(true));
        show.reserved(labels.size());

        BigDecimal totalAmount = show.getTicketPrice().multiply(BigDecimal.valueOf(labels.size()));

        Booking book = bookingRepo.save(new Booking(show, customer, totalAmount, labels));

        return BookingResponse.from(book);

    }
    @Transactional 
    public BookingResponse find(Long bookingId)
    {
        Booking booking = bookingRepo.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Booking not found"));
        return BookingResponse.from(booking);
    }

       @Transactional 
    public List<BookingResponse> findByProfileId(Long profileId) {
        if(!customerRepo.existsById(profileId)==false)
        {
            throw new ResourceNotFoundException("Profile not found");
        }

        return bookingRepo.findByCustomerIdOrderByBookedAtDesc(profileId).stream().map(BookingResponse::from).toList();
       
    }
     @Transactional 
    public BookingResponse cancel(long bookingId, long profileId) {
        

       Booking booking= bookingRepo.findByIdAndCustomerId(bookingId, profileId).orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
       if(booking.getStatus()==BookingStatus.CONFIRMED)
       {
        List<ShowSeat> seats=showSeatRepo.findForUpdate(booking.getShow().getId(),booking.getSeatLabel());

        seats.forEach(ShowSeat::realeased);
        booking.getShow().realsed(booking.getSeatLabel().size());
        booking.cancel();
       }
       return BookingResponse.from(booking);
    }
}
