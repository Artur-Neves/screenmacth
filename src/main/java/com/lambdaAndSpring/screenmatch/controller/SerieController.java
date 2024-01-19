package com.lambdaAndSpring.screenmatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lambdaAndSpring.screenmatch.dto.SeriesDTO;
import com.lambdaAndSpring.screenmatch.service.SeriesService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/series")
public class SerieController {
	@Autowired
	SeriesService service;

	@GetMapping()
	public List<SeriesDTO> getSeries() {
		return service.getAllSeries();
	}
	@GetMapping("/top5")
	public List<SeriesDTO> getTop5Series() {
		return service.geTop5Series();
	}
	@GetMapping("/lancamentos")
	public List<SeriesDTO> getTopEpisodesforDate(){
		return service.getTop5EpisodesForDate();
	}
	

}
