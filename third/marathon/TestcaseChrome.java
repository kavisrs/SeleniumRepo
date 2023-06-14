package third.marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestcaseChrome extends BaseClass{
	@BeforeTest
	public void sendValue() {
		ExcelFileName = "SalesforceContentChrome";

	}

	@Test(dataProvider = "sendData")
	public void chromeTest(String question, String detail) throws InterruptedException {

		//Type Content on the Search box
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Content");

		//Click the Content Link
		driver.findElement(By.xpath("//div/a/lightning-formatted-rich-text/span/p")).click();

		//Click on Chatter Tab
		WebElement chatterElement = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();", chatterElement);

		//Verify the Chatter title on the page
		String chatterTitle = driver.getTitle();
		System.out.println(chatterTitle);
		//		if (chatterTitle.contains("Chatter")) {
		//			System.out.println("Title has Chatter");
		//		}
		//		else {
		//			System.out.println("Title has no chatter");
		//		}

		//Click the Question tab
		driver.findElement(By.xpath("//span[text()='Question']")).click();

		// Type a Question with data (coming from Excel)
		driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(question);

		//Type Details with data (coming from Excel)
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(detail);

		//Click Ask
		driver.findElement(By.xpath("//button[text()='Ask']")).click();

		//Confirm the question appears
		WebElement verifyQuestion = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]"));
		if (verifyQuestion.isDisplayed()) {
			System.out.println("Yes, question displayed");

		}
		else {
			System.out.println("No questions displayed");

		}
	}

}
