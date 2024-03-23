package net.pluriel.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.pluriel.dto.mappers.DirectorMapper;
import net.pluriel.dto.request.DirectorRequestDto;
import net.pluriel.dto.response.DirectorResponseDto;
import net.pluriel.entities.Director;
import net.pluriel.service.DirectorService;

@Service @Slf4j
public class DirectorServiceImpl implements DirectorService{

	@Autowired
	private DirectorMapper directorMapper;
	
	@Override
	public DirectorResponseDto create(DirectorRequestDto directorRequestDto) {
		
		Director directorRequest = directorMapper.convertRequestDtoToEntity(directorRequestDto);
		
		// Logique 
		
		log.info("{}", directorRequest);
				
		return directorMapper.convertEntityToResponseDto(directorRequest);
	}

}
