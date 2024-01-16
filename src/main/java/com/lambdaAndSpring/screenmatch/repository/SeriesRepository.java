package com.lambdaAndSpring.screenmatch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lambdaAndSpring.screenmatch.model.Series;
@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {
	Optional<Series> findFirstByTitleContainingIgnoreCase(String title);

	List<Series> findByActorsContainingIgnoreCase(String name);

	List<Series> findByActorsContainingIgnoreCaseAndAvaliationGreaterThan(String name, double d);

	List<Series> findTop5ByOrderByAvaliationDesc();
}
