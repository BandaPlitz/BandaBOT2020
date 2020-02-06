package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Wait;
import user.utils.Convert;

public class Run3 extends RobotRun {

	public Run3(String name) {
		super(name);
	}


	@Override
	public void runInstructions() {
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		RobotMap.getChassis().forwardDriveDegrees(0.5, 0.2, Convert.cmToDegrees(140), false);
		Wait.waitForSeconds(0.1);
		RobotMap.getChassis().backwardDriveSeconds(0.8, 0.4, 10, true);
		
			
	}
}