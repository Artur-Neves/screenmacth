package com.lambdaAndSpring.screenmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lambdaAndSpring.screenmatch.model.Episodes;

public interface EpisodesRepository extends JpaRepository<Episodes, Long> {
	
}
