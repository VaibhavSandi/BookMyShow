package com.bookmyshow.demo.repository;

import com.bookmyshow.demo.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepo  extends JpaRepository<Booking,Long> {



    List<Booking> findByCustomerPhoneNoOrderByBookedAtDesc(String customerPhone);


    Optional<Booking> findByIdAndCustomerPhoneNo(Long Id,String phoneno);
}
