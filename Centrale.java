// Environment code for project centrale_nucleaire.mas2j

import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;

import java.util.logging.*;

public class Centrale extends Environment {

    private Logger logger = Logger.getLogger("centrale_nucleaire.mas2j."+Centrale.class.getName());
	
	// The world in which we'll be in
	boolean[][] grid = new boolean [4][4];
	
	// We define in which position there will be a material (which our robot will have to take the state) in our world
	grid[2][1] = true; grid[3][2] = true;
	
	// Initial position of the robot
	private int pos_squirrel_x = 0; 
    private int pos_squirrel_y = 0;
	
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
	private static final Literal lNotMaterial = ASSyntax.createLiteral(Literal.LNeg, "material"); // here we don't

	
	

    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
        try {
			addPercept(ASSyntax.parseLiteral("percept(demo)"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        logger.info("executing: "+action+", but not implemented!");
        if (true) { // you may improve this condition
             informAgsEnvironmentChanged();
        }
        return true; // the action was executed with success
    }

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
	
	private void createPercept() {
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
		} else {
			
			addPercept(lNotMaterial)
		}
		
	} // end createPercept


}

