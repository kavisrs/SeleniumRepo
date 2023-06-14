package second.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) {
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		//Launch ServiceNow application
		driver.get("https://dev57553.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Login with valid credentials username as admin and password 
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("2oaD6KN$q$vN");
		driver.findElement(By.id("sysverb_login")).click();
		//Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[@id='all']").click();
		dom.findElementByXPath("//span[text()='Service Catalog']").click();
		
		//switch to frames
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		
		driver.switchTo().frame(frame);
		
		//Click on  mobiles
		driver.findElement(By.xpath("//div//a[text()='Mobiles']")).click();
		
		//Select Apple iphone6s
		driver.findElement(By.xpath("//strong[text()='iPhone 6s']")).click();
		
		//Update color field to gold and storage field to 128GB
		WebElement colorElement = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select color = new Select(colorElement);
		color.selectByVisibleText("gold");
		
		WebElement storageElement = driver.findElement(By.id("IO:32e0886e4f334200086eeed18110c738"));
		Select storage = new Select(storageElement);
		storage.selectByVisibleText("128");
		
		

	}

}
