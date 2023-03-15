package com.StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipPhonesstepdefinition {
	public static WebDriver driver; 
	
	static String phone;
	
	
	@Given("User launches the app")
	public void user_launches_the_app() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}
	    
	

	@Given("User quit the button")
	public void user_quit_the_button() {
	   driver.findElement(By.xpath("//button[text()='✕']")).click();
	}

	@When("User enters the phone name")
	public void user_enters_the_phone_name() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("OnePlus",Keys.ENTER);
		
	}

	@Then("User prints the phone name")
	public void user_prints_the_phone_name() throws InterruptedException {
		System.out.println("OnePlus Models");
		Thread.sleep(3000);
		List<WebElement> oneplus = driver.findElements(By.xpath("//a[contains(@title,'OnePlus ')]"));
		for(int i=0;i<oneplus.size();i++) {
			WebElement oneplusphoneslist = oneplus.get(i);
			String Onepluslist = oneplusphoneslist.getText();
			System.out.println(Onepluslist);
		}
		driver.quit();
		}
	@When("User enters the multiple phones names {string}")
	public void user_enters_the_multiple_phones_names(String Phones) {
	    phone=Phones;
	    WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(phone,Keys.ENTER);
	}

	@Then("User Validates the multiple phone names")
	public void user_validates_the_multiple_phone_names() throws InterruptedException {
		System.out.println("Samsung LG Oppo Models");
		Thread.sleep(3000);
		List<WebElement> Phones = driver.findElements(By.xpath("//a[contains(@title,'"+phone+"')]"));
		for(int i=0;i<Phones.size();i++) {
			WebElement phones = Phones.get(i);
			String phoneslist = phones.getText();
			System.out.println(phoneslist);
		}
		driver.quit();
		
	    
	}
	   


}