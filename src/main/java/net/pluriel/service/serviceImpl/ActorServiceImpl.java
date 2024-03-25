package net.pluriel.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
		actorRepository.save(actorRequest);

		return actorMapper.convertEntityToResponseDto(actorRequest);
	}

	@Override
	public Page<Actor> findAllActors(Integer page, Integer pageSize) {

		return actorRepository.findAll(PageRequest.of(page, pageSize));
	}

	@Override
	public void findById(Integer id) {
		Optional<Actor> actorOptional = actorRepository.findById(id);
		if(! actorOptional.isPresent()) {
			throw new DataException("actor not found", HttpStatus.NOT_FOUND.toString());
		}
		
		actorRepository.delete(actorOptional.get());
	}

}
