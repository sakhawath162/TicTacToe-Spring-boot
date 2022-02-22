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
	            	else if(item.get(j-1).equals(moves[i][j])) {
	            		
	            		item.add(moves[i][j]);
	            		count++;
	            		if(count>=3) {
		                	storedItem.add(item.get(j));
		                	System.out.println(storedItem.get(0));
		                	break;
	            		}
	            	}else {
	            		item.add(moves[i][j]);
	            		count = 1;
	            	}
	                
	             }
            }
	        
	    	if(storedItem.contains("CIRCLE") && storedItem.contains("CROSS")) {
				return null;
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
		LOGGER.info("Checking winner by column");

		try {
			
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
	                	storedItem.add(item.get(0));
	                }
	            }else if(item.contains("CIRCLE")){
	                if(item.contains("CROSS")){
	                    continue;
	                }else if(item.contains(null)){
	                    continue;
	                }else{
	                	storedItem.add(item.get(0));
	                }
	            }
	        }
				
			if(storedItem.contains("CIRCLE") && storedItem.contains("CROSS")) {
				return null;
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

		LOGGER.info("Checking winner by left diagonal");

		try {
			for(int i = 0; i<n ; i++){
	            item.add(moves[i][i]);
	        }
			
	        if(!item.contains("CROSS")){
	            if(item.contains("CIRCLE")){
	                if(!item.contains(null)){
	                	storedItem.add(item.get(0));
	                }
	            }
	        }else if(!item.contains("CIRCLE")){
	            if(!item.contains(null)){
                	storedItem.add(item.get(0));
	            }
	        }
	        
	        if(storedItem.contains("CIRCLE") && storedItem.contains("CROSS")) {
				return null;
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

		LOGGER.info("Checking winner by Right diagonal");

		try {
			for (int i = 0; i<n; i++){
	            item.add(moves[i][n-i-1]);
	        }
			
	        if(!item.contains("CROSS")){
	            if(item.contains("CIRCLE")){
	                if(!item.contains(null)){
	                	storedItem.add(item.get(0));
	                }
	            }
	        }else if(!item.contains("CIRCLE")){
	            if(!item.contains(null)){
                	storedItem.add(item.get(0));
	            }
	        }
	        
	        if(storedItem.contains("CIRCLE") && storedItem.contains("CROSS")) {
				return null;
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
