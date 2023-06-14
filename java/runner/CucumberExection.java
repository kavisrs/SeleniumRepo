package runner;

import io.cucumber.testng.CucumberOptions;
import steps.BaseClassForCucumber;

@CucumberOptions(features="src/test/java/features",
				glue="steps",
				monochrome=true,
				publish=true,
				tags="@Sanity")
public class CucumberExection extends BaseClassForCucumber {
	
}
