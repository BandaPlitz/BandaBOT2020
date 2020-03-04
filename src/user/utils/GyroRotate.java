package user.utils;

import robot.RobotMap;

public class GyroRotate {

	public static void TurnTo(double angle, double kp) {
		double currAngle = Clamp.angle(RobotMap.getSensor("gyro").read());
		double error = angle - currAngle;
		while (Math.abs(error) > 3) {
			currAngle = Clamp.angle(RobotMap.getSensor("gyro").read());
			error = angle - currAngle;
			double speed = error / 180 * kp;
			if (error > 3) {
				RobotMap.getChassis().tankDrive(Clamp.Speed(speed), Clamp.Speed(-speed));
			} else {
				RobotMap.getChassis().tankDrive(-Math.abs(Clamp.Speed(speed)), Math.abs(Clamp.Speed(speed)));
			}
		}
		RobotMap.getChassis().brake();
	}

}
