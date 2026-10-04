package com.bookmyshow.demo.repository;

import com.bookmyshow.demo.Entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepo  extends JpaRepository<ShowSeat,Long> {
}
