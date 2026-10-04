package com.bookmyshow.demo.repository;

import com.bookmyshow.demo.Entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThetareRepo extends JpaRepository<Theatre,Long> {
}
