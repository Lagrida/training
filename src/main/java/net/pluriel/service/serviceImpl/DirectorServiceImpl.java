package net.pluriel.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import net.pluriel.dto.mappers.DirectorMapper;
import net.pluriel.dto.request.DirectorRequestDto;
import net.pluriel.dto.response.DirectorResponseDto;
import net.pluriel.entities.Director;
import net.pluriel.exception.DataException;
import net.pluriel.repositories.DirectorRepostiory;
import net.pluriel.service.DirectorService;

@Service
@Log4j2
public class DirectorServiceImpl implements DirectorService {

	@Autowired
	private DirectorRepostiory directorRepostiory;

	@Autowired
	private DirectorMapper directorMapper;

	@Override
	public DirectorResponseDto create(DirectorRequestDto directorRequestDto) {

		Director directorRequest = directorMapper.convertRequestDtoToEntity(directorRequestDto);

		directorRepostiory.save(directorRequest);

		return directorMapper.convertEntityToResponseDto(directorRequest);
	}

	@Override
	public DirectorResponseDto findById(Integer id) {

		Optional<Director> directorOptional = directorRepostiory.findById(id);
		if (!directorOptional.isPresent()) {
			throw new DataException("director not found", HttpStatus.NOT_FOUND.toString());
		}

		return directorMapper.convertEntityToResponseDto(directorOptional.get());
	}

	@Override
	public Page<Director> findAllDirectors(Integer page, Integer pageSize) {

		return directorRepostiory.findAll(PageRequest.of(page, pageSize));
	}

	@Override
	public void deleteDirectorId(Integer id) {

		Optional<Director> directorOptional = directorRepostiory.findById(id);
		if (!directorOptional.isPresent()) {
			throw new DataException("director not found", HttpStatus.NOT_FOUND.toString());
		}

		directorRepostiory.delete(directorOptional.get());

	}

	@Override
	public DirectorResponseDto updateDirector(Integer id, DirectorRequestDto directorRequestDto) {
		Director director = directorRepostiory.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
		// Director director2=
		// directorMapper.convertRequestDtoToEntity(directorRequestDto);

		return directorMapper.convertEntityToResponseDto(director);

	}

}
