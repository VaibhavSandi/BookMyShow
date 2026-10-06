package com.bookmyshow.demo.repository;

import com.bookmyshow.demo.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepo  extends JpaRepository<Booking,Long> {



    List<Booking> findBycustomerPhonenoOrderByBookedAtDesc(String customerPhone);


    Optional<Booking> findByIdAndCustomerPhoneno(Long Id,String phoneno);

    List<Booking> findByCustomerIdOrderByBookedAtDesc(long customerId);
    Optional<Booking> findByIdAndCustomerId(Long id, long customerId);
}
