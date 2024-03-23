package net.pluriel.service;

import net.pluriel.dto.request.DirectorRequestDto;
import net.pluriel.dto.response.DirectorResponseDto;

public interface DirectorService {
	public DirectorResponseDto create(DirectorRequestDto directorRequestDto);
}
