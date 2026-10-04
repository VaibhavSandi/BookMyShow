package com.bookmyshow.demo.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Booking")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Show show;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private  Customer customer;

    private String customerName;

    public Booking(Show show, Customer customer, BigDecimal totalAmount, List<String> seatLabel) {
        this.show = show;
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.seatLabel = seatLabel;
    }

    public Booking(Show show, Customer customer, String customerName, String customerEmail, String customerPhoneno, BigDecimal totalAmount, LocalDateTime bookedAt, BookingStatus status, List<String> seatLabel) {
        this.show = show;
        this.customer = customer;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneno = customerPhoneno;
        this.totalAmount = totalAmount;
        this.bookedAt = LocalDateTime.now();
        this.status = BookingStatus.CONFIRMED;
        this.seatLabel = new ArrayList<>();
    }

    public Booking() {
    }

    private String customerEmail;

    private String customerPhoneno;

    private BigDecimal totalAmount;

    private LocalDateTime bookedAt;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneno() {
        return customerPhoneno;
    }

    public void setCustomerPhoneno(String customerPhoneno) {
        this.customerPhoneno = customerPhoneno;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(LocalDateTime bookedAt) {
        this.bookedAt = bookedAt;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public List<String> getSeatLabel() {
        return seatLabel;
    }

    public void setSeatLabel(List<String> seatLabel) {
        this.seatLabel = seatLabel;
    }

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    @ElementCollection
    @CollectionTable(
          name = "booking_seats",
          joinColumns =  @JoinColumn(name = "booking_id")
    )
    @Column(name="seat_label",nullable = false)
    public List<String> seatLabel=new ArrayList<>();
}
