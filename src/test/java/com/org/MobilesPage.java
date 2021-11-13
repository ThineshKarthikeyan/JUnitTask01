package com.org;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilesPage {
	
	static WebDriver driver;
	static long startTime, endTime;
	
	@BeforeClass
	public static void Launch() {
		System.out.println("Before Class");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Before
	public void beforeMethod() {
		startTime = System.currentTimeMillis();

	}
	
	@Test
	public void mobileSearch() {
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("Mobiles",Keys.ENTER);

	}
	
	@Test
	public void choosingMobiles() {
		driver.findElement(By.className("_4rR01T")).click();

	}
	
	@After
	public void afterMethod() {
		endTime = System.currentTimeMillis();
		long t = endTime - startTime;
		System.out.println("Time taken to complete task is " + t );

	}
	
	@AfterClass
	public static void closeBrowser() {
		driver.quit();

	}


}
