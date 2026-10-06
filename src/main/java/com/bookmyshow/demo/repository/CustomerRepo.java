package com.bookmyshow.demo.repository;

import com.bookmyshow.demo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Long>  {


  boolean existsByEmail(String email);

boolean existsByphoneno(String phone);

Optional<Customer> findByEmail(String email);

Optional<Customer> findByphoneno(String phone);

}
