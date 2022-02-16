package com.example.TicTacToe.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TicTacToe.Interface.TicTacToeInterface;

@Service
public class TicTacToeService implements TicTacToeInterface{

	@Override
	public String winnerOfTheGameByRow(String[][]moves,int n) {
	
		List<String> item = new ArrayList<>();

        for(int i=0; i<n; i++){
            item.clear();
            for(int j=0;j<n;j++){
                item.add(moves[i][j]);
                }
            if(item.contains("CROSS")){
                if(item.contains("CIRCLE")){
                    continue;
                }else if(item.contains(null)){
                    continue;
                }else{
                    return moves[i][0];
                }
            }else if(item.contains("CIRCLE")){
                if(item.contains("CROSS")){
                    continue;
                }else if(item.contains(null)){
                    continue;
                }else{
                    return moves[i][0];
                }
            }
        }
        
        return null;

	}

	@Override
	public String winnerOfTheGameByColumn(String[][] moves, int n) {
		
		List<String> item = new ArrayList<>();

			for(int i=0; i<n; i++){
        	
            item.clear();
            
            for(int j=0;j<n;j++){
                item.add(moves[j][i]);
            }
            
            if(item.contains("CROSS")){
                if(item.contains("CIRCLE")){
                    continue;
                }else if(item.contains(null)){
                    continue;
                }else{
                    return moves[0][i];
                }
            }else if(item.contains("CIRCLE")){
                if(item.contains("CROSS")){
                    continue;
                }else if(item.contains(null)){
                    continue;
                }else{
                    return moves[0][i];
                }
            }
        }
	     return null;
	}

	@Override
	public String winnerOfTheGameByLeftDiagonal(String[][] moves, int n) {
		
		List<String> item = new ArrayList<>();

		 for(int i = 0; i<n ; i++){
	            item.add(moves[i][i]);
	        }
	        if(!item.contains("CROSS")){
	            if(item.contains("CIRCLE")){
	                if(!item.contains(null)){
	                    return moves[0][0];
	                }
	            }
	        }else if(!item.contains("CIRCLE")){
	            if(!item.contains(null)){
	                return moves[0][0];
	            }
	        }
	        	        
	        return null;
	}

	@Override
	public String winnerOfTheGameByRightDiagonal(String[][] moves, int n) {
		List<String> item = new ArrayList<>();

		 for (int i = 0; i<n; i++){
	            item.add(moves[i][n-i-1]);
	        }
	        if(!item.contains("CROSS")){
	            if(item.contains("CIRCLE")){
	                if(!item.contains(null)){
	                    return moves[0][n-1];
	                }
	            }
	        }else if(!item.contains("CIRCLE")){
	            if(!item.contains(null)){
	                return moves[0][n-1];
	            }
	        }		
	        return null;
	}
	
}
