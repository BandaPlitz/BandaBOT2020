package user;

import robot.hardware.chassis.RobotChassis;
import robot.hardware.motors.LargeMotor;
import robot.hardware.sensors.ColorSensor;
import robot.hardware.sensors.GyroSensor;

public class HardwareCreator {
	public static void init() {
			//init your hardware here
		new RobotChassis("Lwheel", 'C', "Rwheel", 'B');
		new LargeMotor("larm", 'D');
		new LargeMotor("rarm", 'A');
		new ColorSensor("lcolours", 1);
		new ColorSensor("rcolours", 4);
		new GyroSensor("gyro", 2);
	}
}
