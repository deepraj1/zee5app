package com.zee.zee5app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zee.zee5app.dto.Movie;

//import antlr.collections.List;

public interface MovieRepository extends JpaRepository<Movie, String> {
	
	public List<Movie> findBymovieName(String movieName);
	public List<Movie> findAllByGenre(String genre);

}
