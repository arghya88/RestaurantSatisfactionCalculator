package com.dbs.satisfactioncalculator.service;

import java.util.List;
import com.dbs.satisfactioncalculator.domain.Dish;

public interface SatisfactionCalulatorService {
	public int calculateSatisfaction(int timeToEat,int noOfItems,List<Dish> dish);
}
