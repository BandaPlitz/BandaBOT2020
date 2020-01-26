package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.Convert;
import user.utils.GyroFollow;

public class Run2 extends RobotRun {

	public Run2(String name) {
		super(name);
	}


	@Override
	public void runInstructions() {
		
		
		
		//drive towards red circle ------------- speed, distance in degrees,    brake?
		RobotMap.getChassis().forwardDriveDegrees(0.5, Convert.cmToDegrees(85), false);
		//back off slowly
		RobotMap.getChassis().backwardDriveDegrees(0.4, Convert.cmToDegrees(20), false);
		//drive back to home
		RobotMap.getChassis().backwardDriveDegrees(0.7, Convert.cmToDegrees(150), false);
		
	}
}