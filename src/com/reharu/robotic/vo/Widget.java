package com.reharu.robotic.vo;

public class Widget extends Scene{
	
	protected Scene src ;
	
	protected Integer correctX ;
	
	protected Integer correctY ;

	public Widget() {
		super();
	}
	
	public Widget(String name, String imgPath) {
		super(name, imgPath);
	}
	

	public Integer getCorrectX() {
		return correctX;
	}

	public void setCorrectX(Integer correctX) {
		this.correctX = correctX;
	}

	public Integer getCorrectY() {
		return correctY;
	}

	public void setCorrectY(Integer correctY) {
		this.correctY = correctY;
	}
	
	public Scene getSrc() {
		return src;
	}

	public void setSrc(Scene src) {
		this.src = src;
	}

	@Override
	public String toString() {
		return "Widget [src=" + src + ", correctX=" + correctX + ", correctY=" + correctY + ", id=" + id + ", name="
				+ name + ", imgPath=" + imgPath + ", width=" + width + ", height=" + height + ", oriWidth=" + oriWidth
				+ ", oriHeight=" + oriHeight + ", opencvImage=" + opencvImage + "]";
	}

}
