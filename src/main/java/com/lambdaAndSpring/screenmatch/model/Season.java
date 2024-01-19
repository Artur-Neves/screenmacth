package com.lambdaAndSpring.screenmatch.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Season implements Serializable{
	  private static final long serialVersionUID = 1L;
	@Id 
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  private List<Episodes> episodies = new ArrayList<>();
	  @ManyToOne()
	  @JoinColumn(name = "serie_id")
	  private Series serie;
	  private Integer number;
	
	  
	  public Season() {
		super();
	}
	  
	  public Season(Series serie, SeasonR seansoR) {
		    this.serie = serie;
		    this.number = seansoR.number();
			this.episodies = seansoR.episodies().stream().map(u -> new Episodes(this, u)).collect(Collectors.toList());
		
	  }

	public Season(Integer number, List<Episodes> episodies, Series serie) {
		super();
		this.number = number;
		this.episodies = episodies;
		this.serie = serie;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	


	public List<Episodes> getEpisodies() {
		return episodies;
	}

	public Series getSerie() {
		return serie;
	}


	public void setSerie(Series serie) {
		this.serie = serie;
	}


	@Override
	public int hashCode() {
		return Objects.hash(number);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Season other = (Season) obj;
		return Objects.equals(number, other.number);
	}

	@Override
	public String toString() {
		return "Season [number=" + number ;
	}

	
	
	  
	  
}
