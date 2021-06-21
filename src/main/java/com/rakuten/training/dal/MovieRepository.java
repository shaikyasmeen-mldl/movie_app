package com.rakuten.training.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rakuten.training.domain.Movie;



	

	public interface MovieRepository extends CrudRepository<Movie, Integer> {
		
	}


