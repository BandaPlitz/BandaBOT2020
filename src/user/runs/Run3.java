package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.Convert;
import user.utils.GyroFollow;
import user.utils.LineFollow;

public class Run3 extends RobotRun {

	public Run3(String name) {
		super(name);
	}


	@Override
	public void runInstructions() {
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		RobotMap.getChassis().forwardDriveDegrees(0.5, 0.2, Convert.cmToDegrees(45), false);
		LineFollow.followDegrees(Convert.cmToDegrees(95), "rcolours", "left", 0.75, 0.5, false);
		Wait.waitForSeconds(0.1);
		RobotMap.getChassis().backwardDriveDegrees(0.35, Convert.cmToDegrees(25), false);
		RobotMap.getChassis().tankDriveDegrees(-0.7, 0.7, 400, true);
		Wait.waitForSeconds(0.1);
		RobotMap.getChassis().backwardDriveSeconds(0.65, 2, false);
		GyroFollow.followDegrees(Convert.cmToDegrees(45), -90, 0.35, 0.6, false);
		RobotMap.getChassis().tankDriveDegrees(0.5, -0.5, 180, false);
		RobotMap.getChassis().forwardDriveDegrees(0.4, Convert.cmToDegrees(30), true);
			
	}
}