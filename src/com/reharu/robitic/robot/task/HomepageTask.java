package com.reharu.robitic.robot.task;

import com.reharu.robotic.vo.Role;
import com.reharu.robotic.vo.Scene;
import com.reharu.robotic.vo.Widget;

public class HomepageTask extends Task<Scene, Widget>{

	public HomepageTask(Scene scene, Widget... widgets) {
		super(scene, widgets);
	}

}
