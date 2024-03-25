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

import net.pluriel.dto.request.DirectorRequestDto;
import net.pluriel.dto.response.DirectorResponseDto;
import net.pluriel.entities.Director;
import net.pluriel.service.DirectorService;

@RestController
@RequestMapping("/api/v1/directors")
public class DirectorController {

	@Autowired
	private DirectorService directorService;

	@PostMapping
	public ResponseEntity<DirectorResponseDto> create(@RequestBody DirectorRequestDto directorRequest) {
		return new ResponseEntity<DirectorResponseDto>(directorService.create(directorRequest), HttpStatus.CREATED);
	}

	@GetMapping("/all/{page}/{pageSize}")
	public ResponseEntity<Page<Director>> findAll(@PathVariable Integer page, @PathVariable Integer pageSize) {
		return new ResponseEntity<>(directorService.findAllDirectors(page, pageSize), HttpStatus.OK);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<DirectorResponseDto> findById(@PathVariable Integer id) {
		return new ResponseEntity<DirectorResponseDto>(directorService.findById(id), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteDirector(@PathVariable Integer id) {
		directorService.deleteDirectorId(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<DirectorResponseDto> updateDirector(@PathVariable Integer id,
			@RequestBody DirectorRequestDto directorRequestDto) {
		return new ResponseEntity<DirectorResponseDto>(directorService.updateDirector(id, directorRequestDto),
				HttpStatus.CREATED);
	}
}
