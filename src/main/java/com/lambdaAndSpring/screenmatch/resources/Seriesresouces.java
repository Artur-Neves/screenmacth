package com.lambdaAndSpring.screenmatch.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lambdaAndSpring.screenmatch.enums.Categorys;
import com.lambdaAndSpring.screenmatch.model.Episodes;
import com.lambdaAndSpring.screenmatch.model.Season;
import com.lambdaAndSpring.screenmatch.model.SeasonR;
import com.lambdaAndSpring.screenmatch.model.Series;
import com.lambdaAndSpring.screenmatch.model.SeriesR;
import com.lambdaAndSpring.screenmatch.repository.EpisodesRepository;
import com.lambdaAndSpring.screenmatch.repository.SeasonRepository;
import com.lambdaAndSpring.screenmatch.repository.SeriesRepository;
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
	@Autowired
	private EpisodesRepository episodeRepository;

	public void showMenu() {
		Integer optional =-1;
		while(optional!=0) {
			 String menu = """
	                1 - Buscar séries
	                2 - Buscar episódios
	                3 - Listar séries
	                4 - Procurar séries pelo título
	                5 - Procurar series pelo autor
	                6 - Top 5 series
	                7 - Buscar por categoria
	                8 - Buscar por temporadas e por avaliação
	                9 - Buscar episódio por trecho
	                10 - Top 5 episodio de alguma serie	                
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
	            case 4:
	            	listForTitle();
	            	break;
	            case 5:
	            	listSeriesForAuthor();
	            	break;
	            case 6:
	            	listTop5Series();
	            	break;
	            case 7:
	            	listForCategory();
	            	break;
	            case 8:
	            	listForAvaliationAndSeasons();
	            	break;
	            case 9:
	            	listEpisodesForTrecho();
	            	break;
	            case 10:
	            	listTop5Episodes();
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
	Series serie =  getDataSerie();
	repository.save(serie);
	System.out.println(serie);
	}
	private Series getDataSerie() {
		System.out.println("Digite o nome de uma série que deseja assistir");
		String serieName = s.nextLine().replace(" ", "+");
	    json =api.getData(ADDRESS+serieName+API_KEY);
	    serie = new Series( datas.getDatas(json, SeriesR.class));
	    List<Season> seansos = new ArrayList<>();
		for (int i =1; i<=serie.getSesons(); i++) {
			json = api.getData(ADDRESS+serie.getTitle().replace(" ", "+")+SEASON+i+API_KEY);
			seansos.add(new Season(serie, datas.getDatas(json, SeasonR.class)));
			System.out.println();
		}
		serie.getSeasons().addAll(seansos);
		return serie;
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
			listSeries = repository.findAll();
			listSeries.forEach(System.out::println);
		}
		private Optional<Series> listForTitle() {
			System.out.println("Digite o nome de uma série que deseja assistir");
			var serieTitle = s.nextLine();
		 Optional<Series> serieOptional = repository.findFirstByTitleContainingIgnoreCase(serieTitle);
		 System.out.println((serieOptional.isPresent()) ? "Os dados da serie são"+ serieOptional.get(): "serie não encontrada");
		 return serieOptional;
		}
		private void listSeriesForAuthor() {
			System.out.println("Digite o nome de um autor");
			String name = s.nextLine();
			List<Series> seriesForAuthor = repository.findByActorsContainingIgnoreCaseAndAvaliationGreaterThan(name, 8.5);
			seriesForAuthor.forEach(u -> System.out.println(
					"title: "+ u.getTitle()+
					" nota: "+u.getAvaliation()
					));
			
			
		}
		private void listTop5Series() {
			System.out.println("Os top 5 filmes da tua lista");
		List<Series> listTop5 = repository.findTop5ByOrderByAvaliationDesc();
		listTop5.forEach(u -> System.out.println(
				"title: "+ u.getTitle()+
				" nota: "+u.getAvaliation()
				));
		}
		
		private void listForCategory() {
		System.out.println("Digite o nome do gênero que deseja buscar");
		String genre = s.nextLine();
		List<Series> listForCategory =repository.findByGenre(Categorys.fromCategoryInPortugues(genre));
		listForCategory.forEach(u ->  System.out.println("genêro: "+u.getGenre()+ "  Título: "+u.getTitle()));
		}
		
		private void listForAvaliationAndSeasons() {
			System.out.println("Digite a quantidade de temporadas m:");
			Integer season = s.nextInt();
			System.out.println("Digite o numero de avalições mínimas:");
			Double avaliation = s.nextDouble();
			List<Series> listForSeansonAndAvaliation = repository.findBySesonsLessThanEqualAndAvaliationGreaterThanEqual(season, avaliation);
			listForSeansonAndAvaliation.stream().map(u -> u.getTitle()).forEach(System.out::println);
		}
		
		private void listEpisodesForTrecho() {
			System.out.println("Digite o trecho do titulo do episodio que deseja encontrar");
			String excerpt = s.nextLine();
			List<Episodes> listEpisodes = episodeRepository.listEpisodesContaing(excerpt);
			listEpisodes.forEach(e ->
            System.out.printf("Série: %s Temporada %s - Episódio %s - %s\n",
                    e.getSeason().getSerie().getTitle(), e.getSeason().getNumber(),
                    e.getNumber(), e.getTitle()));
		}
		
		private void listTop5Episodes() {
			Optional<Series> serie = listForTitle();
			if (serie.isPresent()) {
			
			List<Episodes> listEpisodesTop5 = episodeRepository.listSomeEpisodes(serie.get());
			listEpisodesTop5.forEach(e ->
            System.out.printf("Série: %s Temporada %s - Episódio %s - Avaliation %s - %s\n",
                    e.getSeason().getSerie().getTitle(), e.getSeason().getNumber(),
                    e.getNumber(), e.getAvaliation(),  e.getTitle()));
			}}



	}
