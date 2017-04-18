package com.logilibre.server.ui;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ValidatorBeckendUIIT extends UITestBase {
	@Test
	public void addWrongValue_showError() throws Exception {
		driver.get(BASE_TEST_URL + "/timesheet/weekly_time/add");
		waitPageLoad();
		WebElement inputTime = driver.findElement(By.name("time"));
		inputTime.clear();
		inputTime.sendKeys("2.254");

		inputTime.submit();
		waitPageLoad();
		inputTime = driver.findElement(By.name("time"));
		assertEquals("2.254", inputTime.getAttribute("value"));

		List<WebElement> errorDisplay = driver.findElements(By.cssSelector("strong.error"));
		assertEquals(1, errorDisplay.size());
	}

	@Test
	public void updateWrongValue_showError() throws Exception {
		driver.get(BASE_TEST_URL + "/timesheet/weekly_time/add");
		waitPageLoad();
		WebElement inputTime = driver.findElement(By.name("time"));
		inputTime.clear();
		inputTime.sendKeys("2.25");

		inputTime.submit();
		waitPageLoad();
		inputTime = driver.findElement(By.name("time"));
		assertEquals("2.25", inputTime.getAttribute("value"));

		List<WebElement> errorDisplay = driver.findElements(By.cssSelector("strong.error"));
		assertEquals(0, errorDisplay.size());

		String currentUrl = driver.getCurrentUrl();
		String[] urlParts = currentUrl.split("/");
		String newId = urlParts[urlParts.length - 1];

		driver.get(BASE_TEST_URL + "/timesheet/weekly_time/update/" + newId);
		waitPageLoad();
		inputTime = driver.findElement(By.name("time"));
		inputTime.clear();
		inputTime.sendKeys("2.254");

		inputTime.submit();
		waitPageLoad();
		inputTime = driver.findElement(By.name("time"));
		assertEquals("2.254", inputTime.getAttribute("value"));

		errorDisplay = driver.findElements(By.cssSelector("strong.error"));
		assertEquals(1, errorDisplay.size());

		driver.get(BASE_TEST_URL + "/timesheet/weekly_time/delete/" + newId);
		waitPageLoad();
		inputTime = driver.findElement(By.name("time"));
		inputTime.submit();

		waitPageLoad();
		inputTime = driver.findElement(By.name("time"));
		assertNotNull(inputTime.getAttribute("value"));
	}
}
