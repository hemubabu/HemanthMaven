package com.StepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

public class FlipOilStepDefinition {
	public static WebDriver driver;
	@Given("User launches the application")
	public void user_launches_the_application() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	    
	}

	@Given("User quits the button")
	public void user_quits_the_button() {
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	    
	}

	
	@When("User enters beard oil name")
	public void user_enters_beard_oil_name() {
		
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("beard growth oil",Keys.ENTER);
		
	
	    
	}

	@When("User choose the beard oil")
	public void user_choose_the_beard_oil() {
		driver.findElement(By.xpath("(//a[contains(text(),'USTRAA ')])[1]")).click();
		
	}

	@Then("User Validates the price")
	public void user_validates_the_price() throws InterruptedException {
		Thread.sleep(3000);
		String PWin=driver.getWindowHandle();
		Set<String> CWin=driver.getWindowHandles();
		List <String> child= new ArrayList<String>(CWin);
		String Childwindow = child.get(1);
		Thread.sleep(3000);
		driver.switchTo().window(Childwindow);	

	    
		WebElement price=driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']"));
		String Price =price.getText();
		System.out.println("Price of beard growth oil is" +Price);
		driver.quit();
		
//		System.out.println(PWin);
//		System.out.println(Childwindow);
	    	}

}
