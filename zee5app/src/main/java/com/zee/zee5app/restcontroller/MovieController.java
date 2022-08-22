package com.zee.zee5app.restcontroller;

import java.io.FileNotFoundException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;
import com.zee.zee5app.service.MovieService;

@RestController
@RequestMapping("/api/movie")

public class MovieController {
	
	@Autowired
	MovieService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> insertMovie(@RequestBody Movie movie) throws FileNotFoundException, UNableToGenerateIdException{
		Movie movie2 = service.insertMovie(movie).get();
		return ResponseEntity.status(HttpStatus.CREATED).body(movie2);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getMovieById(@PathVariable("id") String movieId){
		Movie movie = service.getMovieByMovieId(movieId).get();
		return ResponseEntity.status(HttpStatus.OK).body(movie);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMoviebyMovieId(@PathVariable("id") String movieId) throws NoDataFoundException{
		Movie movie = service.deleteMovieByMovieId(movieId).get();
		return ResponseEntity.status(HttpStatus.OK).body(movie);
	}

}


//{
//    "movieId":"101",
//    "actors":"actors",
//    "movieName":"movie1",
//    "director":"director",
//    "genre":"genre",
//    "production":"production",
//    "languages":"lan",
//    "movieLength":"03:22",
//    "trailer1":"trailer"
//}
