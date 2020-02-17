package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import user.utils.Convert;
import user.utils.GyroFollow;
import user.utils.GyroRotate;

public class Run2 extends RobotRun {

	public Run2(String name) {
		super(name);
	}


	@Override
	public void runInstructions() {
		
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		GyroFollow.followDegrees(10000, 0, 0.8, 0.8, 0.4, true);
		//GyroRotate.TurnTo(90);
		
	}
}