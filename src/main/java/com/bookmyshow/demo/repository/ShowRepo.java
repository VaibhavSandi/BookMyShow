package com.bookmyshow.demo.repository;

import com.bookmyshow.demo.Entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface ShowRepo  extends JpaRepository <Show,Long> {

    boolean existsByMovieIdAndTheatreIdAndStratsAt(Long movieId, Long TheratreId, LocalDateTime stratAt);
    @Query("""
    SELECT s
    FROM Show s
    JOIN FETCH s.movie m
    JOIN FETCH s.theatre t
    WHERE s.active = true
      AND m.activate = true
      AND t.city = :city
      AND s.stratsAt >= :from
      AND s.stratsAt < :to
    ORDER BY s.stratsAt
    """)
    List<Show> findActiveShows(
            @Param("city") String city,
            @Param("from") LocalDateTime from,
            @Param("to") LocalDateTime to
    );


}
