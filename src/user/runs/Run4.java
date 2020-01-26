package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.Convert;
import user.utils.GyroFollow;

public class Run4 extends RobotRun {

	public Run4(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		GyroFollow.followDegrees(Convert.cmToDegrees(85), -15, 0.9, 0.6, 0.2, false);
	    Wait.waitForSeconds(0.01);
		
		RobotMap.getMotor("rarm").rotateDegrees(0.3, 50, false);
		RobotMap.getMotor("rarm").rotateDegrees(-0.5, 50, true);
		GyroFollow.followDegrees(Convert.cmToDegrees(20), 0, 0.2, -0.2, false);
		RobotMap.getChassis().tankDriveDegrees(0.4, -0.4, 130, true);
		GyroFollow.followDegrees(Convert.cmToDegrees(80), -45, 0.4, 0.6, true);
		RobotMap.getChassis().tankDriveDegrees(0.25, -0.25, 120, false);
		RobotMap.getSensor("gyro").resetToCurrentValue();
		GyroFollow.followDegrees(Convert.cmToDegrees(80), 0, 0.9, -0.9, true);
		RobotMap.getChassis().backwardDrive(0);
		
		
	}

}
