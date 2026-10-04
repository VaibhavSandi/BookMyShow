package com.bookmyshow.demo.repository;

import com.bookmyshow.demo.Entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepo  extends JpaRepository <Show,Long> {
}
