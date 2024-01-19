package com.lambdaAndSpring.screenmatch.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambdaAndSpring.screenmatch.dto.SeriesDTO;
import com.lambdaAndSpring.screenmatch.model.Series;
import com.lambdaAndSpring.screenmatch.repository.SeriesRepository;

@Service
public class SeriesService {
	@Autowired
	private SeriesRepository repository;
	
	public List<SeriesDTO> getAllSeries(){
		return convertsData(repository.findAll());
	}

	public List<SeriesDTO> geTop5Series() {
		return convertsData(repository.findTop5ByOrderByAvaliationDesc());
	}
	public List<SeriesDTO> getTop5EpisodesForDate() {
		return convertsData(repository.findTop5ByOrderBySeasonsEpisodiesDataLancamentoDesc());
	}
	
	private List<SeriesDTO> convertsData(List<Series> list){
		return list.stream().map( u->
		 new SeriesDTO(u.getId(), u.getTitle(), u.getAvaliation(), u.getSesons(), u.getGenre(), 
				 u.getActors(), u.getPoster(), u.getPlot())).collect(Collectors.toList());
	}

}
