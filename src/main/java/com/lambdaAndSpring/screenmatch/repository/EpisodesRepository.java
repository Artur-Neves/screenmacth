package com.lambdaAndSpring.screenmatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lambdaAndSpring.screenmatch.model.Episodes;
import com.lambdaAndSpring.screenmatch.model.Series;

public interface EpisodesRepository extends JpaRepository<Episodes, Long> {
	@Query("Select e from Episodes e where e.title ILIKE %:trecho%")
	List<Episodes> listEpisodesContaing(String trecho);
	@Query("SELECT e FROM Episodes e WHERE e.season.serie = :series AND e.avaliation IS NOT NULL ORDER BY e.avaliation DESC LIMIT 5")
	List<Episodes> listSomeEpisodes(Series series);
}
