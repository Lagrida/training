package net.pluriel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.pluriel.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie ,Integer>{

}
