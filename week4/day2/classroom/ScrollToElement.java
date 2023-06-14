//Classroom:
//Load (https://www.ajio.com/)
//Scroll till the last element of that webpage
//Take Snapshot and confirm



package week4.day2.classroom;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class ScrollToElement {

	public static void main(String[] args) throws IOException {
		EdgeOptions option = new EdgeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement element = driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[3]/footer/div[2]/div/div[1]/section[3]/div[2]/a[9]"));
		
		Actions builder = new Actions(driver);
		builder.scrollToElement(element).perform();
		String text = element.getText();
		System.out.println(text);
				
		//print the page
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/collections.png");
		FileUtils.copyFile(source, destination); 
		
		driver.quit();
		
		

}

}
