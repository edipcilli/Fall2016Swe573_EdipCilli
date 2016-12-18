package com.ec.htracker.model;
import java.sql.Date;


public class UserInfo {

	private int id;
	private int userid;
	private int foodcl;
	private int exercisecl;
	private Date calcday;
	private int remainingcl;
	private String ndbno;
	
	public String getNdbno() {
		return ndbno;
	}
	public void setNdbno(String ndbno) {
		this.ndbno = ndbno;
	}
	public int getRemainingcl() {
		return remainingcl;
	}
	public void setRemainingcl(int remainingcl) {
		this.remainingcl = remainingcl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getFoodcl() {
		return foodcl;
	}
	public void setFoodcl(int foodcl) {
		this.foodcl = foodcl;
	}
	public int getExercisecl() {
		return exercisecl;
	}
	public void setExercisecl(int exercisecl) {
		this.exercisecl = exercisecl;
	}
	public Date getCalcday() {
		return calcday;
	}
	public void setCalcday(Date calcday) {
		this.calcday = calcday;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userid=" + userid + ", foodcl=" + foodcl + ", exercisecl=" + exercisecl
				+ ", calcday=" + calcday + ", remainingcl=" + remainingcl + ", ndbno=" + ndbno + "]";
	}


	

}
