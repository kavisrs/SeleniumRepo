//Classroom:
//  1)Load the url(https://www.leafground.com/alert.xhtml)
//  2)Click Confirm Dialog/click show Button
//  3)Read the text of the Confirmation alert
//  3)accept/dismiss the alert
//  4)Confirm whether you have successfully handled the alert

package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException {
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//confirm alert
		driver.findElement(By.xpath(("(//span[text()='Show'])[2]"))).click();
		Thread.sleep(3000);
		
		//switchto 
		Alert alert = driver.switchTo().alert();
		//read the text of the alert
		String text = alert.getText();
		System.out.println("Message in the alert box: " +text);
		
		//accept the alert
		alert.accept();
		
		WebElement element = driver.findElement(By.xpath("//span[@id=\"result\"]"));
		String text2 = element.getText();
		System.out.println("Alert Clicked?  " +text2);
		driver.quit();
		
	}

}
 