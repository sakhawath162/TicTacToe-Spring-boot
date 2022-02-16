package com.example.TicTacToe.Interface;


public interface TicTacToeInterface {
	public String winnerOfTheGameByRow(String[][]moves, int n) throws Exception;
	public String winnerOfTheGameByColumn(String[][]moves, int n) throws Exception;
	public String winnerOfTheGameByLeftDiagonal(String[][]moves, int n) throws Exception;
	public String winnerOfTheGameByRightDiagonal(String[][]moves, int n) throws Exception;

}
