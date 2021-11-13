package com.org;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class YouTube {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement searchBox = driver.findElement(By.xpath("(//input[@type='text'])"));
		searchBox.sendKeys("Samsung Mobiles",Keys.ENTER);
		WebElement mobileChosen = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
		String mobileName1 = mobileChosen.getText();
		mobileChosen.click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//span[@aria-hidden='true'])[1]")).click();
		WebElement addedMobile = driver.findElement(By.xpath("//span[@class='a-truncate-cut']"));
		String mobileName2 = addedMobile.getText();
		if (mobileName1.equals(mobileName2)) {
			System.out.println("Passed");
			System.out.println("The Mobile name is "+ mobileName2);
			
		}
		
		
	}

}
