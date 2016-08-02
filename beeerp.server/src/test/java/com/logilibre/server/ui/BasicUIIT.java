package com.logilibre.server.ui;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicUIIT {
	private static final String BASE_TEST_URL = "http://localhost:8080/beeerp.server";
	private WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

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

	private void waitPageLoad() {
		new WebDriverWait(driver, 10).until((WebDriver dr) -> dr.findElement(By.id("footer")));
	}
}
