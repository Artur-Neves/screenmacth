package com.lambdaAndSpring.screenmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lambdaAndSpring.screenmatch.model.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {
	
}
