package net.pluriel.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.pluriel.dto.request.DirectorRequestDto;
import net.pluriel.dto.response.DirectorResponseDto;
import net.pluriel.entities.Director;

public interface DirectorService {
	public DirectorResponseDto create(DirectorRequestDto directorRequestDto);

	public Page<Director> findAllDirectors(Integer page, Integer pageSize);

	public DirectorResponseDto findById(Integer id);

	public void deleteDirectorId(Integer id);

	public DirectorResponseDto updateDirector(Integer id, DirectorRequestDto directorRequestDto);

}
