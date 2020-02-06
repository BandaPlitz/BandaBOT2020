package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import user.utils.Convert;
import user.utils.GyroFollow;

public class Run2 extends RobotRun {

	public Run2(String name) {
		super(name);
	}


	@Override
	public void runInstructions() {
		
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		//drive towards red circle ------------- speed, distance in degrees,    brake?
		GyroFollow.followDegrees(Convert.cmToDegrees(75), 0, 0.8, 0.5, 0.3, false);
		//back off slowly
		RobotMap.getChassis().backwardDriveDegrees(0.4, Convert.cmToDegrees(20), false);
		//drive back to home
		GyroFollow.followDegrees(Convert.cmToDegrees(150), 0, 0.7, -0.9, 0.3, true);		
	}
}