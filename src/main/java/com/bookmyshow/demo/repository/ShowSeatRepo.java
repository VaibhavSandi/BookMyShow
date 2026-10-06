package com.bookmyshow.demo.repository;

import com.bookmyshow.demo.Entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ShowSeatRepo  extends JpaRepository<ShowSeat,Long> {

@Query("""
    SELECT s.SeatLabel
    FROM ShowSeat s
    WHERE s.show.id = :showId
      AND s.reserved = false
    ORDER BY s.id
    """)
List<String> findAvailableLabels(@Param("showId") Long showId);


@Query("""
    SELECT s
    FROM ShowSeat s
    WHERE s.show.id = :showId
      AND s.SeatLabel IN :labels
    """)
List<ShowSeat> findForUpdate(
        @Param("showId") Long showId,
        @Param("labels") List<String> labels
);
}