package com.example.TicTacToe.Dao;

public class Game {
	
	private int size;
	private Object[] moves;

	public int getSize() {
		return size;
	}

	public void setSquareSize(int size) {
		this.size = size;
	}

	public Object[] getMoves() {
		return moves;
	}

	public void setMoves(Object[] moves) {
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
