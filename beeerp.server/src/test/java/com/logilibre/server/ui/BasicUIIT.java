package com.logilibre.server.ui;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasicUIIT extends UITestBase {
	@Test
	public void getInitialValue() throws Exception {
		driver.get(BASE_TEST_URL + "/timesheet/weekly_time/get/1");
		waitPageLoad();
		WebElement inputTime = driver.findElement(By.name("time"));
		assertNotNull(inputTime.getAttribute("value"));
	}

	@Test
	public void addAndDeleteValue() throws Exception {
		driver.get(BASE_TEST_URL + "/timesheet/weekly_time/add");
		waitPageLoad();
		WebElement inputTime = driver.findElement(By.name("time"));
		inputTime.clear();
		inputTime.sendKeys("5.75");

		inputTime.submit();
		waitPageLoad();
		inputTime = driver.findElement(By.name("time"));

		assertEquals("5.75", inputTime.getAttribute("value"));

		String currentUrl = driver.getCurrentUrl();
		String[] urlParts = currentUrl.split("/");
		String newId = urlParts[urlParts.length - 1];

		driver.get(BASE_TEST_URL + "/timesheet/weekly_time/update/" + newId);
		waitPageLoad();
		inputTime = driver.findElement(By.name("time"));
		inputTime.clear();
		inputTime.sendKeys("2.25");

		inputTime.submit();
		waitPageLoad();
		inputTime = driver.findElement(By.name("time"));

		assertEquals("2.25", inputTime.getAttribute("value"));

		driver.get(BASE_TEST_URL + "/timesheet/weekly_time/delete/" + newId);
		waitPageLoad();
		inputTime = driver.findElement(By.name("time"));
		inputTime.submit();

		waitPageLoad();
		inputTime = driver.findElement(By.name("time"));
		assertNotNull(inputTime.getAttribute("value"));
	}

	@Test
	public void addAndDeleteValuepOnASecondEntity() throws Exception {
		driver.get(BASE_TEST_URL + "/timesheet/wage_states/add");
		waitPageLoad();
		WebElement weeklyWage = driver.findElement(By.name("weeklyWage"));
		weeklyWage.clear();
		weeklyWage.sendKeys("200");

		weeklyWage.submit();
		waitPageLoad();
		weeklyWage = driver.findElement(By.name("weeklyWage"));

		assertEquals("200", weeklyWage.getAttribute("value"));

		String currentUrl = driver.getCurrentUrl();
		String[] urlParts = currentUrl.split("/");
		String newId = urlParts[urlParts.length - 1];

		driver.get(BASE_TEST_URL + "/timesheet/wage_states/update/" + newId);
		waitPageLoad();
		weeklyWage = driver.findElement(By.name("weeklyWage"));
		weeklyWage.clear();
		weeklyWage.sendKeys("500");

		weeklyWage.submit();
		waitPageLoad();
		weeklyWage = driver.findElement(By.name("weeklyWage"));

		assertEquals("500", weeklyWage.getAttribute("value"));

		driver.get(BASE_TEST_URL + "/timesheet/wage_states/delete/" + newId);
		waitPageLoad();
		weeklyWage = driver.findElement(By.name("weeklyWage"));
		weeklyWage.submit();

		waitPageLoad();
		weeklyWage = driver.findElement(By.name("weeklyWage"));
		assertNotNull(weeklyWage.getAttribute("value"));
	}
}
