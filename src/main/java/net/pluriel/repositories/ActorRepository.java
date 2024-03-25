package net.pluriel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.pluriel.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>{

}
