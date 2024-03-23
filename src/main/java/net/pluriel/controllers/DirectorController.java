package net.pluriel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.pluriel.dto.request.DirectorRequestDto;
import net.pluriel.dto.response.DirectorResponseDto;
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
}
