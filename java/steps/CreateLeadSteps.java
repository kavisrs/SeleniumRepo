package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadSteps extends BaseClassForCucumber {
	
	@When("Click on CRM-SFA")
	public void clickOnCrmSfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@And("Click on Leads")
	public void clickOnLeads() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@And("Click on CreateLead button")
	public void createLeadButton() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@Given("Enter Firstname as (.*)$")
	public void firstName(String firstName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(firstName);
	}

	@And("Enter LastName as (.*)$")
	public void lastName(String lastName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(lastName);

	}

	@And("Enter CompanyName as (.*)$")
	public void companyName(String cName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(cName);
	}

	@And("Enter PhoneNumber as (.*)$")
	public void phoneNumber(String phoneNumber ) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNumber);
	}
	@When("Click on Submit Button")
	public void submitButton() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Verify Lead creted")
	public void verifyLeadCreated() {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(text);
		if (text.contains("Testleaf")) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
		}

	}

}
