package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import user.utils.Convert;
import user.utils.GyroFollow;
import user.utils.GyroRotate;

public class testGyroRotate extends RobotRun{

	public testGyroRotate(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runInstructions() {
		// TODO Auto-generated method stub
		
		RobotMap.getSensor("gyro").resetToCurrentValue();
		GyroFollow.followDegrees(Convert.cmToDegrees(100), 0, 0.5, -0.8, true);
		
	}

}
