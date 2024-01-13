package com.lambdaAndSpring.screenmatch.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesR (
		@JsonAlias("Title") String title,
		@JsonAlias("imdbRating") String avaliation, 
		@JsonAlias("totalSeasons") String sesons,
		@JsonAlias("Genre")String genre,
		@JsonAlias("Actors")String actors,
		@JsonAlias("Poster")String poster,
		@JsonAlias("Plot")String plot)
{

}
