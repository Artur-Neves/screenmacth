package com.lambdaAndSpring.screenmatch.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lambdaAndSpring.screenmatch.model.Season;

public interface SeasonRepository extends JpaRepository<Season, Integer> {
	
}
