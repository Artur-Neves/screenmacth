package com.lambdaAndSpring.screenmatch.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@JsonIgnoreProperties(ignoreUnknown = true)
public record SeasonR (@JsonAlias("Season") 
					  Integer number, 
					@JsonAlias("Episodes")List<EpisodeR> episodies) {

}
