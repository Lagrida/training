package net.pluriel.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import net.pluriel.dto.request.ActorRequestDto;
import net.pluriel.dto.response.ActorResponseDto;
import net.pluriel.entities.Actor;

@Mapper(componentModel = "spring")
public interface ActorMapper {

	ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);
	
	Actor convertRequestDtoToEntity(ActorRequestDto actorRequestDto);
	Actor convertResponseDtoToEntity(ActorResponseDto actorResponseDto);
	
	ActorResponseDto convertEntityToResponseDto(Actor actor);
}
