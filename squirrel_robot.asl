
// Actions : moveUP, movingTowardsGoal2, moveLEFT, movingTowardsGoal2, returnBegining, take, send, goOut, (check?)
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
+!giveStateMaterial : material <- take; .send(human_supervisor, tell, noMaterial); !giveStateMaterial.

+!goOut : matrixEmpty <- leave; .stopMAS.   //.stopMAS  cause a halt to the execution of the multi-agent system

/*
//  For example, the KQML performative tell is used with the intention of changing the receiver’s beliefs
Knowledge Query and Manipulation Language (KQML), developed in the
context of the ‘Knowledge Sharing Effort’ project [44], was the first attempt to
define a practical agent communication language that included high-level (speech-
act based) communication as considered in the distributed artificial intelligence
literature. */

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






