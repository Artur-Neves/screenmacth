package com.lambdaAndSpring.screenmatch.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lambdaAndSpring.screenmatch.model.Episodes;

public interface EpisodesRepository extends JpaRepository<Episodes, Integer> {
	
}
