package com.example.TicTacToe.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.TicTacToe.Dao.Game;
import com.example.TicTacToe.Dao.GameResult;
import com.example.TicTacToe.Service.GameResultCalculationService;
import com.example.TicTacToe.Service.TicTacToeService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/ticTacToe")
public class TicTacToeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToeController.class);
	@Autowired
	TicTacToeService gameService;
	@Autowired
	GameResultCalculationService resultService;
	
	@PostMapping("/gameWinner")
	public ResponseEntity<GameResult> resultOfTheGame(@RequestBody Game game){
		GameResult matchResult = new GameResult();
		int n = game.getSize();
		String result = "";
		if(n == 0) {
			n = 3;
		}
		String[][] board = new String[n][n];
		
		try {
			
			for(int i=0;i<game.getMoves().length;i = i+3) {
				board[(int) game.getMoves()[i+1]][(int) game.getMoves()[i+2]] = (String) game.getMoves()[i];
			}
			
			int commands = game.getNumberOfCommands(board);
			
			result = resultService.resultOfTheGame(board, n);
			
			if(commands<5) { // for matching whole row or column formula (n+n-1)
				matchResult.setMessage("Match in progress");
				return new ResponseEntity<>(matchResult,HttpStatus.OK);
			}else if(commands >= 5 && commands < n*n) {
				if(result == null) {
					matchResult.setMessage("Match in progress");
					return new ResponseEntity<>(matchResult, HttpStatus.OK);
				}
			}
			LOGGER.info("Result found {}", result);
			
			if(result == null || result == "DRAW") {
				LOGGER.info("THE GAME IS DRAW");
				matchResult.setMessage("Draw");
				return new ResponseEntity<>(matchResult, HttpStatus.OK);
			}else if(result.equals("Duplicate")) {
				LOGGER.info("DUPLICATE WINNERS FOUND");
				matchResult.setMessage("Duplicate winners!");
				return new ResponseEntity<>(matchResult, HttpStatus.OK);
			}
			
			LOGGER.info("Game winner : {}", result);
			matchResult.setMessage(result + " wins!");
			return new ResponseEntity<>(matchResult, HttpStatus.OK);
			
		}catch(Exception e) {
			LOGGER.error("Exception Thrown {}", e.getLocalizedMessage());
			matchResult.setMessage(e.getLocalizedMessage());
			return new ResponseEntity<>(matchResult,HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
}
