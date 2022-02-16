package com.example.TicTacToe.Controller;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.TicTacToe.Dao.Game;
import com.example.TicTacToe.Service.GameResultCalculationService;
import com.example.TicTacToe.Service.TicTacToeService;

@RestController
@RequestMapping("/api/ticTacToe")
public class TicTacToeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToeController.class);
	@Autowired
	TicTacToeService gameService;
	@Autowired
	GameResultCalculationService resultService;
	
	@PostMapping("/gameWinner")
	public ResponseEntity<String> resultOfTheGame(@RequestBody Game game){
		int n = game.getSquareSize();
		String result = "";
		
		try {
			
			if(n == 0) {
				
			}else {
				result = resultService.resultOfTheGame(game.getMoves(), n);
			}
			
			if(result == null) {
				return new ResponseEntity<>("Draw", HttpStatus.OK);
			}else if(result.equals("Duplicate")) {
				return new ResponseEntity<>("Duplicate winners!", HttpStatus.EXPECTATION_FAILED);
			}
			
			return new ResponseEntity<>(result + " wins!", HttpStatus.OK);
			
		}catch(Exception e) {
			LOGGER.error("Exception Thrown {}", e.getLocalizedMessage());
			return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
}
