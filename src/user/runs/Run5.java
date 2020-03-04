package user.runs;

import lejos.hardware.Button;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Condition;
import robot.utils.Wait;
import user.utils.Convert;
import user.utils.GyroFollow;
import user.utils.GyroRotate;

public class Run5 extends RobotRun {

	public Run5(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		GyroFollow.followDegrees(Convert.cmToDegrees(80), 0, 0.4, 0.6, 0.2, false);
	    GyroRotate.TurnTo(-90, 0.8);
	    GyroFollow.followDegrees(Convert.cmToDegrees(50), -90, 0.4, 0.6, 0.2, false);
		RobotMap.getMotor("rarm").rotateDegrees(0.3, 60, false);
		RobotMap.getMotor("rarm").rotateDegrees(-0.5, 50, true);
		
		
	}

}
