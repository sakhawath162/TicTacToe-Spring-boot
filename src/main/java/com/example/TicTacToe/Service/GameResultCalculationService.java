package com.example.TicTacToe.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameResultCalculationService {
	@Autowired
	TicTacToeService gameService;

	public String resultOfTheGame(String[][]moves,int n) {
		String winnerByRow = "";
		String winnerByColumn = "";
		String winnerByLeftDiagonal = "";
		String winnerByRightDiagonal = "";
		List<String> winningMoves = new ArrayList<>();
		
		winnerByRow = gameService.winnerOfTheGameByRow(moves,n);
		
		if(winnerByRow != null) {
			winningMoves.add(winnerByRow);
		}
		
		winnerByColumn = gameService.winnerOfTheGameByColumn(moves,n);
		
		if(!winningMoves.isEmpty() && winnerByColumn != null) {
			return "Duplicate";
		}
		
		if(winnerByColumn != null) {
			winningMoves.add(winnerByColumn);
		}
		
		winnerByLeftDiagonal = gameService.winnerOfTheGameByLeftDiagonal(moves,n);
		
		if(!winningMoves.isEmpty() && winnerByLeftDiagonal != null) {
			return "Duplicate";
		}
		
		if(winnerByLeftDiagonal != null) {
			winningMoves.add(winnerByLeftDiagonal);
		}
		
		winnerByRightDiagonal = gameService.winnerOfTheGameByRightDiagonal(moves,n);
		
		if(!winningMoves.isEmpty() && winnerByRightDiagonal != null) {
			return "Duplicate";
		}
		
		if(winnerByRightDiagonal != null) {
			winningMoves.add(winnerByRightDiagonal);
		}

		if(winningMoves.isEmpty()) {
			return null;
		}
		int result =  winningMoves.indexOf("CIRCLE");
		System.out.println(result);
		return  null;
	}
}
