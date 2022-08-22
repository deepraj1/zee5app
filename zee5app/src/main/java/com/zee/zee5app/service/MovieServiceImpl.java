package com.zee.zee5app.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.enums.Genre;
import com.zee.zee5app.exceptions.InvalidNameException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;
import com.zee.zee5app.repo.MovieRepository;


@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepo;

	@Override
	public Optional<Movie> insertMovie(Movie movie) throws UNableToGenerateIdException, FileNotFoundException {
	
		return Optional.ofNullable(movieRepo.save(movie));
	}
	
	

	@Override
	public Optional<Movie> updateMovie(String movieId, Movie movie) throws NoDataFoundException {
		// TODO Auto-generated method stub
//		return null;
	
//		return movieRepo.updateMovie(movieId, movie);
		
		return Optional.ofNullable(movieRepo.save(movie));
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
//		return null;
		return movieRepo.findById(movieId);
	}

	@Override
	public Optional<List<Movie>> getAllMovies() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepo.findAll());
	}

	@Override
	public Optional<List<Movie>> getAllMoviesByGenre(String genre) {
		// TODO Auto-generated method stub
//		return movieRepo.getAllMoviesByGenre(genre);
		return Optional.ofNullable(movieRepo.findAllByGenre(genre));
	}

	@Override
	public Optional<List<Movie>> getAllMoviesByName(String movieName) {
		// TODO Auto-generated method stub
//		return movieRepo.findby(movieName);
		return Optional.ofNullable(movieRepo.findBymovieName(movieName));
	}

	@Override
	public Optional<Movie> deleteMovieByMovieId(String movieId) throws NoDataFoundException {
		// TODO Auto-generated method stub
//		return null;
		return movieRepo.findById(movieId);
	}


	@Override
	public Optional<List<Movie>> findByOrderByMovieNameDsc() throws InvalidNameException{
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
