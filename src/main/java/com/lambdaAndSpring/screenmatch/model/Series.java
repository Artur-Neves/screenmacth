package com.lambdaAndSpring.screenmatch.model;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.lambdaAndSpring.screenmatch.enums.Categorys;
import com.lambdaAndSpring.screenmatch.service.ConsultationGPT;
import com.lambdaAndSpring.screenmatch.util.Utils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Series {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
    private String title;
	private Double avaliation;
	private Integer sesons;
	@Enumerated(EnumType.STRING)
	private Categorys genre;
    private String actors;
    private String poster;
    private String plot;
    @OneToMany(mappedBy = "serie", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Season> seasons = new HashSet<>();
    
    
    
    
    public Series() {
    }



    public Series(SeriesR series) {
    	this.title = series.title();
    	this.poster = series.poster();
    	this.plot = ConsultationGPT.obterTraducao(series.plot()).trim();
    	this.avaliation = Utils.tryParseToDouble(series.avaliation());
    	this.sesons = Utils.tryParseToInteger(series.sesons());
    	this.actors =  series.actors(); 
    	this.genre = Categorys.fromString(series.genre().contains(",") ? series.genre().split(",")[0].trim(): series.genre());
    }

	public Series(String title, Double avaliation, Integer sesons, Categorys genre, String actors, String poster,
			String plot) {
		super();
		this.title = title;
		this.avaliation = avaliation;
		this.sesons = sesons;
		this.genre = genre;
		this.actors = actors;
		this.poster = poster;
		this.plot = plot;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Double getAvaliation() {
		return avaliation;
	}


	public void setAvaliation(Double avaliation) {
		this.avaliation = avaliation;
	}


	public Integer getSesons() {
		return sesons;
	}


	public void setSesons(Integer sesons) {
		this.sesons = sesons;
	}


	public Categorys getGenre() {
		return genre;
	}


	public void setGenre(Categorys genre) {
		this.genre = genre;
	}


	public String getActors() {
		return actors;
	}


	public void setActors(String actors) {
		this.actors = actors;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}


	public String getPlot() {
		return plot;
	}


	public void setPlot(String plot) {
		this.plot = plot;
	}


	@Override
	public int hashCode() {
		return Objects.hash(actors, avaliation, genre, plot, poster, sesons, title);
	}
	
	

	public Set<Season> getSeasons() {
		return seasons;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Series other = (Series) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(avaliation, other.avaliation)
				&& genre == other.genre && Objects.equals(plot, other.plot) && Objects.equals(poster, other.poster)
				&& Objects.equals(sesons, other.sesons) && Objects.equals(title, other.title);
	}


	@Override
	public String toString() {
		return "Series [title=" + title + ",\n avaliation=" + avaliation + ",\n sesons=" + sesons + ",\n genre=" + genre
				+ ",\n actors=" + actors + ",\n poster=" + poster + ",\n plot=" + plot + ",\n seansos:"+seasons +"]";
	}

	
	
	
	
	
    
}
