package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NykaaShopping {

	public static void main(String[] args) { 
		//EdgeOptions option = new EdgeOptions();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		//EdgeDriver driver = new EdgeDriver();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Mouseover on Brands and Search L'Oreal Paris
		WebElement element = driver.findElement(By.xpath("//a[text()='brands']"));

		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
		//Click L'Oreal Paris
		driver.findElement(By.xpath("(//div[@class='css-ov2o3v']/a)[6]")).click();
		
		//Check the title contains L'Oreal Paris(Hint-GetTitle)
		String lpBrand = driver.getTitle();
		if (lpBrand.contains("L'Oreal Paris")) {
			System.out.println("Title contains L'Oreal Paris");
		}
		else {
			System.out.println("Title does not contain L'Oreal Paris");
		}
		
		//Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'control-indicator radio')])[4]")).click();
		
		//Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//div/ul/ul/li/div/span[text()='Hair']")).click();
		driver.findElement(By.xpath("//div//ul/li/div/span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		//Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		//check whether the Filter is applied with Shampoo
		WebElement shampooElement = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		WebElement colprotectElement = driver.findElement(By.xpath("(//span[text()='Color Protection'])[1]"));
		String shampooText = shampooElement.getText();
		String colprotectText = colprotectElement.getText();
		
		if (shampooText.contains("Shampoo")&& colprotectText.contains("Color Protection")) {
			System.out.println("Filter is applied with shampoo");
		}
		else {
			System.out.println("Filter is not applied with shampoo");
		}
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[@class='css-d5z3ro']/a")).click();
		
		//GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> shampooWindow = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(shampooWindow.get(1));
		WebElement selElement = driver.findElement(By.xpath("//div/select[@class='css-2t5nwu']"));
		Select shampooML = new Select(selElement);
		shampooML.selectByVisibleText("180ml");
		
		//Print the MRP of the product
		WebElement mrpElement = driver.findElement(By.xpath("//div[@class='css-f5j3vf']"));
		//WebElement mrpElement = driver.findElement(By.xpath("(//div[@class='css-1d0jf8e'])[1]"));
		String mrpText = mrpElement.getText();
		System.out.println(mrpText);
		
		//Click on ADD to BAG
		driver.findElement(By.xpath("//div[@class='css-vp18r8']")).click();
		
		//Go to Shopping Bag 
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();	
		
		//Print the Grand Total amount
		//driver.switchTo().frame(0);
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(frame);
		WebElement totalElement = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']"));
		String grandTotalText = totalElement.getText();
		System.out.println("Grand Total is:  "+grandTotalText);
		
		//Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		//Click on Continue as Guest
		driver.findElement(By.xpath("//div/button[text()='Continue as guest']")).click();
		driver.findElement(By.xpath("//span[@class='css-175whwo ehes2bo0']/img")).click();
		
		//Check if this grand total is the same in step 14
		WebElement priceDetElement = driver.findElement(By.xpath("(//div[@class='leftSelector css-1xck50t e87w9871'])[2]/p"));
		String priceText = priceDetElement.getText();
		if (grandTotalText == priceText) {
			System.out.println("Grand Total is same");
		}
		else {
			System.out.println("Grand Total is not same");
		}
		
		//Close all windows
		driver.quit();
	
	
	}
	

}
