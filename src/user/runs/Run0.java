package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.Convert;
import user.utils.GyroFollow;
import user.utils.GyroRotate;

public class Run0 extends RobotRun {

	public Run0(String name) {
		super(name);
	}

	@Override
	public void  runInstructions()
	{
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		RobotMap.getChassis().tankDriveDegrees(-0.4, 0.4, 250, false);
		RobotMap.getChassis().backwardDriveSeconds(0.5, 2, true);
		Wait.waitForSeconds(0.2);
		RobotMap.getChassis().forwardDriveDegrees(0.6, 0.1, Convert.cmToDegrees(90), true);
		RobotMap.getChassis().backwardDriveDegrees(0.5, Convert.cmToDegrees(25), false);
		RobotMap.getChassis().tankDriveDegrees(0.5, -0.5, 0.2, 400, false);
		GyroFollow.followDegrees(Convert.cmToDegrees(100), 0, 0.6, -0.8, false);
		
	}
}
