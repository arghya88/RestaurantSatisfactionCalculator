package com.dbs.satisfactioncalculator.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.dbs.satisfactioncalculator.domain.Dish;

@Service
public class SatisfactionCalulatorServiceImpl implements SatisfactionCalulatorService {

	@Override
	public int calculateSatisfaction(int totalTime,int noOfItems,List<Dish> dishes) {
		int[] satisfaction=new int[noOfItems];
		int[] time=new int[noOfItems];
		for (int i=0;i<dishes.size();i++) {
			satisfaction[i]=dishes.get(i).getSatisfaction();
			time[i]=dishes.get(i).getTimeToEat();
		}
		int[][] V = new int[noOfItems + 1][totalTime + 1];

		for (int col = 0; col <=totalTime ; col++) {
			V[0][col] = 0;
		}

		for (int row = 0; row <= noOfItems; row++) {
			V[row][0] = 0;
		}
		for (int item=1;item<=noOfItems;item++){
			for (int weight=1;weight<=totalTime;weight++){
				if (time[item-1]<=weight){
					V[item][weight]=Math.max(satisfaction[item-1]+V[item-1][weight-time[item-1]], V[item-1][weight]);
				}
				else {
					V[item][weight]=V[item-1][weight];
				}
			}
		}
		return V[noOfItems][totalTime];

	}

}
