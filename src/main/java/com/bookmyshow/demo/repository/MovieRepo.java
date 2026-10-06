package com.bookmyshow.demo.repository;

import com.bookmyshow.demo.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MovieRepo  extends JpaRepository<Movie,Long> {


    List<Movie> findByActivateTrueOrderByTitle();
    Optional<Movie> findByTitle(String title);

}
