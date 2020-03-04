package user.utils;

public class Convert {
	static double defaultCir = 17.59;
	
	public static double cmToDegrees(double cm, double cir){
		double deg = cm / cir * 360;
		return deg;
	}
	
	public static double cmToDegrees(double cm){
		return cmToDegrees(cm, defaultCir);
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
