package com.ec.htracker.model;

public class User {

	private int id;
	private String userName;
	private String password;
	private int goalcl;
	private int foodcl;
	private int exercisecl;

	public int getGoalcl() {
		return goalcl;
	}

	public void setGoalcl(int goalcl) {
		this.goalcl = goalcl;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", goalcl=" + goalcl
				+ ", foodcl=" + foodcl + ", exercisecl=" + exercisecl + "]";
	}
}
