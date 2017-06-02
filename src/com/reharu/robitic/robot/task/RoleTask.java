package com.reharu.robitic.robot.task;

import com.reharu.robotic.vo.Role;
import com.reharu.robotic.vo.RolePart;
import com.reharu.robotic.vo.Scene;

public class RoleTask extends Task<Role, RolePart>{

	public RoleTask(Role role, RolePart... widgets) {
		super(role, widgets);
	}
	
	@Override
	public Scene getSrcScene() {
		return getScene().getSrc();
	}
}
