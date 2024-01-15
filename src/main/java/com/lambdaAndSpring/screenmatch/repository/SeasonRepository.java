package com.lambdaAndSpring.screenmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lambdaAndSpring.screenmatch.model.Season;

public interface SeasonRepository extends JpaRepository<Season, Long> {
	
}
