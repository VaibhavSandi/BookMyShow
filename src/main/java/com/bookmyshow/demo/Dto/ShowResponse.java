package com.bookmyshow.demo.Dto;

import com.bookmyshow.demo.Entity.Show;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record ShowResponse(long id, MovieResponse movie, ThetareResponse therate, LocalDateTime stratAt,
                           LocalDateTime endDateTimeAt, BigDecimal ticketPrice, int totalseats,
                           List<String> availableSeatsLables) {


    public static ShowResponse from(Show show,List<String> availableSeatsLables )
    {
        return new ShowResponse(show.getId(),
                MovieResponse.from(show.getMovie()),
                ThetareResponse.from(show.getTheatre()),
                show.getStratsAt(),show.getEndAt(),show.getTicketPrice(),
                show.getTotalSeats(),availableSeatsLables
                );
    }
}
