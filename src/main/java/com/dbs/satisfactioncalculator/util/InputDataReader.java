package com.dbs.satisfactioncalculator.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import com.dbs.satisfactioncalculator.SatisfactionCalculator;
import com.dbs.satisfactioncalculator.domain.Dish;

@Component
public class InputDataReader {
	@Value("${input.file.name}")
	private String fileName;
	@Autowired
	private ResourceLoader resourceLoader;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public SatisfactionCalculator readFile(SatisfactionCalculator app) throws IOException{
		Resource resource = resourceLoader.getResource("classpath:" + fileName);

		File file = resource.getFile();
		try(BufferedReader br = new BufferedReader(new FileReader(file))){

			String firstLine = br.readLine();

			String values[] = firstLine.split(" ");

			int totalTime= Integer.parseInt(values[0]);
			int noOfItems = Integer.parseInt(values[1]);
			List<Dish>dishes=createDish(br);
			app.setDishes(dishes);
			app.setNoOfItems(noOfItems);
			app.setTotalTime(totalTime);
		}
		return app;

	}

	private List<Dish> createDish(BufferedReader br) throws NumberFormatException, IOException {
		String currentLine;
		String[] values;		
		List<Dish> dishes= new ArrayList<Dish>();

		while ((currentLine = br.readLine()) != null) {

			values = currentLine.split(" ");

			int satisfaction= Integer.parseInt(values[0]);
			int timeToEat = Integer.parseInt(values[1]);

			Dish dish = new Dish(satisfaction,timeToEat);
			dishes.add(dish);
		}
		return dishes;

	}
}
