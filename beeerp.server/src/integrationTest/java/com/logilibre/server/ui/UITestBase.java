package com.logilibre.server.ui;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UITestBase {

	protected static final String BASE_TEST_URL = "http://localhost:8080/beeerp.server";
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	private void removeQAReadyTag() {
		JavascriptExecutor js;
		if (driver instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) driver;
			js.executeScript("return document.getElementById('footer').remove();");
		}
	}

	protected void waitPageLoad() {
		new WebDriverWait(driver, 10).until((WebDriver dr) -> dr.findElement(By.id("footer")));
		removeQAReadyTag();// workarround not-blocking issue with selenium3 and marionette driver on form submit.
	}
}
