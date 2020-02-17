package user.utils;

import robot.RobotMap;

public class GyroRotate {
	private static double Kp = 0.8;

	public static void TurnTo(int angle) {
		double currAngle = Clamp.angle(RobotMap.getSensor("gyro").read());
		double error = (int) (angle - currAngle);
		while (Math.abs(error) > 5) {
			currAngle = Clamp.angle(RobotMap.getSensor("gyro").read());
			error = angle - currAngle;
			double speedOne = error / 180 * Kp;
			double speedTwo = -1 * error / 180 * Kp;
			System.out.println(speedOne);
			if (error > 5) {
				RobotMap.getChassis().tankDrive(speedOne, speedTwo);
			}
			if (error < -5) {
				RobotMap.getChassis().tankDrive(speedTwo, speedOne);
			}

		}

		RobotMap.getChassis().brake();

	}

}
