package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearh {
	
	public static void main(String[] args) {
		
		//set up chrome driver path
		WebDriverManager.chromedriver().setup();
		//invoke selenium webdriver
		WebDriver driver=new ChromeDriver();
		//fullscreen
		driver.manage().window().fullscreen();
		//set universal wait time in case web page is slow
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		/*step 1. launch browser and navigate to https://dice.com
		  expected: dice home page should be displayed
		*/
		String url= "http://dice.com";
		driver.get(url);
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Job Search for Technology Professionals | Dice.com";
				
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("step Pass. Dice homepage succesfully loaded.");
		}else {
			System.out.println("Step Fail. Dice homepage did not load successfully loaded.");
			throw new RuntimeException("Step fail.Dice homepage did not load successfully loaded.");
		}
		
		String keyword="java developer";
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys("keyword");
		
		
		String location="22102";
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys("location");
		
		driver.findElement(By.id("fingTechJobs")).click();
		
		String count=driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		//ensure count is more than o
		
		int countResult=Integer.parseInt(count.replace(",",""));
		
		if(countResult>0) {
			System.out.println("Step PASS: Keyword: "+keyword+ " search returned"+ count);
		}else {
			System.out.println("Step FAIL: Keyword: "+keyword+ " search returned"+ count);
		}
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
}