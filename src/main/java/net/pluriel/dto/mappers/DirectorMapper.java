package net.pluriel.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.pluriel.dto.request.DirectorRequestDto;
import net.pluriel.dto.response.DirectorResponseDto;
import net.pluriel.entities.Director;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
	DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);
	
	Director convertRequestDtoToEntity(DirectorRequestDto directorRequestDto);
	Director convertResponseDtoToEntity(DirectorResponseDto directorResponseDto);
	
	DirectorResponseDto convertEntityToResponseDto(Director director);
}
