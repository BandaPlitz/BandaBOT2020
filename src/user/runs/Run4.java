package user.runs;

import lejos.robotics.Color;
import robot.RobotMap;
import robot.runs.RobotRun;
import robot.utils.Condition;
import robot.utils.Wait;
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
		
		GyroFollow.followDegrees(Convert.cmToDegrees(55), 0, 0.1, 0.6, 0.2, true);
	    Wait.waitForSeconds(0.01);
		GyroFollow.followDegrees(Convert.cmToDegrees(5), 0, 0.1, -0.4, 0.5, true);
		Wait.waitForSeconds(0.01)				;
		RobotMap.getChassis().tankDriveDegrees(0.5, 0, 0.2, 400, false);
		LineFollow.followDegrees(Convert.cmToDegrees(60), "lcolours", "left", 0.8, 0.2, true);
		RobotMap.getMotor("larm").rotateDegrees(0.4, 50, false);
		RobotMap.getMotor("larm").rotateDegrees(-0.5, 50, true);
		GyroFollow.followDegrees(Convert.cmToDegrees(10), 45, 0.2, -0.6, true);
		RobotMap.getChassis().tankDriveDegrees(0.5, -0.2, 0.2, 500, false);
		
		RobotMap.getSensor("lcolours").changeMode("color");
		
		while(new Condition() {
			@Override
			public boolean evaluate() {
				return (int)RobotMap.getSensor("lcolours").read() == Color.BLACK;
			}
		}.loopEvaluate()) {
			GyroFollow.followDegrees(Convert.cmToDegrees(1), 45, 0.2, 0.7, true);
		}
		RobotMap.getChassis().tankDriveDegrees(-0.5, 0.5, 95, false);
		GyroFollow.followDegrees(Convert.cmToDegrees(50), -95, 0.3, 0.7, false);
		

		
	}

}
