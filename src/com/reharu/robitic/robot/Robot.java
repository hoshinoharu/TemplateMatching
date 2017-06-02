package com.reharu.robitic.robot;

import java.util.Arrays;
import java.util.List;

import org.opencv.core.Rect;

import com.reharu.robitic.robot.task.HomepageTask;
import com.reharu.robitic.robot.task.RoleTask;
import com.reharu.robitic.robot.task.Task;
import com.reharu.robotic.opencv.OpencvImage;
import com.reharu.robotic.vo.Role;
import com.reharu.robotic.vo.RolePart;
import com.reharu.robotic.vo.Scene;
import com.reharu.robotic.vo.Widget;

public class Robot {
	
	public void homepageTrain(HomepageTask... tasks){
		homepageTrain(Arrays.asList(tasks));
	}
	
	public void homepageTrain(List<HomepageTask> taskList){
		for(HomepageTask task : taskList){
			homepageTrain(task);
		}
	}
	
	public void homepageTrain(HomepageTask task){
		
		teamplatTrain(task);
		for(Widget widget : task.getWidgetList()){
			
			OpencvImage dst = widget.getOpencvImage() ;
			
			if(widget instanceof Role){
				
				Role role = (Role) widget ;
				RolePart head = new RolePart(role.getName()+"头部", "imgs/parts/head/"+dst.getFileName());
				RolePart chest = new RolePart(role.getName()+"胸部", "imgs/parts/chest/"+dst.getFileName());
				RolePart belly = new RolePart(role.getName()+"腹部", "imgs/parts/belly/"+dst.getFileName());
				RolePart priva = new RolePart(role.getName()+"秘密", "imgs/parts/private/"+dst.getFileName());
				RolePart lefthand = new RolePart(role.getName()+"左手", "imgs/parts/lefthand/"+dst.getFileName());
				RolePart righthand = new RolePart(role.getName()+"右手", "imgs/parts/righthand/"+dst.getFileName());
				RolePart leftleg = new RolePart(role.getName()+"左腿", "imgs/parts/leftleg/"+dst.getFileName());
				RolePart rightleg = new RolePart(role.getName()+"右腿", "imgs/parts/rightleg/"+dst.getFileName());
				
				role.setHead(head);
				role.setChest(chest);
				role.setBelly(belly);
				role.setPriva(priva);
				role.setLefthand(lefthand);
				role.setLeftleg(leftleg);
				role.setRighthand(righthand);
				role.setRightleg(rightleg);
				
				RoleTask roleTask = new RoleTask(role, head,chest, belly, priva, lefthand, righthand, leftleg, rightleg) ;
				roleTrain(roleTask);
			}
		}
	}
	
	public void roleTrain(RoleTask roleTask){
		
		teamplatTrain(roleTask);
		
	}
	
	private void teamplatTrain(Task task){
		
		Scene scene = task.getSrcScene() ;
		OpencvImage src = scene.getOpencvImage() ;
		scene.setOriHeight(src.getRows());
		scene.setOriWidth(src.getCols());
		scene.setHeight(src.getRows());
		scene.setWidth(src.getCols());
		
		for(Widget widget : (List<Widget>)task.getWidgetList()){
			
			OpencvImage dst = widget.getOpencvImage() ;
			
			Rect rect = src.templateMatches(dst) ;
			
			widget.setCorrectX(rect.x);
			widget.setCorrectY(rect.y);
			widget.setWidth(dst.getCols());
			widget.setHeight(dst.getRows());
			widget.setOriWidth(dst.getCols());
			widget.setOriHeight(dst.getRows());
			widget.setSrc(scene);
		}
	}
	
}
