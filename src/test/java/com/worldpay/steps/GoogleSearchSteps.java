package com.worldpay.steps;

import com.worldpay.TestContext;
import com.worldpay.beans.ScenarioContext;
import com.worldpay.pages.GoogleSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.stream.Collectors;

@ContextConfiguration(classes = TestContext.class)
public class GoogleSearchSteps {
    @Autowired
    private WebDriver driver;

    @Autowired
    private GoogleSearchPage googleSearchPage;

    @Autowired
    private ScenarioContext scenarioContext;


    @Given("I am on Google Search Page")
    public void iAmOnGoogleSearchPage() {
        driver.get("https://www.google.ro/");

    }

    @When("I search after {string}")
    public void iSearchAfter(String keyword) {
        List<String> titles = googleSearchPage.searchAfterKeyword(keyword);
        scenarioContext.setNamedValue("results", titles);


    }

    @Then("I get this list of results:")
    public void iGetThisListOfResults(List<String> expectedResults) {

        List<String> actualResults = scenarioContext.getNamedValue("results", List.class);

        List<String> expectedNotInActual = expectedResults.stream().filter(r -> !actualResults.contains(r)).collect(Collectors.toList());

        Assert.assertTrue("Some results were not found "+ expectedNotInActual,expectedNotInActual.size()==0);

    }
}
