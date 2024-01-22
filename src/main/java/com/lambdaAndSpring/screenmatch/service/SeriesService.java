package com.lambdaAndSpring.screenmatch.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambdaAndSpring.screenmatch.dto.EpisodesDTO;
import com.lambdaAndSpring.screenmatch.dto.SeriesDTO;
import com.lambdaAndSpring.screenmatch.model.Episodes;
import com.lambdaAndSpring.screenmatch.model.Series;
import com.lambdaAndSpring.screenmatch.repository.EpisodesRepository;
import com.lambdaAndSpring.screenmatch.repository.SeriesRepository;

@Service
public class SeriesService {

	@Autowired
	private SeriesRepository repository;
	
	@Autowired 
	EpisodesRepository episodesRepository;
	
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

	public SeriesDTO findById(Long id) {
		Optional<Series> series = repository.findById(id);
		return (series.isPresent()) ? convertData(series.get()):null ;
	}
	private SeriesDTO convertData(Series series) {
		return new SeriesDTO(series.getId(), series.getTitle(), series.getAvaliation(), 
	         series.getSesons(),series.getGenre() ,series.getActors(), series.getPoster(), series.getPlot());
	}

	public List<EpisodesDTO> FindAllEpisodes(Long id) {
		return episodesRepository.findBySeasonSerieId(id).stream()
				.map(e ->convertEpisodesDTO(e))
				.collect(Collectors.toList());
	}

	public List<EpisodesDTO> findEpisodesForSeason(Long season_id, Long id) {
		return episodesRepository.findBySeasonIdAndSeasonSerieId( season_id,  id).stream()
				.map(e -> convertEpisodesDTO(e)).collect(Collectors.toList());
	}
	private EpisodesDTO convertEpisodesDTO(Episodes e) {
		return new EpisodesDTO(e.getSeason().getNumber(), e.getNumber(), e.getTitle());
	}

}
