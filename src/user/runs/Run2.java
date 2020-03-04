package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.Convert;
import user.utils.GyroFollow;
import user.utils.GyroRotate;

public class Run2 extends RobotRun {

	public Run2(String name) {
		super(name);
	}

	@Override
	public void  runInstructions()
	{
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		GyroFollow.followDegrees(Convert.cmToDegrees(145), 0, 0.7, 0.65, 0.4, true);
		GyroFollow.followDegrees(Convert.cmToDegrees(18), 0, 0.4, -0.5, true);
		GyroRotate.TurnTo(-90, 0.7);
		RobotMap.getChassis().backwardDriveSeconds(0.65, 2, true);
		Wait.waitForSeconds(0.1);
		GyroFollow.followDegrees(Convert.cmToDegrees(45), -90, 0.6, 0.65, false);
		GyroRotate.TurnTo(0, 0.8);
		GyroFollow.followDegrees(Convert.cmToDegrees(45), 0, 0.7, 0.7, true);
		RobotMap.getChassis().tankDriveSeconds(0.55, -0.55, 0.5, true);
		//GyroRotate.TurnTo(40, 0.7);
		GyroRotate.TurnTo(5, 0.6);
		GyroFollow.followDegrees(Convert.cmToDegrees(25), 5, 0.5, -0.6, true);
		GyroRotate.TurnTo(-30, 0.75);
		RobotMap.getMotor("larm").rotateDegrees(0.6, 180, true);
		GyroFollow.followDegrees(Convert.cmToDegrees(22), -30, 0.65, 0.6, true);
		RobotMap.getMotor("larm").rotateDegrees(-0.6, 180, true);
		GyroFollow.followDegrees(Convert.cmToDegrees(30), -30, 0.65, -0.6, true);
		GyroRotate.TurnTo(0, 0.9);
		RobotMap.getChassis().backwardDriveSeconds(0.8, 0.4, 10, false);
	}
}