package user.runs;

import robot.RobotMap;
import robot.runs.RobotRun;
import robot.runs.RunHandler;
import user.utils.LineFollow;

public class ColourReset extends RobotRun {

	public ColourReset(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runInstructions() {
		//while (RunHandler.isRunning()) {
			//System.out.println(RobotMap.getSensor("lcolours").read());
		LineFollow.follow("lcolours", "right", 0.7, 0.5);
			
		
	}

	
	
}
