package com.example.TicTacToe.Service;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.TicTacToe.Interface.TicTacToeInterface;

@Service
public class TicTacToeService implements TicTacToeInterface{
	private static final Logger LOGGER = LoggerFactory.getLogger(TicTacToeService.class);

	@Override
	public String winnerOfTheGameByRow(String[][]moves,int n) throws Exception {
	
		List<String> item = new ArrayList<>();
		List<String> storedItem = new ArrayList<>();
		int count = 0;
		
		LOGGER.info("Checking winner by row");
		
		try {
			for(int i=0; i<n; i++){
	            item.clear();
	            
	            for(int j=0;j<n; j++){

	            	if(j == 0) {
		                item.add(moves[i][j]);
		                count = 1;

	            	}
	            	else if(item.get(j-1) != null &&  moves[i][j] != null && item.get(j-1).equals(moves[i][j]) ) {
	            		
	            		item.add(moves[i][j]);
	            		count++;
	            		if(count>=3) {
		                	storedItem.add(item.get(j));
		                	break;
	            		}
	            	}else {
	            		item.add(moves[i][j]);
	            		count = 1;
	            	}
	                
	             }
            }
	        
	    	if(storedItem.contains("CIRCLE") && storedItem.contains("CROSS")) {
				return "DRAW";
			}
	    	if(storedItem.isEmpty()) {
	    		return null;
	    	}
		    return storedItem.toArray()[0].toString();
		    
		}catch(Exception e) {
			LOGGER.error("Exception thrown {}", e);

			throw e;
		}
	}

	@Override
	public String winnerOfTheGameByColumn(String[][] moves, int n) throws Exception {
		List<String> item = new ArrayList<>();
		List<String> storedItem = new ArrayList<>();
		int count = 0;
		LOGGER.info("Checking winner by column");

		try {
			
			for(int i=0; i<n; i++){
	            item.clear();
	            
	            for(int j=0;j<n;j++){
	            	
	            	if(j == 0) {
		                item.add(moves[j][i]);
		                count = 1;

	            	}
	            	else if(item.get(j-1) != null &&  moves[j][i] != null && item.get(j-1).equals(moves[j][i]) ) {
	            		
	            		item.add(moves[j][i]);
	            		count++;
	            		if(count>=3) {
		                	storedItem.add(item.get(j));
		                	break;
	            		}
	            	}else {
	            		item.add(moves[j][i]);
	            		count = 1;
	            	}
	            }
	        }
				
			if(storedItem.contains("CIRCLE") && storedItem.contains("CROSS")) {
				return "DRAW";
			}
			
			if(storedItem.isEmpty()) {
	    		return null;
	    	}
			
		    return storedItem.toArray()[0].toString();
		     
		}catch(Exception e) {
			LOGGER.error("Exception thrown {}", e);
			throw e;
		}
			
	}

	@Override
	public String winnerOfTheGameByLeftDiagonal(String[][] moves, int n) throws Exception {
		
		List<String> item = new ArrayList<>();
		List<String> storedItem = new ArrayList<>();
		int count = 0;
		LOGGER.info("Checking winner by left diagonal");

		try {
			for(int i = 0; i<n ; i++){
	            
	            if(i == 0) {
	                item.add(moves[i][i]);
	                count = 1;
            	}
            	else if(item.get(i-1) != null &&  moves[i][i] != null && item.get(i-1).equals(moves[i][i]) ) {

            		item.add(moves[i][i]);
            		count++;
            		if(count>=3) {
	                	storedItem.add(item.get(i));
	                	break;
            		}
            	}else {
            		item.add(moves[i][i]);
            		count = 1;
            	}
			}
	        
	        if(storedItem.contains("CIRCLE") && storedItem.contains("CROSS")) {
				return "DRAW";
			}
	        
	        if(storedItem.isEmpty()) {
	    		return null;
	    	}
	        
		    return storedItem.toArray()[0].toString();
		    
		}catch(Exception e) {
			LOGGER.error("Exception thrown {}", e);

			throw e;
		}
		 
	}

	@Override
	public String winnerOfTheGameByRightDiagonal(String[][] moves, int n) throws Exception {
		List<String> item = new ArrayList<>();
		List<String> storedItem = new ArrayList<>();
		int count = 0;
		
		LOGGER.info("Checking winner by Right diagonal");

		try {
			for (int i = 0; i<n; i++){
	            //item.add(moves[i][n-i-1]);
	            
	            if(i == 0) {
	                item.add(moves[i][n-i-1]);
	                count = 1;
            	}
            	else if(item.get(i-1) != null &&  moves[i][n-i-1] != null && item.get(i-1).equals(moves[i][n-i-1]) ) {

            		item.add(moves[i][n-i-1]);
            		count++;
            		if(count>=3) {
	                	storedItem.add(item.get(i));
	                	break;
            		}
            	}else {
            		item.add(moves[i][n-i-1]);
            		count = 1;
            	}
	            
	        }
	        
	        if(storedItem.contains("CIRCLE") && storedItem.contains("CROSS")) {
				return "DRAW";
			}
	        
	        if(storedItem.isEmpty()) {
	    		return null;
	    	}
	        
		    return storedItem.toArray()[0].toString();
		    
		}catch(Exception e) {
			LOGGER.error("Exception thrown {}", e);

			throw e;
		}
	}
	
}
