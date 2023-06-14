package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DeleteLeadSteps extends BaseClassForCucumber{

	public String leadId;
	
	
	@And("Get leadID for first displayed Lead")
	public void getLeadIDforFirstDisplayedLead() {
		leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@And("Click on Delete button")
	public void clickOnDeleteButton() {
		driver.findElement(By.linkText("Delete")).click();
	}

	@Given("Enter leadID")
	public void enterLeadID() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
	}

	@Then("Verify Lead Deleted")
	public void verifyLeadDeleted() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Lead deleted successfully");
		} else {
			System.out.println("Lead is not deleted ");
		}

	}

	
	
}
