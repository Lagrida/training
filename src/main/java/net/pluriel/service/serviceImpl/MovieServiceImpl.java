package net.pluriel.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;
import net.pluriel.dto.mappers.MovieMapper;
import net.pluriel.dto.request.MovieRequestDto;
import net.pluriel.dto.request.RequestIdDto;
import net.pluriel.dto.response.MovieResponseDto;
import net.pluriel.entities.Actor;
import net.pluriel.entities.Director;
import net.pluriel.entities.Movie;
import net.pluriel.entities.MovieRevenue;
import net.pluriel.exception.DataException;
import net.pluriel.repositories.ActorRepository;
import net.pluriel.repositories.DirectorRepostiory;
import net.pluriel.repositories.MovieRepository;
import net.pluriel.repositories.MovieRevenueRepository;
import net.pluriel.service.MovieService;

@Log4j2
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieRevenueRepository movieRevenueRepository;

	@Autowired
	private DirectorRepostiory directorRepostiory;

	@Autowired
	private ActorRepository actorRepository;

//	@Override
//	public Movie create(MovieRequestDto movieRequestDto) {
//		Movie movie = movieMapper.convertRequestDtoToEntity(movieRequestDto);
//
//		// Vérifier si movieRevenue existe
//		MovieRevenue movieRevenue = movieRevenueRepository.findById(movieRequestDto.getMovieRevenueId())
//				.orElseThrow(() -> new IllegalArgumentException("MovieRevenue not found"));
//		movie.setMovieRevenue(movieRevenue);
//
//		// Vérifier si le réalisateur existe
//		Director director = directorRepostiory.findById(movieRequestDto.getDirectorId())
//				.orElseThrow(() -> new IllegalArgumentException("director not found"));
//		movie.setDirector(director);
//
//		// Récupérer et définir les acteurs
//		Set<Integer> actorIds = movieRequestDto.getActors().stream().map(Actor::getId).collect(Collectors.toSet());
//		List<Actor> actors = actorRepository.findAllById(actorIds);
//		movie.setActors(actors);
//
//		movieRepository.save(movie);
//
//		return movieRepository.save(movie);
//	}

	@Override
	public Page<Movie> findAllMovies(Integer page, Integer pageSize) {

		return movieRepository.findAll(PageRequest.of(page, pageSize));
	}

	@Override
	public MovieResponseDto findById(Integer id) {
		Movie movieOptional = movieRepository.findById(id).orElseThrow(()-> new DataException("movie  not found", HttpStatus.NOT_FOUND.toString()));

		return movieMapper.convertEntityToResponseDto(movieOptional);
	}

	@Override
	public void deleteMovieId(Integer id) {
		Movie movieOptional = movieRepository.findById(id).orElseThrow(()-> new DataException("movie  not found", HttpStatus.NOT_FOUND.toString()));
		
		movieRepository.delete(movieOptional);
	}

	@Override
	@Transactional
	public Movie updateMovie(Integer id, MovieRequestDto movieRequestDto) {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Movie not found"));
		
		log.info("====> 1  {} : ",movie );
		movie.setName(movieRequestDto.getName());
		movie.setLength(movieRequestDto.getLength());
		movie.setReleaseDate(movieRequestDto.getReleaseDate());
		movie.setAgeCertificate(movieRequestDto.getAgeCertificate());
		movie.setStatus(movieRequestDto.getStatus());
		log.info("====> 2  {} : ",movie );

		MovieRevenue movieRevenue = movie.getMovieRevenue();
	    movieRevenue.setDomesticTakings(movieRequestDto.getMovieRevenue().getDomesticTakings());
	    movieRevenue.setInternationalTakings(movieRequestDto.getMovieRevenue().getInternationalTakings());
	    movie.setMovieRevenue(movieRevenue);
		log.info("====> 3  {} : ",movie );

	    Director director = directorRepostiory.findById(movieRequestDto.getDirector().getId())
	            .orElseThrow(() -> new IllegalArgumentException("Director not found"));
	    movie.setDirector(director);
		log.info("====> 4  {} : ",movie );

	    Set<Integer> actorIds = movieRequestDto.getActors().stream().map(RequestIdDto::getId).collect(Collectors.toSet());
	    List<Actor> actors = actorRepository.findAllById(actorIds);
	    movie.setActors(actors);
		log.info("====> 5  {} : ",movie );
		return movieRepository.save(movie);
	}

	@Override
	@Transactional
	public Movie create(MovieRequestDto movieRequestDto) {
		Movie movieRequest = movieMapper.convertRequestDtoToEntity(movieRequestDto);
		movieRequest.getMovieRevenue().setId(null);
		Set<Integer> actorIds = movieRequest.getActors().stream().map(Actor::getId).collect(Collectors.toSet());
		List<Actor> actors = actorRepository.findAllById(actorIds);
		movieRequest.setActors(actors);
		try {
			return movieRepository.save(movieRequest);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataException("Movie already exists", HttpStatus.BAD_REQUEST.toString());
	    }
	}

}
