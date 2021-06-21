package com.rakuten.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rakuten.training.dal.MovieDAO;
import com.rakuten.training.domain.Movie;


@Service
public interface MovieService {

	public int addNewMovie(Movie toBeAdded);
//	public void removeExisting(int id);
	
	public List<Movie> findAll();
	public Movie findById(int id);
	public List<Movie> findByActor(String actor) ;
	public List<Movie> findByGenre(String genre) ;

	void setDao(MovieDAO dao);
}
