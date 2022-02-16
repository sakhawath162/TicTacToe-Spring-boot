package com.example.TicTacToe.Dao;

public class Game {
	
	private int squareSize;
	private String[][] moves;

	public int getSquareSize() {
		return squareSize;
	}

	public void setSquareSize(int squareSize) {
		this.squareSize = squareSize;
	}

	public String[][] getMoves() {
		return moves;
	}

	public void setMoves(String[][] moves) {
		this.moves = moves;
	}
	
	public int getNumberOfCommands(String[][]moves) {
		int count = 0;
		for(int i=0;i<moves.length;i++) {
			for(int j=0;j<moves.length;j++) {
				if(moves[i][j] != null) {
					count++;
				}
			}
		}
		return count;
	}
	
}
