// Agent human_supervisor in project centrale_nucleaire.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!initialize.
!give.

/* Plans */

//tell = s intends r to believe (that s believes) the literal in the message’s content (noMaterial) to be true
+!initialize : true <- .send(squirrel_robot, tell, [posMat_1(15),posMat_2(7)]).
+!give : true <- .send(squirrel_robot, tell, positionsGiven(squirrel_robot)).

// do something when we receive the materials?
