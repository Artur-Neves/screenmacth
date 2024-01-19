package com.lambdaAndSpring.screenmatch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lambdaAndSpring.screenmatch.enums.Categorys;
import com.lambdaAndSpring.screenmatch.model.Series;
@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {
	Optional<Series> findFirstByTitleContainingIgnoreCase(String title);

	List<Series> findByActorsContainingIgnoreCase(String name);

	List<Series> findByActorsContainingIgnoreCaseAndAvaliationGreaterThan(String name, double d);
	
	@Query("select s from Series s where s.sesons <= :seasons and s.avaliation >= :avaliation")
	List<Series>findBySesonsLessThanEqualAndAvaliationGreaterThanEqual(Integer seasons, Double avaliation); 
	
	List<Series> findTop5ByOrderByAvaliationDesc();

	List<Series> findByGenre(Categorys Categorys);
	
	List<Series> findTop5ByOrderBySeasonsEpisodiesDataLancamentoDesc();
}
