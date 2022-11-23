# SquirrelRobot
We present a small program using Jason[^1], an interpreter for an extended version of AgentSpeak, a logic-based agent-oriented programming language.

## Presentation
The robot is a squirrel (let's name it SquiBot) one which is designed to evolve quiet easily in a nuclear power plant, its main goal will be to take the state of the materials in its environment (the NPP) and inform the supervisor (humans) about it. To this end, it has sophisticated sensors to perceive its environment, acquire new beliefs, and then take actions.

## Formalization
The environment (nuclear power plant) is formalized as a $N\times N$ matrix with $N=4$. 
```math
\begin{bmatrix}
(0,0) & (1,0) & (2,0) & (3,0) \\
(0,1) & (1,1) & (2,1) & (3,1) \\
(0,2) & (1,2) & (2,2) & (3,2) \\
(0,3) & (1,3) & (2,3) & (3,3) 
\end{bmatrix}
<br>
```
The robot starts at the position (0,0).
We defined 2 initial goals for SquiBot : <br>
1. ``` !giveStateMaterial ```
2. ``` !goOut ``` 

 <ul>
  <li>SquiBot has first to give the state of the material to the human supervisor (other agent that is not in the NPP). In order to do so, the agent is moving through the matrix using a simple shortest path algorithm until finding the materials. </li>
  <li>When all the materials have been found, then the robot will have the intention to go Out of the NPP. The exit is at the entry coordinate (0,0).</li>
</ul> 

We initially placed 2 materials at coordinates $(2,1)$ et $(3,2)$. This has been done in the Centrale.java file, which is the file representing the environment behaviour. Some opportunities for improvement would include for example adding obstacles in the matrix, adding materials at random places.


## How to use it

You will first have to install Jason. You can get the procedure over [there](https://github.com/jason-lang/jason/tree/master/doc/tutorials/getting-started#installation-and-configuration). It includes as well a small tutorial to get started. <br>
Then, you can find our small demonstration bellow, by clicking on the image, which shows how to run this in the jEdit IDE that we used for this project. Note that there is an eclipse plugin for jason.

[![Squirrel Robot](https://img.youtube.com/vi/n-d4bBOsY9I/0.jpg)](https://www.youtube.com/watch?v=n-d4bBOsY9I)

## Contribution
<ul>
  <li>Adrien Linares</li>
  <li>Amirhossein Nasri</li>
  <li>Richard Amah</li>
  <li>Tom Tisserant</li>
</ul> 

The robot chosen has been mainly inspired by a visit in the Musée des Arts et Métiers in Paris where I found this squirrel robot designed by the CEA[^2] in 1990 to climb the ladders of the chimneys of nuclear power plants and take the state of a material inaccessible to humans for security reasons.

[^1]: https://jason.sourceforge.net/wp/
[^2]: https://www.cea.fr/english
