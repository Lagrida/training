package net.pluriel.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import net.pluriel.dto.request.MovieRequestDto;
import net.pluriel.dto.response.MovieResponseDto;
import net.pluriel.entities.Movie;

@Mapper(componentModel = "spring")
public interface MovieMapper {
	MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
	
	Movie convertRequestDtoToEntity(MovieRequestDto movieRequestDto);
	Movie convertResponseDtoToEntity(MovieResponseDto movieResponseDto);
	
	MovieResponseDto convertEntityToResponseDto(Movie movie);
}
