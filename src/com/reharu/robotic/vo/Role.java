package com.reharu.robotic.vo;

public class Role extends Widget{

	private RolePart head ;
	
	private RolePart chest ;
	
	private RolePart belly ;
	
	private RolePart priva ;
	
	private RolePart lefthand ;
	
	private RolePart leftleg ;
	
	private RolePart righthand ;
	
	private RolePart rightleg ;
	
	
	public Role(String name, String imgPath) {
		super(name, imgPath) ;
	}

	
	
	public RolePart getHead() {
		return head;
	}



	public void setHead(RolePart head) {
		this.head = head;
	}



	public RolePart getChest() {
		return chest;
	}



	public void setChest(RolePart chest) {
		this.chest = chest;
	}



	public RolePart getBelly() {
		return belly;
	}



	public void setBelly(RolePart belly) {
		this.belly = belly;
	}



	public RolePart getPriva() {
		return priva;
	}



	public void setPriva(RolePart priva) {
		this.priva = priva;
	}



	public RolePart getLefthand() {
		return lefthand;
	}



	public void setLefthand(RolePart lefthand) {
		this.lefthand = lefthand;
	}



	public RolePart getLeftleg() {
		return leftleg;
	}



	public void setLeftleg(RolePart leftleg) {
		this.leftleg = leftleg;
	}



	public RolePart getRighthand() {
		return righthand;
	}



	public void setRighthand(RolePart righthand) {
		this.righthand = righthand;
	}



	public RolePart getRightleg() {
		return rightleg;
	}



	public void setRightleg(RolePart rightleg) {
		this.rightleg = rightleg;
	}



	@Override
	public String toString() {
		return "Role [src=" + src + ", correctX=" + correctX + ", correctY=" + correctY + ", id=" + id + ", name="
				+ name + ", imgPath=" + imgPath + ", width=" + width + ", height=" + height + ", oriWidth=" + oriWidth
				+ ", oriHeight=" + oriHeight + ", opencvImage=" + opencvImage + "]";
	}
}
