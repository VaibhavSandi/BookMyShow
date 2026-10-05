package com.bookmyshow.demo.repository;

import com.bookmyshow.demo.Entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ShowSeatRepo  extends JpaRepository<ShowSeat,Long> {

    @Query("select s.seatLabel from ShowSeat where s.showid=:showId and s.reserved=false order by s.id")
    List<String> findAvailbleLabels(@Param("showId") Long showId);

    @Query("select s from ShowSeat s where s.showid=:showId and s.seatLabel in labels")
    List<ShowSeat> findForUpdate(@Param("showId") Long showId,@Param("labels") List<String> labels);
}
