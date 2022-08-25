package com.project.NBATeams.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.NBATeams.exceptions.TeamNotFoundID;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler
	(value = TeamNotFoundID.class)
	   public ResponseEntity<Object> exception(TeamNotFoundID exception) {
	      return new ResponseEntity<>("Book Not Found. Please enter the right ID", HttpStatus.NOT_FOUND);
	   }
}

