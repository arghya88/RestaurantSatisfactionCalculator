package com.dbs.satisfactioncalculator.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.dbs.satisfactioncalculator.SatisfactionCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InputDataReaderTest {
	@Autowired
	InputDataReader inputDataReader;
	@Autowired
	SatisfactionCalculator satisfactionCalculator;
	@Before
	public void setUp() throws Exception{
		satisfactionCalculator=inputDataReader.readFile(satisfactionCalculator);
	}
	@Test
	public void testReadCorrectFile() {
		Assert.assertEquals("data.txt", inputDataReader.getFileName());
	}
	@Test
	public void testReadCorrectInputFromFile() {
		Assert.assertEquals(100, satisfactionCalculator.getNoOfItems());
		Assert.assertEquals(10000, satisfactionCalculator.getTotalTime());
		Assert.assertEquals(satisfactionCalculator.getNoOfItems(),satisfactionCalculator.getDishes().size());
	}
}
