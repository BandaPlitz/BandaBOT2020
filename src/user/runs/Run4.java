package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.Convert;
import user.utils.GyroFollow;
import user.utils.GyroRotate;
import user.utils.LineFollow;

public class Run4 extends RobotRun {

	public Run4(String name) {
		super(name);
	}


	@Override
	public void runInstructions() {
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		GyroFollow.followDegrees(Convert.cmToDegrees(69), 0, 0.6, 0.5, 0.2, false);
		GyroRotate.TurnTo(-90, 0);
		RobotMap.getChassis().forwardDriveSeconds(0.4, 2, true);
	}
}