package com.dbs.satisfactioncalculator.domain;

public class Dish {
	private int satisfaction;
	private int timeToEat;
	public Dish(int satisfaction, int timeToEat) {
		if(satisfaction<=0){
			throw new IllegalArgumentException("Satisfaction value should be positive");
		}
		if(timeToEat<=0){
			throw new IllegalArgumentException("Time required to eat food can not be negative");
		}
		this.satisfaction=satisfaction;
		this.timeToEat=timeToEat;
	}
	public int getSatisfaction() {
		return satisfaction;
	}
	public int getTimeToEat() {
		return timeToEat;
	}
}
