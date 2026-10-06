package com.bookmyshow.demo.repository;

import com.bookmyshow.demo.Entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ThetareRepo extends JpaRepository<Theatre,Long> {

    List<Theatre>  findByCityIgnoreCaseOrderByName(String city);

    Optional<Theatre> findByNameAndCity(String name ,String City);
}
