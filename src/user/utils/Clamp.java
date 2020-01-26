package user.utils;

import robot.runs.RunHandler;

public class Clamp {

	public static double Clamp(double value, double max, double min) {
		if (value > max) value = max;
		else if (value < min) value = min;
		
		return value;
	}
	
	public static double Speed(double value) {
		if (value > 1) value = 1;
		else if (value < -1) value = -1;
		
		return value;
	}
	
	public static double angle(double value) {
		double realAngle = value % 360;
		if(realAngle > 0) {
			if(realAngle >= 180) {
				return 180 - realAngle;
			}
		}
		return realAngle;
	}
	
	
}
