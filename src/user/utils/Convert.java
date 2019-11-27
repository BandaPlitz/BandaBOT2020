package user.utils;

public class Convert {
	static double defaultCir = 17.59;
	
	public static int cmToDegrees(double cm, double cir){
		int deg = (int) (cm / cir * 360);
		return deg;
	}
	
	public static int cmToDegrees(double cm){
		int deg = (int) (cm / defaultCir * 360);
		return deg;
	}
	
	public static double degreesToCm(int deg, double cir){
		double cm = cir * deg / 360;
		return cm;
	}
	
	public static double degreesToCm(int deg){
		double cm = defaultCir * deg / 360;
		return cm;
	}
}
