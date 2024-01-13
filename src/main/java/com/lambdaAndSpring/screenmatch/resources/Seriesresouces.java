package com.lambdaAndSpring.screenmatch.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lambdaAndSpring.screenmatch.model.Season;
import com.lambdaAndSpring.screenmatch.model.SeasonR;
import com.lambdaAndSpring.screenmatch.model.Series;
import com.lambdaAndSpring.screenmatch.model.SeriesR;
import com.lambdaAndSpring.screenmatch.model.repositories.SeasonRepository;
import com.lambdaAndSpring.screenmatch.model.repositories.SeriesRepository;
import com.lambdaAndSpring.screenmatch.service.ApiCall;
import com.lambdaAndSpring.screenmatch.service.Datas;

@Component
@Service
public class Seriesresouces {
	private Scanner s = new Scanner(System.in);
	private ApiCall api = new ApiCall();
	private final String ADDRESS = "https://www.omdbapi.com/?t=";
	private final String API_KEY= "&apikey=eb96dddd";
	private final String SEASON= "&season=";
	private String json;
	Datas datas = new Datas();
	Series serie;
	List<Series> listSeries = new ArrayList<>();
	@Autowired
	private SeriesRepository repository;
	@Autowired
	private SeasonRepository repositoryseanso;
	
	public void showMenu() {
		Integer optional =-1;
		while(optional!=0) {
			 String menu = """
	                1 - Buscar séries
	                2 - Buscar episódios
	                3 - Listar séries
	                0 - Sair                                 
	                """;

	        System.out.println(menu);
	        optional = s.nextInt();
	           s.nextLine();

	        switch (optional) {
	            case 1:
	               findSerie();
	                break;
	            case 2:
	                findEpisodieForSerie();
	                break;
	            case 3:
	            	listSeries();
	                break;
	            case 0:
	                System.out.println("Saindo...");
	                break;
	            default:
	                System.out.println("Opção inválida");
	        }
	        System.out.println();
		}
		
	}
	
	private void findSerie() {
	Series serie = findEpisodieForSerie();
	listSeries.add(serie);
	System.out.println(serie);
	}
	private Series getDataSerie() {
		System.out.println("Digite o nome de uma série que deseja assistir");
		String serieName = s.nextLine().replace(" ", "+");
	    json =api.getData(ADDRESS+serieName+API_KEY);
		return new Series( datas.getDatas(json, SeriesR.class));
	}
		
		private Series findEpisodieForSerie() {
	    serie = getDataSerie();
		List<Season> seansos = new ArrayList<>();
		for (int i =1; i<=serie.getSesons(); i++) {
			json = api.getData(ADDRESS+serie.getTitle().replace(" ", "+")+SEASON+i+API_KEY);
			seansos.add(new Season(serie, datas.getDatas(json, SeasonR.class)));
			System.out.println();
		}
		serie.getSeasons().addAll(seansos);
		return serie;
	}
		private void listSeries() {
			repository.save(serie);
			listSeries.forEach(System.out::println);
		}

	}
