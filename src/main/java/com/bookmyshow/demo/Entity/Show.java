package com.bookmyshow.demo.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "show")
public class Show {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public LocalDateTime getStratsAt() {
        return stratsAt;
    }

    public void setStratsAt(LocalDateTime stratsAt) {
        this.stratsAt = stratsAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableseats() {
        return availableseats;
    }

    public void setAvailableseats(int availableseats) {
        this.availableseats = availableseats;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getVersion() {
        return Version;
    }

    public void setVersion(long version) {
        Version = version;
    }

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Movie movie;

    public Show(Movie movie, Theatre theatre, LocalDateTime stratsAt, LocalDateTime endAt, int totalSeats, int availableseats) {
        this.movie = movie;
        this.theatre = theatre;
        this.stratsAt = stratsAt;
        this.endAt = endAt;
        this.totalSeats = totalSeats;
        this.availableseats = availableseats;
    }
 @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Theatre theatre;

    private LocalDateTime stratsAt;

    private LocalDateTime endAt;

    private int totalSeats;

    private BigDecimal ticketPrice;

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    private int availableseats;

    private boolean active=true;
    @Version
    private long Version;


    public void reserved(int seats)
    {
        if(seats<=0 || seats>availableseats)
        {
            throw new IllegalArgumentException("Not Enough Seat Available");
        }

        availableseats-=seats;
    }


    public void realsed(int seats)
    {
//        availableseats=Math.min(totalSeats,availableseats+seats);
        availableseats=availableseats+seats;
    }
}
