package com.lambdaAndSpring.screenmatch.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lambdaAndSpring.screenmatch.dto.SeriesDTO;
import com.lambdaAndSpring.screenmatch.model.Series;
import com.lambdaAndSpring.screenmatch.repository.SeriesRepository;

@RestController
@RequestMapping(value = "/series")
public class SerieController {
	@Autowired
	SeriesRepository repository;

	@GetMapping()
	public List<SeriesDTO> getSeries() {
		return repository.findAll().stream().map( u->
				 new SeriesDTO(u.getId(), u.getTitle(), u.getAvaliation(), u.getSesons(), u.getGenre(), 
						 u.getActors(), u.getPoster(), u.getPlot())).collect(Collectors.toList());
	}

}
