package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.Convert;
import user.utils.GyroFollow;

public class Run0 extends RobotRun {

	public Run0(String name) {
		super(name);
	}

	@Override
	public void  runInstructions()
	{
		
		RobotMap.getSensor("gyro").resetToCurrentValue();

		GyroFollow.followDegrees(Convert.cmToDegrees(27), 0, 0.3, 0.4, 0.2, false);
		Wait.waitForSeconds(0.1);
		RobotMap.getChassis().tankDriveDegrees(-0.4, 0.4, 180, false);
		GyroFollow.followDegrees(Convert.cmToDegrees(15), -90, 0.4, -0.6, false);
		Wait.waitForSeconds(0.01);
		GyroFollow.followDegrees(Convert.cmToDegrees(85), -90, 0.9, 0.75, false);
		RobotMap.getChassis().backwardDriveDegrees(0.5, Convert.cmToDegrees(25), false);
		RobotMap.getChassis().tankDriveDegrees(0.5, -0.5, 0.2, 350, false);
		GyroFollow.followDegrees(Convert.cmToDegrees(100), 0, 0.6, -0.8, false);
		
	}
}
