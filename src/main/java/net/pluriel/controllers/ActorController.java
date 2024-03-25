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
import net.pluriel.dto.request.ActorRequestDto;
import net.pluriel.dto.response.ActorResponseDto;
import net.pluriel.dto.response.DirectorResponseDto;
import net.pluriel.entities.Actor;
import net.pluriel.service.ActorService;

@RestController
@RequestMapping("/api/v1/actors")
public class ActorController {

	@Autowired
	private ActorService actorService;

	@PostMapping
	public ResponseEntity<ActorResponseDto> create(@RequestBody ActorRequestDto actorRequestDto) {
		return new ResponseEntity<ActorResponseDto>(actorService.create(actorRequestDto),
				HttpStatus.CREATED);
	}

	@GetMapping("/all/{page}/{pageSize}")
	public ResponseEntity<Page<Actor>> findAll(@PathVariable Integer page, @PathVariable Integer pageSize) {
		return new ResponseEntity<>(actorService.findAllActors(page, pageSize), HttpStatus.OK);
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<ActorResponseDto> findById(@PathVariable Integer id) {
	return new ResponseEntity<ActorResponseDto>(actorService.findById(id), HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteActor(@PathVariable Integer id) {
		actorService.deleteActorId(id);
	}
}
