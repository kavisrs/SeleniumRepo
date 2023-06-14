package week2.day1;

import org.openqa.selenium.edge.EdgeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.facebook.com/");
		//maximize window
		driver.manage().window().maximize();
		//close the window
		driver.close();
		
			
		

	}

}
