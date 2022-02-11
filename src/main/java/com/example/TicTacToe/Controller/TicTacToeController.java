package com.example.TicTacToe.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticTacToe")
public class TicTacToeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToeController.class);
	
	@PostMapping("/gameWiner")
	public ResponseEntity<String> resultOfTheGame(@RequestBody String[][]moves){
		
		try {
			
			
		}catch(Exception e) {
			LOGGER.error("Exception Thrown {}", e.getLocalizedMessage());
			return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.EXPECTATION_FAILED);
		}
		
		return null;
		
	}
	
}
