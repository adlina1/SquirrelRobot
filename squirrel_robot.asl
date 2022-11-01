// Agent sample_agent in project centrale_nucleaire

// our actions : moveUP, moveDOWN, moveLEFT, moveRIGHT, take, enter, goOut, send, check


/* Initial beliefs and rules */

posRobot(0, 0).
posMaterial(2, 1).
posMaterial(3, 2). //différencer material_1 material_2 ? 
// !posRobot(2, 1)
notchecked(0,0).

/* Initial goals */

!posRobot(2, 1). // Le robot doit aller à la position du materiel
!giveStateMaterial.



/* Plans */

/*
+posRobot(X, Y) : not posRobot(2, 1) | not posRobot(3, 2) <- !posRobot(X+1, Y-1).
+posRobot(X, Y) : posRobot(2, 1) | posRobot(3, 2) <- x.print("Arrived at destination!"); take. 
*/


+posRobot(X, Y) : X == 2 & Y == 1 <- checked(2, 1). // whenever I perceive I'm in (2,1), then do the checking.
+posRobot(2, 1) : checked(2, 1) <- takeMaterial(2, 1). // whenever ... and I believe I have checked, take the material
+posRobot(X, Y) : not X == 2 & not Y == 1 <- !moveTo(2, 1). // pas d'opérateur de différence apparemment

+!giveStateMaterial : true <- print("hello world.").




