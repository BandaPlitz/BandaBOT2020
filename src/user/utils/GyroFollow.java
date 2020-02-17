package user.utils;

import robot.RobotMap;
import robot.runs.RunHandler;

public class GyroFollow {

	public static void followDegrees(int degrees, int targetDegrees, double kp, double p0, boolean brake) {
		followDegrees(degrees, targetDegrees, kp, p0, 1.0, brake);
	}

	public static void followDegrees(int degrees, int targetDegrees, double kp, double p0, double acceleration,
			boolean brake) {
		double error;
		// resets encoder
		RobotMap.getMotor("Lwheel").resetEncoder();
		RobotMap.getMotor("Rwheel").resetEncoder();

		RobotMap.getMotor("Lwheel").setAcceleration(acceleration);
		RobotMap.getMotor("Rwheel").setAcceleration(acceleration);

		// while wheels traveled less than degrees
		while (RunHandler.isRunning() && (Math.abs(RobotMap.getMotor("Lwheel").readEncoder())
				+ Math.abs(RobotMap.getMotor("Rwheel").readEncoder())) / 2 <= degrees) {
			error =  targetDegrees - RobotMap.getSensor("gyro").read();
			error /= 180;

			// checks if we go backwards
			if (p0 < 0)
				error = -error;

			// drives and repairs the mistakes
			RobotMap.getChassis().tankDrive(Clamp.Speed(p0 + error * kp), Clamp.Speed(p0 - error * kp), acceleration);

		}

		// checks if we brake or coast
		if (brake) {
			RobotMap.getChassis().brake();
		} else {
			RobotMap.getChassis().coast();
		}
		RobotMap.getMotor("Lwheel").setAcceleration(1);
		RobotMap.getMotor("Rwheel").setAcceleration(1);

	}
}
