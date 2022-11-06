// Agent human_supervisor in project centrale_nucleaire.mas2j

/* Initial beliefs and rules */

/* Initial goals */

!initialize.
!give.
!ackAndAnswer.

/* Plans */

//tell = s intends r to believe (that s believes) the literal in the message’s content (noMaterial) to be true
+!initialize : true <- .send(squirrel_robot, tell, [posMat_1(10),posMat_2(15)]). 
+!give : true <- .send(squirrel_robot, tell, positionsGiven(squirrel_robot)).

// whenever I start believing I received the state material then print it.
+stateMat <- .print("Received state of material.").

