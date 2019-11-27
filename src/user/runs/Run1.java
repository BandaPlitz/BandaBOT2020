package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.runs.parallel.Action;
import robot.runs.parallel.Parallel;
import robot.utils.Wait;
import robot.utils.WaitCondition;
import user.utils.Convert;
import user.utils.GyroFollow;
import user.utils.LineFollow;

public class Run1 extends RobotRun {

	public Run1(String name) {
		super(name);
	}

	@Override
	public void runInstructions() {

		RobotMap.getSensor("gyro").resetToCurrentValue();
		
		GyroFollow.followDegrees(Convert.cmToDegrees(55), 0, 0.1, 0.6, 0.5, true);
		GyroFollow.followDegrees(Convert.cmToDegrees(15), 0, 0.1, -0.4, 0.5, true);
		
		LineFollow.followDegrees(Convert.cmToDegrees(35), "lcolours", "left", 0.6, 0.6, true);

		
	}

}
