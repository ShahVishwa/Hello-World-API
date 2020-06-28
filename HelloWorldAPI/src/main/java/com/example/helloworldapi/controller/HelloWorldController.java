package com.example.helloworldapi.controller;

import java.sql.Timestamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private static final Logger logger = LogManager.getLogger(HelloWorldController.class);
	private String message;

	@RequestMapping("/")
	public String hello() {
		logger.debug(
				"Calling GET request without an accept header" + " at: " + new Timestamp(System.currentTimeMillis()));
		this.message = "<p>Hello, World</p>";
		return message;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json", consumes = "text/html")
	@ResponseBody
	public String helloWithAcceptHeader() {
		logger.debug("Calling GET request with an accept header as: " + new HttpHeaders() + " at: "
				+ new Timestamp(System.currentTimeMillis()));
		this.message = "{'message' : 'Hello, World'}";
		return message;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = MediaType.ALL_VALUE)
	public ResponseEntity<String> postMethod(@RequestBody String message) {
		logger.debug("Calling POST request with an accept header as: " + new HttpHeaders() + " at: "
				+ new Timestamp(System.currentTimeMillis()));
		if (!message.equals("")) {
			this.message = message;
			return new ResponseEntity<String>("Message was: " + message, new HttpHeaders(), HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
}
