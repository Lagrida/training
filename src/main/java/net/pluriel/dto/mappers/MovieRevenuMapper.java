package net.pluriel.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import net.pluriel.dto.request.MovieRevenueRequestDto;
import net.pluriel.dto.response.MovieRevenueResponseDto;
import net.pluriel.entities.MovieRevenue;

@Mapper(componentModel = "spring")
public interface MovieRevenuMapper {
	MovieRevenuMapper INSTANCE = Mappers.getMapper(MovieRevenuMapper.class);
	
	MovieRevenue convertRequestDtoToEntity(MovieRevenueRequestDto movieRevenueRequestDto);
	MovieRevenue convertResponseDtoToEntity(MovieRevenueRequestDto MovieRevenueRequestDto);
	
	MovieRevenueResponseDto convertEntityToResponseDto(MovieRevenue movieRevenue);
}
