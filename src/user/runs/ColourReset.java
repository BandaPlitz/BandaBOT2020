package user.runs;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import robot.utils.WaitCondition;
import user.utils.LineFollow;

public class ColourReset extends RobotRun {

	public ColourReset(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runInstructions() {
		LCD.drawString("Place Lcolor sensor \n on black", 2, 0);
		
		WaitCondition enterPressed = new WaitCondition() {
			
			@Override
			public boolean evaluate() {
				return Button.getButtons() == Button.ID_ENTER;
			}
		};
		
		Wait.waitFor(enterPressed);
		
		LineFollow.black = RobotMap.getSensor("lcolours").read();
		
		LCD.drawString("Place Lcolor sensor \n on white", 2, 0);
		
		Wait.waitFor(enterPressed);
		
		LineFollow.white = RobotMap.getSensor("lcolours").read();
		
		System.out.println("white: " + LineFollow.white + "\n black: " + LineFollow.black);
	}

	
	
}
