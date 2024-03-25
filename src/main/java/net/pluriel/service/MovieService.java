package net.pluriel.service;

import org.springframework.data.domain.Page;
import net.pluriel.dto.request.MovieRequestDto;
import net.pluriel.dto.response.MovieResponseDto;
import net.pluriel.entities.Movie;
import net.pluriel.entities.MovieRevenue;

public interface MovieService {
	public Movie create(MovieRequestDto movieRequestDto);
	public Page<Movie> findAllMovies(Integer page , Integer pageSize);
	public MovieResponseDto findById(Integer id);
	public void deleteMovieId(Integer id);
}
