package com.rakuten.training.dal;

import java.util.ArrayList;
import java.util.List;

import com.rakuten.training.domain.Movie;


public interface MovieDAO {


	public Movie save(Movie toBeSaved);
	public List<Movie> findAll();
	public Movie findById(int id);
	public List<Movie> findByActor(String actor);
	public List<Movie> findByGenre(String genre);
	
}
