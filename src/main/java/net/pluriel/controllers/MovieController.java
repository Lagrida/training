package net.pluriel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.pluriel.dto.request.MovieRequestDto;
import net.pluriel.dto.response.ActorResponseDto;
import net.pluriel.dto.response.MovieResponseDto;
import net.pluriel.entities.Movie;
import net.pluriel.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostMapping
	public ResponseEntity<Movie> create(@RequestBody MovieRequestDto movieRequestDto) {
		return new ResponseEntity<Movie>(movieService.create(movieRequestDto), HttpStatus.CREATED);
	}

	@GetMapping("/all/{page}/{pageSize}")
	public ResponseEntity<Page<Movie>> findAll(@PathVariable Integer page, @PathVariable Integer pageSize) {
		return new ResponseEntity<>(movieService.findAllMovies(page, pageSize), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void delteMovie(@PathVariable Integer id) {
		movieService.deleteMovieId(id);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<MovieResponseDto> findById(@PathVariable Integer id) {
		return new ResponseEntity<MovieResponseDto>(movieService.findById(id), HttpStatus.OK);
	}
}
