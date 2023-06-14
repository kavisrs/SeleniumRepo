package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClassForCucumber {
	
	

//	@Given("Open the browser")
//	public void openBrowser() {
//		driver = new ChromeDriver();
//	}
//
//	@And("Load the URL as {string}")
//	public void enterURL(String url) {
//		driver.get(url);
//	}

	@Given("Enter the username as {string}")
	public void enterUsername(String uName) {
		driver.findElement(By.id("username")).sendKeys(uName);
	}

	@And("Enter the password as {string}")
	public void enterPassword(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("Click on Login button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("Verify logon successful")
	public void verifyHomePage() {
		String title = driver.getTitle();
		//System.out.println(title);
		if (title.contains("Leaftaps")) {
			System.out.println("Login Succesful");
		}
		else {
			System.out.println("Logon Denied");
		}
	}

	@But("Logon Denied")
	public void verifyErrorMessage() {
		WebElement element = driver.findElement(By.xpath("//div/div/p[text()='The Following Errors Occurred:']"));
		String text = element.getText();
		if (text.contains("Errors")) {
			System.out.println("Logon Denied");
			System.out.println("Incorrect Username / Password");
		}
		else {
			System.out.println("Login Successful");
		}
	}

}
