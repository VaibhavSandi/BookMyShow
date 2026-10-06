package com.bookmyshow.demo.Service;

import com.bookmyshow.demo.Dto.BookingRequest;
import com.bookmyshow.demo.Dto.BookingResponse;

public interface BookingService {

    public BookingResponse book(Long showId, BookingRequest request);
    public BookingResponse cancel(long bookingId, long profileId);
    public BookingResponse find(Long bookingId);
}

