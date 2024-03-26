package net.pluriel.service;

import org.springframework.data.domain.Page;

import net.pluriel.dto.request.ActorRequestDto;
import net.pluriel.dto.request.MovieRevenueRequestDto;
import net.pluriel.dto.response.ActorResponseDto;
import net.pluriel.dto.response.MovieRevenueResponseDto;
import net.pluriel.entities.MovieRevenue;

public interface MovieRevenueService {
	public MovieRevenueResponseDto create(MovieRevenueRequestDto movieRevenueRequestDto);

	public Page<MovieRevenue> findAllMovieRevenu(Integer page, Integer pageSize);

	public MovieRevenueResponseDto findById(Integer id);

	public void deleteMovieRevenueId(Integer id);
	
	public MovieRevenueResponseDto updateMovieRevenu(Integer id, MovieRevenueRequestDto movieRevenueRequestDto);
}
