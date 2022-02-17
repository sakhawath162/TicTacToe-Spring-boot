# TicTakToe-Spring-boot

#API: 
	*POST/gameWinner
	* calculates the 2D array sent from the front end to the API body and finds the match result. 
	
#Endpoints:

	* /api/ticTacToe/gameWinner
	* port - 8081
	
#Body:

{
    "size" : 3,
    "moves": [["CIRCLE",null,"CIRCLE"],
              [null,"CROSS","CROSS"],
              ["CROSS",null,null]]
}

#Responses: 
	
	*CROSS wins!
	*CIRCLE wins!
	*DRAW
	
#FrontEnd: 

In the frontend there will be a 2D array of size N by N. When players gives any command (CROSS/CIRCLE)
the respective field of the array will be filled up by that string. The rest will be the same. If any of
the array field is empty it will be filled up by null. this array will be sent as a body to the single POST 
API call to the backend. 
	
	