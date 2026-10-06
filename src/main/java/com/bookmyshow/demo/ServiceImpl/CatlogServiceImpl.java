package com.bookmyshow.demo.ServiceImpl;

import com.bookmyshow.demo.Dto.MovieResponse;
import com.bookmyshow.demo.Dto.ShowResponse;
import com.bookmyshow.demo.Dto.ThetareResponse;
import com.bookmyshow.demo.Service.CatlogService;
import com.bookmyshow.demo.repository.MovieRepo;
import com.bookmyshow.demo.repository.ShowRepo;
import com.bookmyshow.demo.repository.ShowSeatRepo;
import com.bookmyshow.demo.repository.ThetareRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CatlogServiceImpl implements CatlogService {


    private final MovieRepo movieRepo;

    private final ThetareRepo thetareRepo;

    private final ShowRepo showRepo;

    private ShowSeatRepo showSeatRepo;

    public CatlogServiceImpl(MovieRepo movieRepo, ThetareRepo thetareRepo, ShowRepo showRepo, ShowSeatRepo showSeatRepo) {
        this.movieRepo = movieRepo;
        this.thetareRepo = thetareRepo;
        this.showRepo = showRepo;
        this.showSeatRepo = showSeatRepo;
    }


    public List<MovieResponse> movies()
    {
        return movieRepo.findByActivateTrueOrderByTitle().stream().map(MovieResponse::from).toList();        
    }


    public List<ThetareResponse> theatres(String city)
    {
        return thetareRepo.findByCityIgnoreCaseOrderByName(city).stream().map(ThetareResponse::from).toList();
    }


    public List<ShowResponse> shows(String city,LocalDate date)
    {
        LocalDateTime from=date.atStartOfDay();
        return showRepo.findActiveShows(city,from,from.plusDays(1)).stream().map(show->ShowResponse.from(show,showSeatRepo.findAvailableLabels(show.getId()))).toList();
    }

}
