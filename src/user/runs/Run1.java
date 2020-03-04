package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.Convert;
import user.utils.GyroFollow;
import user.utils.GyroRotate;

public class Run1 extends RobotRun {

	public Run1(String name) {
		super(name);
	}

	@Override
	public void  runInstructions()
	{
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		GyroFollow.followDegrees(Convert.cmToDegrees(30), 0, 0.6, 0.5, true);
		GyroRotate.TurnTo(-90, 0.8 );
		RobotMap.getChassis().backwardDriveSeconds(0.4, 1.5, true);
		Wait.waitForSeconds(0.1);
		GyroFollow.followDegrees(Convert.cmToDegrees(65), -90, 0.8, 0.5, 0.2, true);
		RobotMap.getMotor("rarm").rotateDegrees(0.3, 80, true);
		RobotMap.getMotor("larm").rotateDegrees(0.3, 30, true);
		
		
	}
}
