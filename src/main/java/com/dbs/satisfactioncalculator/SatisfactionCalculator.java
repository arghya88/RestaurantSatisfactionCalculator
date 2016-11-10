package com.dbs.satisfactioncalculator;

import java.util.List;
import org.springframework.stereotype.Component;
import com.dbs.satisfactioncalculator.domain.Dish;

@Component
public class SatisfactionCalculator {
	private List<Dish> dishes;
	private int totalTime;
	private int noOfItems;
	public List<Dish> getDishes() {
		return dishes;
	}
	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
}
