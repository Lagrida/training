package net.pluriel.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import net.pluriel.dto.mappers.MovieRevenuMapper;
import net.pluriel.dto.request.MovieRevenueRequestDto;
import net.pluriel.dto.response.MovieRevenueResponseDto;
import net.pluriel.entities.Director;
import net.pluriel.entities.MovieRevenue;
import net.pluriel.exception.DataException;
import net.pluriel.repositories.DirectorRepostiory;
import net.pluriel.repositories.MovieRevenueRepository;
import net.pluriel.service.MovieRevenueService;

@Service
public class MovieRevenueServiceImpl implements MovieRevenueService {
	@Autowired
	private MovieRevenuMapper movieRevenuMapper;

	@Autowired
	private MovieRevenueRepository movieRevenueRepository;

	@Override
	public MovieRevenueResponseDto create(MovieRevenueRequestDto movieRevenueRequestDto) {
		MovieRevenue movieRevenue = movieRevenuMapper.convertRequestDtoToEntity(movieRevenueRequestDto);
		movieRevenueRepository.save(movieRevenue);

		return movieRevenuMapper.convertEntityToResponseDto(movieRevenue);
	}

	@Override
	public Page<MovieRevenue> findAllMovieRevenu(Integer page, Integer pageSize) {

		return movieRevenueRepository.findAll(PageRequest.of(page, pageSize));
	}

	@Override
	public MovieRevenueResponseDto findById(Integer id) {
		Optional<MovieRevenue> movieRevenuOptional = movieRevenueRepository.findById(id);
		if (!movieRevenuOptional.isPresent()) {
			throw new DataException("movie Revenu not found", HttpStatus.NOT_FOUND.toString());
		}
		return movieRevenuMapper.convertEntityToResponseDto(movieRevenuOptional.get());
	}

	@Override
	public void deleteMovieRevenueId(Integer id) {
		Optional<MovieRevenue> movieRevenuOptional = movieRevenueRepository.findById(id);
		if (!movieRevenuOptional.isPresent()) {
			throw new DataException("movie Revenu not found", HttpStatus.NOT_FOUND.toString());
		}
		movieRevenueRepository.delete(movieRevenuOptional.get());

	}

}
