package com.bookmyshow.demo.repository;

import com.bookmyshow.demo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Long>  {


    boolean extistByEmail(String email);
    boolean existByphone(String phoneNo);
    Optional<Customer> findByemail(String email);
    Optional<Customer> findByphone(String phone);

}
