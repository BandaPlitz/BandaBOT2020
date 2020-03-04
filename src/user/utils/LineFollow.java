package user.utils;

import robot.RobotMap;
import robot.runs.RunHandler;

public class LineFollow {

	public static double white = 0.75;
	public static double black = 0.07;
	static double target = (white + black) / 2;

	public static void follow(String sensor, String side, double kp, double p0) {
		double error;
		double leftSpeed = p0;
		double rightSpeed = p0;
		
		RobotMap.getChassis().tankDrive(p0, p0);
		
		while (RunHandler.isRunning()) {
			
			leftSpeed = p0;
			rightSpeed = p0;
			
			error = RobotMap.getSensor(sensor).read() - target;
			if (side.equalsIgnoreCase("left")) {
				leftSpeed = p0 + error * kp;
			} else {
				rightSpeed = p0 + error * kp;
			}
			
			RobotMap.getChassis().tankDrive(leftSpeed, rightSpeed);
			
		}
	}

	public static void followDegrees(double degrees, String sensor, String side, double kp, double p0, boolean brake) {
		RobotMap.getMotor("Lwheel").resetEncoder();
		RobotMap.getMotor("Rwheel").resetEncoder();

		double leftSpeed = p0;
		double rightSpeed = p0;
		
		double error;

		RobotMap.getChassis().tankDrive(p0, p0);
		
		while (RunHandler.isRunning() && RobotMap.getMotor("Lwheel").readEncoder() <= degrees
				&& RobotMap.getMotor("Rwheel").readEncoder() <= degrees) {
			
			leftSpeed = p0;
			rightSpeed = p0;
			
			error = RobotMap.getSensor(sensor).read() - target;
	
			if (side.equalsIgnoreCase("left")) {
				leftSpeed = p0 + error * kp;
			} else {
				rightSpeed = p0 + error * kp;
			}
			
			RobotMap.getChassis().tankDrive(leftSpeed, rightSpeed);
		}
		
		if (brake == true) {
			RobotMap.getChassis().brake();

		} else {
			RobotMap.getChassis().coast();
		}
	}

}
