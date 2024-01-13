package com.lambdaAndSpring.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodeR(@JsonAlias("Title")  String title,
			@JsonAlias("Episode") Integer number,
			@JsonAlias("imdbRating") String avaliation,
			@JsonAlias("Released") String dataLancamento) {

}
