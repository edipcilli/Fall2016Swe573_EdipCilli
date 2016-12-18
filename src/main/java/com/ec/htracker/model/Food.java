package com.ec.htracker.model;
import java.sql.Date;

public class Food {
	
	private String foodName;

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	@Override
	public String toString() {
		return "Food [foodName=" + foodName + "]";
	}

}



