package com.rakuten.training;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.training.dal.MovieRepository;
import com.rakuten.training.domain.Movie;


import com.rakuten.training.service.MovieService;


@SpringBootApplication
public class MovieAppApplication {

	public static void main(String[] args) {
		
		
			ApplicationContext springContainer = 
				SpringApplication.run(MovieAppApplication.class, args);
			
//			ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
//			ui.createProductWithUI();
			
		//testReviewOps(springContainer);
		
	//	testRepository(springContainer);
		//testMovieQueries(springContainer);
		}
//	private static void testRepository(ApplicationContext springContainer) {
//		MovieRepository repo=springContainer.getBean(MovieRepository.class);
//		Movie m=new Movie("Anabella",2009,"warren","horror","http:");
//		repo.save(m);
//	}

//		private static void testMovieQueries(ApplicationContext springContainer) {
//			MovieService service = springContainer.getBean(MovieService.class);
//			List<Movie> all = service.findAll();
//			System.out.println("There are "+all.size()+" movies:");
//			all.forEach(System.out::println);
//			
//		}
		
	

}


