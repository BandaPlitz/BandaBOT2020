package user.runs;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Condition;
import robot.utils.Wait;
import user.utils.LineFollow;

public class ColourReset extends RobotRun {

	public ColourReset(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runInstructions() {
		
		Condition enterPressed = new Condition() {
			
			@Override
			public boolean evaluate() {
				return Button.getButtons() == Button.ID_ENTER;
			}
		};
		
		LCD.drawString("L on black", 0, 0);
		
		Wait.waitFor(enterPressed);
		
		LineFollow.black = RobotMap.getSensor("lcolours").read();
		
		LCD.clear();
		
		Wait.waitForSeconds(0.1);
		
		LCD.drawString("L on white", 0, 0);
		
		Wait.waitFor(enterPressed);
		
		LineFollow.white = RobotMap.getSensor("lcolours").read();
		
		LCD.clear();
		
		Wait.waitForSeconds(0.5);
		
		double white = (int) (LineFollow.white * 100);
		double black = (int) (LineFollow.black * 100);
		
		white /= 100;
		black /= 100;
		
		LCD.drawString("white: " + white, 0, 0);
		LCD.drawString("black: " + black, 0, 1);
		
		Wait.waitFor(enterPressed);
		LCD.clear();
	}

	
	
}
