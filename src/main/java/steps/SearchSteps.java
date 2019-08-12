package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pageobjects.HomePage;
import pageobjects.SearchResultsPage;

public class SearchSteps extends BaseSteps {

    private Runcontext runContext;

    public SearchSteps(Runcontext runContext) {
        super(runContext);
        this.runContext = runContext;
    }

    @When("I click on the \"([^\"]*)\" icon to perform a search")
    public void i_click_on_the_icon_to_perform_a_search(String iconName) {
        new HomePage(runContext.webDriver).searchIcon.click();
    }

    @When("I enter the text \"([^\"]*)\"")
    public void i_enter_the_text(String enterString) {
        new HomePage(runContext.webDriver).searchTextField.sendKeys(enterString);
    }

    @When("I submit the search")
    public void i_submit_the_search() {
        new HomePage(runContext.webDriver).searchTextField.sendKeys(Keys.ENTER);
    }

    @Then("I am taken to the search results page")
    public void i_am_taken_to_the_search_results_page() throws Exception {
        SearchResultsPage searchResultsPage = new SearchResultsPage(runContext.webDriver);
        if(searchResultsPage.loadCheck.isDisplayed())
            runContext.scenario.write("Load Check of SearchResults performed successfully");
        else
        {
            runContext.scenario.write("Failed load check of Search Results Page");
            throw new Exception("Failed Load check");
        }
    }

    @Then("I am presented with at least \"([^\"]*)\" search result")
    public void i_am_presented_with_at_least_search_result(String numberOfResults) throws Exception {
        if(new SearchResultsPage(runContext.webDriver).searchResultsList.size() > Integer.parseInt(numberOfResults))
            runContext.scenario.write("Passed : Search Results Page contains at least "+numberOfResults+" of results");
        else {
            runContext.scenario.write("Failed : Search Results Page doesn't contain  " + numberOfResults + " of results");
            throw new Exception("Failed Load check");
        }
    }


}
