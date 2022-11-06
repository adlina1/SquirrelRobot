
/* Actions : moving, returnBegining, take, .send, puttingIntoMM 
(we don't take into account internal actions such as printting or .stopMAS) */
// In the console, actions will be preceded by "->"A 
// Where A is the name of the Action.

/* Initial goal */
!giveStateMaterial.
!goOut.
/* Plans */
+posMat_1(X) <- puttingIntoMM(X).
+posMat_2(X) <- puttingIntoMM(X).

/* When we start believing that there is no more material take the state of, and we believe we're at the position 1, the desire to
go out is created. */	

+positionsGiven(squirrel_robot) <- !saySmth("I was given the positions by supervisor.").
+!saySmth(X) : true <- print(X).

+posRobot(1) : matrixEmpty <- !goOut.

+!giveStateMaterial : noMaterial <- !move; !giveStateMaterial.
+!giveStateMaterial : material <- take; .print("Sending state material..."); .send(human_supervisor, tell, stateMat); !giveStateMaterial.
+!goOut : matrixEmpty <- .print("Leaving, bye!"); leave; .stopMAS.   //.stopMAS  cause a halt to the execution of the multi-agent system




+!move : posRobot(1) <- moving.
+!move : posRobot(2) <- moving.
+!move : posRobot(3) <- moving.
+!move : posRobot(4) <- moving.
+!move : posRobot(5) <- moving.
+!move : posRobot(6) <- moving.
+!move : posRobot(7) <- moving.
+!move : posRobot(8) <- moving.
+!move : posRobot(9) <- moving.
+!move : posRobot(10) <- moving.
+!move : posRobot(11) <- moving.
+!move : posRobot(12) <- moving.
+!move:  posRobot(13) <- moving.
+!move : posRobot(14) <- moving.
+!move : posRobot(15) <- moving.
+!move : posRobot(16) <- moving. // end of the grid






