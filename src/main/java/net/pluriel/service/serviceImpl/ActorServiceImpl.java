package net.pluriel.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;

import net.pluriel.dto.mappers.ActorMapper;
import net.pluriel.dto.request.ActorRequestDto;
import net.pluriel.dto.response.ActorResponseDto;
import net.pluriel.entities.Actor;
import net.pluriel.entities.Director;
import net.pluriel.exception.DataException;
import net.pluriel.repositories.ActorRepository;
import net.pluriel.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private ActorMapper actorMapper;

	@Override
	public ActorResponseDto create(ActorRequestDto actorRequestDto) {
		Actor actorRequest = actorMapper.convertRequestDtoToEntity(actorRequestDto);
		 try {
		        actorRepository.save(actorRequest);
		    } catch (DataIntegrityViolationException e) {
		        throw new DataException("Actor already exists", HttpStatus.BAD_REQUEST.toString());
		    }
		

		return actorMapper.convertEntityToResponseDto(actorRequest);
	}

	@Override
	public Page<Actor> findAllActors(Integer page, Integer pageSize) {

		return actorRepository.findAll(PageRequest.of(page, pageSize));
	}

	@Override
	public void deleteActorId(Integer id) {
		Actor actorOptional = actorRepository.findById(id).orElseThrow(() -> new DataException("actor not found", HttpStatus.NOT_FOUND.toString()));

		actorRepository.delete(actorOptional);
	}

	@Override
	public ActorResponseDto findById(Integer id) {
		Actor actorOptional = actorRepository.findById(id).orElseThrow(() -> new DataException("actor not found", HttpStatus.NOT_FOUND.toString()));

		return actorMapper.convertEntityToResponseDto(actorOptional);
	}

	@Override
	public ActorResponseDto updateActor(Integer id, ActorRequestDto actorRequestDto) {
		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Actor not found"));

		Actor actorRequest = actorMapper.convertRequestDtoToEntity(actorRequestDto);
		
		actor.setFirstName(actorRequest.getFirstName());
		actor.setLastName(actorRequest.getLastName());
		actor.setBirthday(actorRequest.getBirthday());
		actor.setGender(actorRequest.getGender());
		actor.setStatus(actorRequest.getStatus());

		actorRepository.save(actor);

		return actorMapper.convertEntityToResponseDto(actor);
	}

}
