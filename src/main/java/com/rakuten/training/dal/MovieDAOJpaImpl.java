package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.domain.Movie;

@Primary
@Repository
@Transactional
public class MovieDAOJpaImpl implements MovieDAO{
	
	@Autowired
	EntityManager em;

	@Override
	public Movie save(Movie toBeSaved) {
		
		em.persist(toBeSaved);
		//toBeSaved ---> Managed/Persistent
		return toBeSaved;
	
		
	}

	@Override
	public List<Movie> findAll() {
		Query q = em.createQuery("select p from Movie as p");
		return q.getResultList();
	}
		
	@Override
	public Movie findById(int id) {
		return em.find(Movie.class, id);
	}
	@Override
	public List<Movie>  findByActor(String actor) {
		Query q=em.createQuery("select p from Movie p where p.actor=:n");
	
		q.setParameter("n","%"+actor+"%");
		return q.getResultList();
		
	}
	@Override
	public List<Movie>  findByGenre(String genre) {
		Query q=em.createQuery("select p from Movie p where p.genre=:n");
	
		q.setParameter("n",genre);
		return q.getResultList();
		
	}



}