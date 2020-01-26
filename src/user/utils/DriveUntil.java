package user.utils;

import robot.RobotMap;

public class DriveUntil {
	
	public static void driveUntilBlack (double lSpeed,double rSpeed, String sensor, boolean brake) {
		RobotMap.getChassis().tankDrive(lSpeed, rSpeed);
		System.out.println("start: " + LineFollow.black);
		
		while (RobotMap.getSensor(sensor).read() != LineFollow.black) ;
		
		if (brake) {
			RobotMap.getChassis().brake();
		} else {
			RobotMap.getChassis().coast();
		}
	}

}
