//Assignment 3
//1.Load this url(https://www.irctc.co.in/nget/train-search)
// 2.Click Flights
//3.Get the title and print in the console



package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.edge.EdgeDriver;

public class IrctcSwitchToFlight {
	public static void main(String[] args) throws IOException {
		
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.linkText("FLIGHTS")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		List<String> lsthandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lsthandle.get(1));
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/flights.png");
		FileUtils.copyFile(source, destination);
		
		driver.quit();
		
		
		
	}

}
