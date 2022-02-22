# TicTakToe-Spring-boot

**API:** 

	* POST/gameWinner
	* calculates the 2D array sent from the front end to the API body and finds the match result. 
	
**Endpoints:**

	* /api/ticTacToe/gameWinner
	* port - 8081
	
**Body:**

```javascript
	{
	    "size" : 3,
	    "moves": [["CIRCLE",null,"CIRCLE"],
	              [null,"CROSS","CROSS"],
	              ["CROSS",null,null]]
	}
```

**Responses**
	
	*CROSS wins!
	*CIRCLE wins!
	*DRAW
	
**FrontEnd**

In the frontend there is a input box for taking the grid size (3<=N<=12). According to the input a 
N by N table will be generated. The moves will be given to the boxes(CROSS/CIRCLE). For every click 
the moves and the row and column number will be inserted in an array. for example array = ["CROSS,0,1,"CIRCLE",0,0]
"Check match result" button will hit the Backend post api with the array. Response will be shown accordingly. 

**Deployment**
the project is deployed to heroku. 
project link : [a link](https://tictactoe-spring-boot.herokuapp.com/)
	
	