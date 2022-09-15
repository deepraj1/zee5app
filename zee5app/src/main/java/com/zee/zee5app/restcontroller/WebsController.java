package com.zee.zee5app.restcontroller;

import java.io.FileNotFoundException;

import javax.validation.Valid;

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
import com.zee.zee5app.dto.WebSeries;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.WebSeriesService;

@RestController
@RequestMapping("api/webs")
public class WebsController {
	@Autowired
	WebSeriesService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> insertWebs(@Valid @RequestBody WebSeries webs) throws FileNotFoundException, UNableToGenerateIdException{
		System.out.println(webs.toString());
		WebSeries series = service.insertWebs(webs);
		return ResponseEntity.status(HttpStatus.CREATED).body(series);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getWebsById(@PathVariable("id") String websId){
		WebSeries series = service.getWebsByWebsId(websId).get();
		return ResponseEntity.status(HttpStatus.OK).body(series);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMoviebyMovieId(@PathVariable("id") String websId) throws NoDataFoundException{
		String series = service.deleteWebsByWebsId(websId);
		return ResponseEntity.status(HttpStatus.OK).body(series);
	}

}
