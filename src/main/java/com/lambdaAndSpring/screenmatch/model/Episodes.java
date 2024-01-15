package com.lambdaAndSpring.screenmatch.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.lambdaAndSpring.screenmatch.util.Utils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Episodes implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne()
	@JoinColumn(name = "season_id")
	private Season season;
	private Integer number;
	private String title;
	private Double avaliation;
	private LocalDate dataLancamento;
	
	public Episodes() {
	}
	
	

	public Episodes(Season season, String title, Integer number, Double avaliation, LocalDate dataLancamento) {
		super();
		this.season = season;
		this.title = title;
		this.number = number;
		this.avaliation = avaliation;
		this.dataLancamento = dataLancamento;
	}

	public Episodes(Season seanso, EpisodeR episodie) {
		this.season = seanso;
		this.title = episodie.title();
		this.number = episodie.number();
		this.avaliation = Utils.tryParseToDouble(episodie.avaliation());
		this.dataLancamento = Utils.tryParseToLocalDate(episodie.dataLancamento());
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Season getSeason() {
		return season;
	}
	public void setSeason(Season season) {
		this.season = season;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getAvaliation() {
		return avaliation;
	}



	public void setAvaliation(Double avaliation) {
		this.avaliation = avaliation;
	}



	public LocalDate getDataLancamento() {
		return dataLancamento;
	}



	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}



	@Override
	public int hashCode() {
		return Objects.hash(avaliation, dataLancamento, number, season, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Episodes other = (Episodes) obj;
		return Objects.equals(avaliation, other.avaliation) && Objects.equals(dataLancamento, other.dataLancamento)
				&& Objects.equals(number, other.number) && Objects.equals(season, other.season)
				&& Objects.equals(title, other.title);
	}



	@Override
	public String toString() {
		return "Episodes [season=" + season.getNumber() + ", title=" + title + ", number=" + number 
				+ ", dataLancamento=]";
	}
	
	
}
