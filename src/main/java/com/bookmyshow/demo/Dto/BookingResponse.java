package com.bookmyshow.demo.Dto;

import com.bookmyshow.demo.Entity.Booking;
import com.bookmyshow.demo.Entity.BookingStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record BookingResponse(
        Long id,
        Long showId,
        Long profileId,
        String movieTitle,
        String theatreName,
        String customerName,
        String customerEmail,
        String customerPhoneNo,
        List<String> seatLabels,
        BigDecimal totalAmount,
        BookingStatus status,
        LocalDateTime bookedAt
) {

    public  static BookingResponse from(Booking booking) {
        return new BookingResponse(booking.getId(), booking.getShow().getId(), booking.getCustomer() == null ? null : booking.getCustomer().getId(),
                booking.getShow().getMovie().getTitle(),
                booking.getShow().getTheatre().getName(),
                booking.getCustomerName(),
                booking.getCustomerEmail(),
                booking.getCustomerPhoneno(),
                booking.getSeatLabel(),
                booking.getTotalAmount(),
                booking.getStatus(),
                booking.getBookedAt());
    }
    }
