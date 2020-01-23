package user;

import robot.hardware.chassis.RobotChassis;
import robot.hardware.motors.LargeMotor;
import robot.hardware.sensors.ColorSensor;
import robot.hardware.sensors.GyroSensor;
import user.runs.ColourReset;
import user.runs.Run1;

public class Startup {
	
	public static void createHardware() {
		new RobotChassis("Lwheel", 'C', "Rwheel", 'B');
		new LargeMotor("larm", 'D');
		new LargeMotor("rarm", 'A');
		new ColorSensor("lcolours", 1);
		new ColorSensor("rcolours", 4);
		new GyroSensor("gyro", 2);
	}
	
	public static void createRuns() {
		new Run1("run tree");
		new ColourReset("colourreset");
	}
	
	public static void init() {
		//code that you want to run ONCE 
		//before the main menu starts
	}
	
}
