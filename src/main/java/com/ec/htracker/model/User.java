package com.ec.htracker.model;
import java.sql.Date;


public class User {

	private int id;
	private String userName;
	private String password;
	private double currentweight;
	private int height;
	private Date dateofbirth;
	private double goalweight;
	private Date goaldate;
	private String notes;
	private double currentBMI;
	private double goalBMI;
	private int dailycalory;
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getCurrentweight() {
		return currentweight;
	}

	public void setCurrentweight(double currentweight) {
		this.currentweight = currentweight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public double getGoalweight() {
		return goalweight;
	}

	public void setGoalweight(double goalweight) {
		this.goalweight = goalweight;
	}

	public Date getGoaldate() {
		return goaldate;
	}

	public void setGoaldate(Date goaldate) {
		this.goaldate = goaldate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getCurrentBMI() {
		return currentBMI;
	}

	public void setCurrentBMI(double currentBMI) {
		this.currentBMI = currentBMI;
	}

	public double getGoalBMI() {
		return goalBMI;
	}

	public void setGoalBMI(double goalBMI) {
		this.goalBMI = goalBMI;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDailycalory() {
		return dailycalory;
	}

	public void setDailycalory(int dailycalory) {
		this.dailycalory = dailycalory;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", currentweight="
				+ currentweight + ", height=" + height + ", dateofbirth=" + dateofbirth + ", goalweight=" + goalweight
				+ ", goaldate=" + goaldate + ", notes=" + notes + ", currentBMI=" + currentBMI + ", goalBMI=" + goalBMI
				+ ", dailycalory=" + dailycalory + ", gender=" + gender + "]";
	}

	


	

}
