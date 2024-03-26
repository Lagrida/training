package net.pluriel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import net.pluriel.entities.MovieRevenue;

public interface MovieRevenueRepository extends JpaRepository<MovieRevenue, Integer> {

}
