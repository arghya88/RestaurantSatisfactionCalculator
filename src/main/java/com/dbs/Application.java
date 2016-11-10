package com.dbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.dbs.satisfactioncalculator.SatisfactionCalculator;
import com.dbs.satisfactioncalculator.service.SatisfactionCalulatorService;
import com.dbs.satisfactioncalculator.util.InputDataReader;

@SpringBootApplication
public class Application implements CommandLineRunner{
	@Autowired
	private SatisfactionCalculator satisfactionCal;
	@Autowired
	private InputDataReader inputDataReader;
	@Autowired
	private SatisfactionCalulatorService satisfactionCalService;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args){
		try {
			satisfactionCal=inputDataReader.readFile(satisfactionCal);
			int output=satisfactionCalService.calculateSatisfaction(satisfactionCal.getTotalTime(),satisfactionCal.getNoOfItems(),satisfactionCal.getDishes());
			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
