package net.pluriel.service;

import org.springframework.data.domain.Page;

import net.pluriel.dto.request.ActorRequestDto;
import net.pluriel.dto.response.ActorResponseDto;
import net.pluriel.dto.response.DirectorResponseDto;
import net.pluriel.entities.Actor;

public interface ActorService {
	public ActorResponseDto create(ActorRequestDto actorRequestDto);

	public Page<Actor> findAllActors(Integer page, Integer pageSize);

	public ActorResponseDto findById(Integer id);

	public void deleteActorId(Integer id);

	public ActorResponseDto updateActor(Integer id, ActorRequestDto actorRequestDto);
}
