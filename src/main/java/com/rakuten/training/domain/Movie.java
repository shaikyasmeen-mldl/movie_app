package com.rakuten.training.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	int id;
	@Column(name = "movie_name")
	String name;
	@Column(name = "movie_year")
	int year;
	@Column(name = "movie_actor")
	String actor ;
	@Column(name = "movie_genre")
	String genre;
	@Column(name = "movie_poster")
	String poster ;
	@JsonIgnore
//	@OneToMany(cascade = CascadeType.REMOVE)
//	@JoinColumn(name = "pid")
//	List<Review> reviews = new ArrayList<>();
	
	public Movie() {
		
	}

	public Movie(String name, int year, String actor,String genre,String poster) {
		super();
		this.name = name;
		this.year = year;
		this.actor= actor;
		this.genre=genre;
		this.poster=poster;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", year=" + year + ", actor=" + actor +", genre=" +genre+", poster="+poster+"]";
	}


}



