package com.example.TicTacToe.Service;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameResultCalculationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GameResultCalculationService.class);

	@Autowired
	TicTacToeService gameService;

	public String resultOfTheGame(String[][]moves,int n) throws Exception{
		String winnerByRow = "";
		String winnerByColumn = "";
		String winnerByLeftDiagonal = "";
		String winnerByRightDiagonal = "";
		List<String> winningMoves = new ArrayList<>();
		
		LOGGER.info("Checking the result Service");
		
		try {
			winnerByRow = gameService.winnerOfTheGameByRow(moves,n);

			if(winnerByRow != null) {
				winningMoves.add(winnerByRow);
			}if(winnerByRow == "DRAW"){
				return winningMoves.toArray()[0].toString();
			}
			
			winnerByColumn = gameService.winnerOfTheGameByColumn(moves,n);

			if(!winningMoves.isEmpty() && winnerByColumn != null && !winningMoves.contains(winnerByColumn)) {
				return "Duplicate";
			}
			
			if(winnerByColumn != null) {
				winningMoves.add(winnerByColumn);
			}	
			if(winnerByColumn == "DRAW") {
				return winningMoves.toArray()[0].toString();
			}
			
			winnerByLeftDiagonal = gameService.winnerOfTheGameByLeftDiagonal(moves,n);

			if(!winningMoves.isEmpty() && winnerByLeftDiagonal != null && !winningMoves.contains(winnerByLeftDiagonal)) {
				return "Duplicate";
			}
			
			if(winnerByLeftDiagonal != null) {
				winningMoves.add(winnerByLeftDiagonal);
			}
			if(winnerByLeftDiagonal == "DRAW") {
				return winningMoves.toArray()[0].toString();
			}
			
			winnerByRightDiagonal = gameService.winnerOfTheGameByRightDiagonal(moves,n);
			
			if(!winningMoves.isEmpty() && winnerByRightDiagonal != null && !winningMoves.contains(winnerByRightDiagonal)) {
				return "Duplicate";
			}
			
			if(winnerByRightDiagonal != null) {
				winningMoves.add(winnerByRightDiagonal);
			}
			if(winnerByRightDiagonal == "DRAW") {
				return winningMoves.toArray()[0].toString();
			}

			if(winningMoves.isEmpty()) {
				return null;
			}
			return winningMoves.toArray()[0].toString();
		}catch(Exception e) {
			LOGGER.error("Exception Thrown {}", e);
			throw e;
		}
	}
}
