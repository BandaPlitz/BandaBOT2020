package user.runs;

import lejos.hardware.Button;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Condition;
import robot.utils.Wait;
import user.utils.Convert;
import user.utils.GyroFollow;
import user.utils.GyroRotate;

public class Run4 extends RobotRun {

	public Run4(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
Condition enterPressed = new Condition() {
			
			@Override
			public boolean evaluate() {
				if(Button.getButtons() == Button.ID_ENTER) {
					while(Button.getButtons() == Button.ID_ENTER);
					return true;
				}
				return false;
			}
		};
		GyroFollow.followDegrees(Convert.cmToDegrees(80), 0, 0.9, 0.6, 0.2, false);
	    Wait.waitForSeconds(0.01);
		RobotMap.getMotor("rarm").rotateDegrees(0.3, 60, false);
		RobotMap.getMotor("rarm").rotateDegrees(-0.5, 50, true);
		
		
	}

}
