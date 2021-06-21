package com.rakuten.training.web;

import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.domain.Movie;

import com.rakuten.training.service.MovieService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MovieController {
	@Autowired
	MovieService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/movies")
	public List<Movie> getAllMovies(){
		return service.findAll();
	}
	
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getById(@PathVariable("id") int id) {
		Movie m = service.findById(id);
		if(m == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Movie>(m, HttpStatus.OK);
		}
	}
	@PostMapping("/movies")
	public ResponseEntity addNewMovie(@RequestBody Movie toBeAdded) {
		try {
			int id = service.addNewMovie(toBeAdded);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/movies/"+id));
			return new ResponseEntity(toBeAdded, headers, HttpStatus.CREATED);
		}catch (IllegalArgumentException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/movies/search/findByActor/{actor}")
	public ResponseEntity getByActorName(@RequestParam("actor") String actor)
	{
	   	List<Movie> l=service.findByActor(actor);
	   	return new ResponseEntity<List<Movie>>(l, HttpStatus.OK);
	   	
	}
	@GetMapping("/movies/genre/{genre}")
	public ResponseEntity getByGenreName(@PathVariable("genre") String genre)
	{
	   	List<Movie> l=service.findByGenre(genre);
	   	return new ResponseEntity<List<Movie>>(l, HttpStatus.OK);
	   	
	}

}
