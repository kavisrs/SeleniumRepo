package week4.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

	public static void main(String[] args) {
		//Launch https://www.snapdeal.com/
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		//Go to Mens Fashion
		Actions menFashionAct = new Actions(driver);
		WebElement menFashon = driver.findElement(By.linkText("Men's Fashion"));
		menFashionAct.moveToElement(menFashon).perform(); 
		
		//Go to Sports Shoes
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		
		//Get the count of the sports shoes
		WebElement shoesCount = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		System.out.println("Total sports shoes are: "+shoesCount.getText());
		
		//Click Training shoes
		driver.findElement(By.xpath("//ul/li/a/div[text()='Training Shoes']")).click();
		
		//Sort by Low to High
		Actions sort = new Actions(driver);
		driver.findElement(By.xpath("//div/i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		WebElement sortLowToHigh = driver.findElement(By.xpath("(//li[contains(@data-index,'1')])[2]"));
		sort.moveToElement(sortLowToHigh).click().perform();
		
		//Check if the items displayed are sorted correctly
		
		
		//Select the price range (900-1200)
		//Filter with color Navy 
		//verify the all applied filters 
		//Mouse Hover on first resulting Training shoes
		//click QuickView button
		//Print the cost and the discount percentage
		//Take the snapshot of the shoes.
		//Close the current window
		//Close the main window


	}

}
