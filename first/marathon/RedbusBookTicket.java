package first.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class RedbusBookTicket {

	public static void main(String[] args) throws Exception {
		
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("chennai");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div/main//div/ul/li[2]")).click();
		
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//main//div/div/div/ul/li[1]")).click();
		driver.findElement(By.xpath("//div/table/tbody/tr[5]/td[4]")).click();
		driver.findElement(By.id("search_btn")).click();
	//	WebElement noOfBuses = driver.findElement(By.className("f-bold busFound"));
	//	String text = driver.getText();
		//System.out.println(getText);
		
		
		

		
		
	
	
	
	
	
	
	
		}


}
