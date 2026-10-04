package com.bookmyshow.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "show_seat",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_show_seat",
                columnNames = {"show_id", "seatLabel"}
        ))
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    private String SeatLabel;

    public ShowSeat(Show show, String seatLabel) {
        this.show = show;
        SeatLabel = seatLabel;
    }



    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public String getSeatLabel() {
        return SeatLabel;
    }

    public void setSeatLabel(String seatLabel) {
        SeatLabel = seatLabel;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    private boolean reserved;


    public boolean isresrved()
    {
        return reserved;
    }


    public void realeased()
    {
        reserved=false;
    }
}
