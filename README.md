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
    "size" : 5,
    "moves": ["CROSS",0,0,
              "CIRCLE",0,1,
              "CROSS",0,2,
              "CROSS",1,0,
              "CROSS",1,1,
              "CIRCLE",1,2,
              "CIRCLE",1,3,
              "CROSS",2,0,
              "CIRCLE",3,1,
              "CIRCLE",3,2,
              "CROSS",3,3
              ]
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
project link : [tictactoe-spring-boot](https://tictactoe-spring-boot.herokuapp.com/)
	
	