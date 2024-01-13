package com.lambdaAndSpring.screenmatch.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lambdaAndSpring.screenmatch.model.Series;

public interface SeriesRepository extends JpaRepository<Series, Integer> {
	
}
