package user;

import robot.hardware.chassis.RobotChassis;
import robot.hardware.motors.LargeMotor;
import robot.hardware.sensors.ColorSensor;
import robot.hardware.sensors.GyroSensor;
import user.runs.ColourReset;
import user.runs.Run0;
import user.runs.Run1;
import user.runs.Run2;
import user.runs.Run3;
import user.runs.Run4;

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
		new Run0("run 0");
		new Run1("run 1");
		new Run2("run 2");
		new Run3("run SHAHAR");
		new Run4("run tree");
		new ColourReset("colourreset");
		
	}

	public static void init() {
		//code that you want to run ONCE 
		//before the main menu starts
	}
	
}
