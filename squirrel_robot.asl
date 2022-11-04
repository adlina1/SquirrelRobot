
// Actions : moveUP, moveDOWN, moveLEFT, moveRIGHT, returnBegining, take, send, goOut, (check?)


/* Initial goal */

!giveStateMaterial.
!goOut.

/* Plans */

+!giveStateMaterial : noMaterial <- !move; !giveStateMaterial.
+!giveStateMaterial : material <- take; .send(human_supervisor, tell, noMaterial); !giveStateMaterial.
//tell = s intends r to believe (that s believes) the literal in the message’s content (noMaterial) to be true


// We can reach the exit by going to the square n°16 that takes us to the entry directly (n°0) or by going towards the entry walking.
+!goOut : matrixEmpty <- returnBegining; leave.                 

+!move : posRobot(1) <- moveRIGHT; moveDOWN.
+!move : posRobot(2) <- moveRIGHT.
+!move : posRobot(3) <- moveRIGHT.
+!move : posRobot(4) <- moveRIGHT.
+!move : posRobot(5) <- moveRIGHT.
+!move : posRobot(6) <- moveRIGHT.
+!move : posRobot(7) <- moveRIGHT.
+!move : posRobot(8) <- moveRIGHT.
+!move : posRobot(9) <- moveRIGHT.
+!move : posRobot(10) <- moveDOWN.
+!move : posRobot(11) <- moveRIGHT.
+!move : posRobot(12) <- moveRIGHT.
+!move:  posRobot(13) <- moveDOWN.
+!move : posRobot(14) <- moveDOWN.
+!move : posRobot(15) <- moveDOWN.
+!move : posRobot(16) <- !goOut. // end of the grid









