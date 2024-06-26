package net.pluriel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.pluriel.dto.request.MovieRevenueRequestDto;
import net.pluriel.dto.response.DirectorResponseDto;
import net.pluriel.dto.response.MovieRevenueResponseDto;
import net.pluriel.entities.MovieRevenue;
import net.pluriel.service.MovieRevenueService;

@RestController
@RequestMapping("/api/v1/movie-revenu")
public class MovieRevenuController {

	@Autowired
	private MovieRevenueService movieRevenueService;

	@PostMapping
	public ResponseEntity<MovieRevenueResponseDto> create(@RequestBody MovieRevenueRequestDto movieRevenueRequestDto) {
		return new ResponseEntity<MovieRevenueResponseDto>(movieRevenueService.create(movieRevenueRequestDto),
				HttpStatus.CREATED);
	}

	@GetMapping("/all/{page}/{pageSize}")
	public ResponseEntity<Page<MovieRevenue>> findAll(@PathVariable Integer page, @PathVariable Integer pageSize) {
		return new ResponseEntity<>(movieRevenueService.findAllMovieRevenu(page, pageSize), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void delteMovieRevenu(@PathVariable Integer id) {
		movieRevenueService.deleteMovieRevenueId(id);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<MovieRevenueResponseDto> findById(@PathVariable Integer id) {
		return new ResponseEntity<MovieRevenueResponseDto>(movieRevenueService.findById(id), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<MovieRevenueResponseDto> updateDirector(@PathVariable Integer id,
			@RequestBody MovieRevenueRequestDto movieRevenueRequestDto) {
		return new ResponseEntity<MovieRevenueResponseDto>(movieRevenueService.updateMovieRevenu(id, movieRevenueRequestDto),
				HttpStatus.CREATED);
	}
}
