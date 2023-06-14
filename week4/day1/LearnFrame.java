//  Classroom:
//  Load this url(https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm)
//  click Try it button
//  Accept the alert
//  get the text and verify

package week4.day1;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LearnFrame {
	
	public static void main(String[] args) throws InterruptedException {
			EdgeDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
			//switchto frame
			driver.switchTo().frame("iframeResult");
			
			//click try it
			driver.findElement(By.xpath("//button[text()=\"Try it\"]")).click();
			//come out of frame
			//driver.switchTo().defaultContent();
			
			//accept the alert
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			
			System.out.println("Text in the alert box:  " +text);
			alert.accept();
			
//			driver.switchTo().alert().accept();
			
			WebElement get1 = driver.findElement(By.id("demo"));
			String text2 = get1.getText();
			System.out.println(text2);
			
			if (text2.contains("pressed")) {
				System.out.println("Alert is accepted");
				
			} else {
				System.out.println("Alert is cancelled");
			}
			
			driver.quit();
			
			
			
			
			
	}

}
