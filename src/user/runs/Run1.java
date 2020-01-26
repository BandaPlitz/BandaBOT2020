package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.runs.RunHandler;
import robot.utils.Action;
import robot.utils.Wait;
import user.utils.Convert;
import user.utils.GyroFollow;

public class Run1 extends RobotRun {

	public Run1(String name) {
		super(name);
	}

	@Override
	public void  runInstructions()
	{
		/*new Action() {
			@Override
			public void execute() {
				while(RunHandler.isRunning()) {
					System.out.println(RobotMap.getSensor("gyro").read());
				}
			}
		}.runInParallel();
		*/
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		// עיגול גדול 125 נקודות
		RobotMap.getChassis().forwardDriveDegrees(0.7, Convert.cmToDegrees(55), false);
		//GyroFollow.followDegrees(Convert.cmToDegrees(55), -15, 0.9, 0.7, 0.35, false);
		Wait.waitForSeconds(0.1);
		GyroFollow.followDegrees(Convert.cmToDegrees(25), 0, 0.15, -0.7, false);
		RobotMap.getChassis().tankDriveDegrees(0.5, -0.5, 0.2, 400, false);
		GyroFollow.followDegrees(Convert.cmToDegrees(100), 40, 0.2, -0.8, false);
		
	}
}
