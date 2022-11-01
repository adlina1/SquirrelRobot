// Agent sample_agent in project centrale_nucleaire

// our actions : moveUP, moveDOWN, moveLEFT, moveRIGHT, take, enter, goOut, send, check


/* Initial beliefs and rules */

/*
posRobot(0, 0).
posMaterial(2, 1).
posMaterial(3, 2). 
// !posRobot(2, 1)
notchecked(0,0).
*/

/* Initial goals */

//!posRobot(2, 1). // Le robot doit aller à la position du materiel
!giveStateMaterial.

+!move : posRobot(1) <- moveRIGHT.
+!move : posRobot(2) <- moveRIGHT.
+!move : posRobot(3) <- moveRIGHT.
+!move : posRobot(4) <- moveDOWN.
+!move : posRobot(8) <- moveLEFT.
+!move : posRobot(7) <- moveLEFT.
+!move : posRobot(6) <- moveLEFT.
+!move : posRobot(5) <- moveDOWN.
+!move : posRobot(9) <- moveRIGHT.
+!move : posRobot(10) <- moveRIGHT.
+!move : posRobot(11) <- moveRIGHT.
+!move : posRobot(12) <- moveDOWN.
+!move : posRobot(16) <- moveLEFT.
+!move : posRobot(15) <- moveLEFT.
+!move : posRobot(14) <- moveLEFT.
+!move : posRobot(13) <- moveUP.


/* Plans */

+!giveStateMaterial : material <- take; !giveStateMaterial.
+!giveStateMaterial : noMaterial <- !move; !giveStateMaterial.

// treat the case where all materials states have been taken, send them and go out
// has still the goal to move (but towards the exit)
+!giveStateMaterial : noMaterial <- !move; .send(human_supervisor,tell,noMaterial).
//tell = s intends r to believe (that s believes) the literal in the message’s content (noMaterial) to be true


/*
+posRobot(X, Y) : not posRobot(2, 1) | not posRobot(3, 2) <- !posRobot(X+1, Y-1).
+posRobot(X, Y) : posRobot(2, 1) | posRobot(3, 2) <- x.print("Arrived at destination!"); take. 
*/

/*
+posRobot(X, Y) : X == 2 & Y == 1 <- checked(2, 1). // whenever I perceive I'm in (2,1), then do the checking.
+posRobot(2, 1) : checked(2, 1) <- takeMaterial(2, 1). // whenever ... and I believe I have checked, take the material
+posRobot(X, Y) : not X == 2 & not Y == 1 <- !moveTo(2, 1). // pas d'opérateur de différence apparemment

*/



