package com.bookmyshow.demo.Service;

import java.time.LocalDate;
import java.util.List;

import com.bookmyshow.demo.Dto.MovieResponse;
import com.bookmyshow.demo.Dto.ShowResponse;
import com.bookmyshow.demo.Dto.ThetareResponse;

public interface CatlogService {

     public List<MovieResponse> movies();
     public List<ThetareResponse> theatres(String city);
     public List<ShowResponse> shows(String city,LocalDate date);
}
