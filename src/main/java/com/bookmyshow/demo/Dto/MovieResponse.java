package com.bookmyshow.demo.Dto;

import com.bookmyshow.demo.Entity.Movie;

public record MovieResponse(Long id, String title, String language, String genere, Integer durationMinutes,
                            String certificate, String description, String posterUrl, String titleUrl) {


    public static MovieResponse from(Movie movie)
    {
        return  new MovieResponse(movie.getId(),movie.getTitle(),movie.getLanguge(),movie.getGenre(),movie.getDuration(),
                movie.getCertificate(),movie.getDescription(),movie.getPosterurl(),
                movie.getTrailerurl());
    }
}
