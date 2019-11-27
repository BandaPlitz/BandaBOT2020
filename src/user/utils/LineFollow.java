package user.utils;

import robot.RobotMap;
import robot.runs.RunHandler;

public class LineFollow {

	static double white = 0.33;
	static double black = 0.97;
	static double target = (white + black) / 2;

	public static void follow(String sensor, String side, double kp, double p0) {
		double error;

		while (RunHandler.isRunning()) {
			error = RobotMap.getSensor(sensor).read() - target;
			if (side.equalsIgnoreCase("left")) {
				RobotMap.getChassis().tankDrive(p0 + (error * kp), p0);
			} else {
				RobotMap.getChassis().tankDrive(p0, p0 + (error * kp));
			}
		}
	}

	public static void followDegrees(int degrees, String sensor, String side, double kp, double p0, boolean brake) {
		RobotMap.getMotor("Lwheel").resetEncoder();
		RobotMap.getMotor("Rwheel").resetEncoder();

		double error;

		while (RunHandler.isRunning() && RobotMap.getMotor("Lwheel").readEncoder() <= degrees
				&& RobotMap.getMotor("Rwheel").readEncoder() <= degrees) {
			
			error = RobotMap.getSensor(sensor).read() - target;
			
			if (side.equalsIgnoreCase("left")) {
				System.out.println(p0 + (error * kp));
				RobotMap.getChassis().tankDrive(p0 + (error * kp), p0);
			} else {
				RobotMap.getChassis().tankDrive(p0, p0 + (error * kp));
			}
			if (brake == true) {
				RobotMap.getChassis().brake();

			} else {
				RobotMap.getChassis().coast();
			}

		}
	}

}
