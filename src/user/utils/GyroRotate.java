package user.utils;

import robot.RobotMap;
import robot.runs.RunHandler;


public class GyroRotate {
	
	public static void gyroRotate(int angle, double Kp) {
		int error;
		double correction;
		int gyro;
		System.out.println("start");
		while (RunHandler.isRunning() && Math.abs(RobotMap.getSensor("gyro").read() - angle) > 5){
			gyro = (int) Clamp.angle(RobotMap.getSensor("gyro").read());
			error = (int) ((gyro - angle) / 180);
			System.out.println("gyro: " + gyro);
			correction = Clamp.Speed(error * Kp);
			System.out.println("error: " + error);
			RobotMap.getChassis().tankDrive(correction, -correction);
		}
		System.out.println("finished");
		RobotMap.getChassis().brake();
	}
	
	

}
