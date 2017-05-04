package com.sg.compliance.xborder.web.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value=IllegalArgumentException.class)
	public void handle(IllegalArgumentException ex, HttpServletResponse response) throws IOException {
		response.sendError(400, ex.getMessage());
	}
	
	@ExceptionHandler(value= FileNotFoundException.class)
	public void handle(FileNotFoundException ex, HttpServletResponse response) throws IOException {
		response.sendError(400, ex.getMessage());
	}
	
	@ExceptionHandler(value= IOException.class)
	public void handle(IOException ex, HttpServletResponse response) throws IOException {
		response.sendError(500, ex.getMessage());
	}
}
