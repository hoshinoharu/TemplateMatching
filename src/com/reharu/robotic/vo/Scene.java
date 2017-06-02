package com.reharu.robotic.vo;

import com.reharu.robotic.opencv.OpencvImage;

public class Scene {
	
	protected Integer id ;
	
	protected String name ;
	
	protected String imgPath ;

	protected Integer width ;
	
	protected Integer height ;
	
	protected Integer oriWidth ;
	
	protected Integer oriHeight ;
	
	protected OpencvImage opencvImage ;
	
	public Scene() {
		super();
	}
	
	public Scene(String name, String imgPath) {
		super();
		this.name = name ;
		this.imgPath = imgPath;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getOriWidth() {
		return oriWidth;
	}

	public void setOriWidth(Integer oriWidth) {
		this.oriWidth = oriWidth;
	}

	public Integer getOriHeight() {
		return oriHeight;
	}

	public void setOriHeight(Integer oriHeight) {
		this.oriHeight = oriHeight;
	}
	
	public OpencvImage getOpencvImage() {
		if(opencvImage == null){
			opencvImage = new OpencvImage(imgPath) ;
		}
		return opencvImage;
	}
	@Override
	public String toString() {
		return "Scene [id=" + id + ", name=" + name + ", imgPath=" + imgPath + ", width=" + width + ", height=" + height
				+ ", oriWidth=" + oriWidth + ", oriHeight=" + oriHeight + "]";
	}
}
