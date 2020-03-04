package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import user.utils.Convert;
import user.utils.GyroFollow;
import user.utils.GyroRotate;

public class Run3 extends RobotRun {

	public Run3(String name) {
		super(name);
	}


	@Override
	public void runInstructions() {
		
		
		RobotMap.getSensor("gyro").resetToCurrentValue();

		GyroFollow.followDegrees(Convert.cmToDegrees(55), 0, 0.75, 0.8, 0.4, true);
		GyroFollow.followDegrees(Convert.cmToDegrees(30), 0, 0.5, -0.6, 0.3, false);
		GyroRotate.TurnTo(90, 0.8);
		RobotMap.getChassis().tankDriveSeconds(-0.6, -0.6, 3, true);
		
	}
}