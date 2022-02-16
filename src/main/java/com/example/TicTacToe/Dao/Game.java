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
	
}
