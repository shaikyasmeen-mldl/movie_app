package com.rakuten.training.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.training.dal.MovieDAO;
import com.rakuten.training.domain.Movie;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDAO dao; // =new ProductDAOInMemimpl();
	//EntityManager em;

	@Override
	
	public void setDao(MovieDAO dao) {
		this.dao = dao;
	}

	@Override
	public int addNewMovie(Movie toBeAdded) {
		if (toBeAdded.getYear() <= 2021) {

			Movie saved = dao.save(toBeAdded);
			return saved.getId();
		}

		else {
			throw new IllegalArgumentException("The year is greater than 2021");
		}
	}

	@Override
	public List<Movie> findAll() {
		return dao.findAll();
	}

	@Override
	public Movie findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Movie>  findByActor(String actor) {
		
		return dao.findByActor(actor);
		
	}
	@Override
	public List<Movie>  findByGenre(String genre) {
		
		return dao.findByGenre(genre);
		
	}



}
