package com.reharu.robitic.robot.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.reharu.robotic.vo.Scene;
import com.reharu.robotic.vo.Widget;
public class Task<S extends Scene, T extends Widget> {
	
	private S scene ;
	
	private List<T> widgetList = new ArrayList<>();
	
	public Task(S scene,T... widgets) {
		super();
		this.scene = scene;
		this.widgetList .addAll(Arrays.asList(widgets));
	}

	public S getScene() {
		return scene;
	}

	public void setScene(S scene) {
		this.scene = scene;
	}

	public List<T> getWidgetList() {
		return widgetList;
	}

	public void setWidgetList(List<T> widgetList) {
		this.widgetList = widgetList;
	}
	
	public Scene getSrcScene(){
		return getScene() ;
	}

	@Override
	public String toString() {
		return "Task [scene=" + scene + ", widgetList=" + widgetList + "]";
	}
	
}