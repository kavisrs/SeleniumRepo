package week3.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LearnList {

	public static void main(String[] args) {

		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
		driver.findElement(By.id("nav-search-submit-button")).click();

		// search mobile list
		List<WebElement> priceList = driver.findElements(By.className("a-price-whole"));
		List<Integer> list = new ArrayList<Integer>();
		for (WebElement each : priceList) {
			String text = each.getText();
			// Price 50,999 - replace , so that price will be displayed as 50999
			String replaceAll = text.replaceAll(",", "");
			//to overcome number format exception error
			if (!replaceAll.isEmpty()) {
				
			// to change string to Integer
			int parseInt = Integer.parseInt(replaceAll);
			
			list.add(parseInt);	
			}
		}
		Collections.sort(list);	
		System.out.println("All mobile prices:  " +list);
		
		// to print the lowest price
		System.out.println("Lowest mobile price: " +list.get(0));
		


	}













}





