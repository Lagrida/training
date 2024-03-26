package net.pluriel.service;

import org.springframework.data.domain.Page;

import net.pluriel.dto.request.DirectorRequestDto;
import net.pluriel.dto.request.MovieRequestDto;
import net.pluriel.dto.response.MovieResponseDto;
import net.pluriel.entities.Movie;

public interface MovieService {
	public Movie create(MovieRequestDto movieRequestDto);

	public Page<Movie> findAllMovies(Integer page, Integer pageSize);

	public MovieResponseDto findById(Integer id);

	public void deleteMovieId(Integer id);
	
	public Movie updateMovie(Integer id, MovieRequestDto movieRequestDto);
}
