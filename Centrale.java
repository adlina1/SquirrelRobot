// Environment code for project centrale_nucleaire.mas2j

import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import javax.swing.*;
import java.util.logging.*;
import java.awt.*;
import javax.swing.border.*;

public class Centrale extends Environment {

    private Logger logger = Logger.getLogger("centrale_nucleaire.mas2j."+Centrale.class.getName());
	private CentraleGUI gui = new CentraleGUI();
	private Object model = new Object();
	
	// The world in which we'll be in
	static boolean[][] grid = new boolean [4][4];
	
	// Initial position of the robot
	private int pos_squirrel_x = 0; 
    private int pos_squirrel_y = 0;
	
	private int nbMat = 0;
	
	// The constant terms used for perception 
    private static final Literal lPos1  = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(1));
    private static final Literal lPos2  = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(2));
	private static final Literal lPos3  = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(3));
	private static final Literal lPos4  = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(4));
	private static final Literal lPos5  = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(5));
	private static final Literal lPos6  = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(6));
	private static final Literal lPos7  = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(7));
	private static final Literal lPos8  = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(8));
	private static final Literal lPos9  = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(9));
	private static final Literal lPos10 = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(10));
	private static final Literal lPos11 = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(11));
	private static final Literal lPos12 = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(12));
	private static final Literal lPos13 = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(13));
	private static final Literal lPos14 = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(14));
	private static final Literal lPos15 = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(15));
	private static final Literal lPos16 = ASSyntax.createLiteral("posRobot", ASSyntax.createNumber(16));

	private static final Literal lMaterial = ASSyntax.createLiteral("material"); // it means we perceive there is a material 
	private static final Literal lNotMaterial = ASSyntax.createLiteral("noMaterial"); // here we don't
	private static final Literal lAllDone = ASSyntax.createLiteral("everythingControlled"); 

	
	// Constructor
	public Centrale() {
		
        createPercept();
		
		/* We define in which position there will be a material (which our robot will have to take the state) in our world
		we suppose we are given this data by the human supervisor */
        grid[2][1] = true;
		grid[3][2] = true;
    }
	

	// All of our actions will be listed there
    @Override
    public boolean executeAction(String agName, Structure action) {
		logger.info("SquiRobot doing : ->"+action);
		
		// coordinates of first material
		int goal_x = 2;
		int goal_y = 1;
		
		// coordinates of second material
		int goal_xx = 3;
		int goal_yy = 2;
		
		
        try {
			// 750ms between each action taken
            Thread.sleep(750);   
        }  catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// The environment change based on actions taken
		if (action.getFunctor().equals("take")) { 
			if (grid[pos_squirrel_x][pos_squirrel_y]) {
				grid[pos_squirrel_x][pos_squirrel_y] = false; 
				// the material doesn't move, but we suppose  we won't have to take it again atm, so false.
				nbMat += 1;
				logger.info("The state of the material has been taken.");
			} else {
				logger.info("Not a material there");
				Toolkit.getDefaultToolkit().beep();
			}
		} else if (action.getFunctor().equals("moveUP")) {
				//if (pos_squirrel_y > 0) {
					if(pos_squirrel_y > goal_y | pos_squirrel_y > goal_yy){
						pos_squirrel_y--;
						logger.info("new coordinates: [x="+pos_squirrel_x+",y="+pos_squirrel_y+"]");
			}
		} else if (action.getFunctor().equals("moveDOWN")) {
			//if (pos_squirrel_y < 3) {
				if(pos_squirrel_y < goal_y | pos_squirrel_y < goal_yy){
					pos_squirrel_y++;
					//pos_squirrel_x=0; // uncomment in the version without PCC.
					logger.info("new coordinates: [x="+pos_squirrel_x+",y="+pos_squirrel_y+"]");
				}
			}
		 else if (action.getFunctor().equals("moveRIGHT")) {
			//if (pos_squirrel_x < 3) {
				if (pos_squirrel_x < goal_x | pos_squirrel_x < goal_xx){
					pos_squirrel_x++;	
					logger.info("new coordinates: [x="+pos_squirrel_x+",y="+pos_squirrel_y+"]");
				}
			}
		else if (action.getFunctor().equals("moveLEFT")) {
			//if (pos_squirrel_x > 0) {
				if(pos_squirrel_x > goal_x | pos_squirrel_x > goal_xx){
					pos_squirrel_x--;
					logger.info("new coordinates: [x="+pos_squirrel_x+",y="+pos_squirrel_y+"]");
				}
			}	
		// I come back to the begining of the grid (at case n°13)
		 else if (action.getFunctor().equals("returnBegining")){
			if (pos_squirrel_x == 3 && pos_squirrel_y == 3) {
				pos_squirrel_x = 0;
				pos_squirrel_y = 0;
			}
		} 
		else if (action.getFunctor().equals("leave")){
			logger.info("Leaave");
			stop(); // to be changed, atm only forces the execution of the program to be stopped
		
		} else {
			logger.info("The action "+action+" is not implemented!");
			return false;
		}
	
		createPercept(); // update agents perception for the new world state
		gui.paint();
		return true;        
}
	
	// the functor is an atom

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
		gui.setVisible(false);
    }
	
	private void createPercept() {
		
		clearPercepts();
		// First line of the grid
		if (pos_squirrel_x == 0 && pos_squirrel_y == 0){
			addPercept(lPos1);
		} else if (pos_squirrel_x == 0 && pos_squirrel_y == 1) {
            addPercept(lPos2);
        } else if (pos_squirrel_x == 0 && pos_squirrel_y == 2) {
            addPercept(lPos3);
        } else if (pos_squirrel_x == 0 && pos_squirrel_y == 3) {
            addPercept(lPos4);
        }
		// Second line
		if (pos_squirrel_x == 1 && pos_squirrel_y == 0){
			addPercept(lPos5);
		} else if (pos_squirrel_x == 1 && pos_squirrel_y == 1) {
            addPercept(lPos6);
        } else if (pos_squirrel_x == 1 && pos_squirrel_y == 2) {
            addPercept(lPos7);
        } else if (pos_squirrel_x == 1 && pos_squirrel_y == 3) {
            addPercept(lPos8);
        }
		// Third line
		if (pos_squirrel_x == 2 && pos_squirrel_y == 0){
			addPercept(lPos9);
		} else if (pos_squirrel_x == 2 && pos_squirrel_y == 1) {
            addPercept(lPos10);
        } else if (pos_squirrel_x == 2 && pos_squirrel_y == 2) {
            addPercept(lPos11);
        } else if (pos_squirrel_x == 2 && pos_squirrel_y == 3) {
            addPercept(lPos12);
        }
		// Last and fourth line 
		if (pos_squirrel_x == 3 && pos_squirrel_y == 0){
			addPercept(lPos13);
		} else if (pos_squirrel_x == 3 && pos_squirrel_y == 1) {
            addPercept(lPos14);
        } else if (pos_squirrel_x == 3 && pos_squirrel_y == 2) {
            addPercept(lPos15);
        } else if (pos_squirrel_x == 3 && pos_squirrel_y == 3) {
            addPercept(lPos16);
        }
		
		if (grid[pos_squirrel_x][pos_squirrel_y]) {
			// there is a material
			addPercept(lMaterial);
			logger.info("there is material");
		} else {
			addPercept(lNotMaterial);
			logger.info("there is not material");
		}
		
		// If we are in the position where we entered and we have taken all the materials state then we're allowed to go out!
		if (pos_squirrel_x == 0 && pos_squirrel_y == 0 && nbMat == 2) {
			addPercept(lAllDone);
			logger.info("Work is done. I'm going out.");
			logger.info("cpt="+nbMat);
		}
						
	} // end createPercept
	
	
	public class CentraleGUI extends JFrame {
        JLabel[][] labels;

		// Constructor
        public CentraleGUI() {
            super("Squirrel Robot");
            labels = new JLabel[grid.length][grid.length];
            getContentPane().setLayout(new GridLayout(labels.length, labels.length));
            for (int j = 0; j < labels.length; j++) {
                for (int i = 0; i < labels.length; i++) {
                    labels[i][j] = new JLabel();
					labels[i][j].setBackground(Color.CYAN);
					labels[i][j].setOpaque(true);
                    labels[i][j].setPreferredSize(new Dimension(360,360));
                    labels[i][j].setHorizontalAlignment(JLabel.CENTER);
                    labels[i][j].setBorder(new EtchedBorder());
                    getContentPane().add(labels[i][j]);
                }
            }
            pack();
            setVisible(true);
            paint();
        }
	
	void paint() {
                for (int i = 0; i < labels.length; i++) {
                    for (int j = 0; j < labels.length; j++) {
                        String square = "<html><center>";
                        if (pos_squirrel_x == i && pos_squirrel_y == j) {
                            square += "<font color=\"purple\" size=7><b>SquiBot</b> <br></font>";
                        }
                        if (grid[i][j]) {
                            square += "<font color=\"red\" size=5>material</font>";
                        }
                        square += "</center></html>";
                        labels[i][j].setText(square);
                    }
                
            }
        }
		
	} // end CentraleGUI class


}

