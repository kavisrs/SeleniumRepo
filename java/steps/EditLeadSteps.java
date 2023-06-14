package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLeadSteps extends BaseClassForCucumber {

	@And("Click on FindLeads")
	public void clickOnFindLeads() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@And("Click on Phone")
	public void clickOnPhone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@Given("Enter PhoneNumber for finding lead as (.*)$")
	public void pNumber(String pNum) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pNum);
	}

	@When("Click on FindLeads button")
	public void clickonFindLeads() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}

	@And("Click on first displayed Lead")
	public void clickOnFirstDisplayedLead() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@And("Click on Edit button")
	public void clickOnEditButton() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@Given("Update CompanyName as (.*)$")
	public void updateCompanyName(String companyName) {
		WebElement compName = driver.findElement(By.id("updateLeadForm_companyName"));
		compName.clear();
		compName.sendKeys(companyName);
	}

	@When("Click on Submit Button in EditLead screen")
	public void submitInEditLeadScreen() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Verify Lead updated as (.*)$")
	public void verifyLeadUpdated(String companyName) {	
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains(companyName)) {
			System.out.println("Lead is editted successfully");
		}
		else {
			System.out.println("Lead is not editted"); 
		}
	}

	
}
