package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.ContactUsPage;
import pageobjects.HomePage;

import java.util.List;

public class GeneralSteps extends BaseSteps{

    private Runcontext runContext;
    public GeneralSteps(Runcontext runContext){
        super(runContext);
        this.runContext = runContext;
    }
    @When("I select \"([^\"]*)\" from the hamburger menu")
    public void i_select_from_the_hamburger_menu(String clickItem) {
        HomePage homePage = new HomePage(runContext.webDriver);
        homePage.hamburgerMenu.click();
        new WebDriverWait(runContext.webDriver,5000).until(ExpectedConditions.visibilityOf(homePage.contactUsMenu));
        homePage.contactUsMenu.click();
    }

    @When("I am taken to the \"([^\"]*)\" page")
    public void i_am_taken(String page) {
        HomePage homePage = new HomePage(runContext.webDriver);


    }

    @Then("I am presented with the below options for contacts")
    public void i_am_presented_with_the_below_options_for_contacts(DataTable contactOptions) {
        ContactUsPage contactUsPage = new ContactUsPage(runContext.webDriver);
        List<List<String>> contactLinks =  contactOptions.asLists();
            for(int count=0;count<contactLinks.size();count++){
                WebElement currentElement = contactUsPage.contactCardsList.get(count);
                if(!contactLinks.get(count).get(0).isEmpty()){
                    if(currentElement.findElement(By.cssSelector("div h2")).getText().replace("\n"," ").equals(contactLinks.get(count).get(0))){
                       runContext.scenario.write("Passed: Card Content Matched");
                    }
                    else
                    {
                        runContext.scenario.write("Failed: Contact Us card text mismatch - of card"+count+1);
                    }
                }
                if(!contactLinks.get(count).get(1).isEmpty()){
                    if(currentElement.findElement(By.cssSelector("div a")).getAttribute("href") .equals(contactLinks.get(count).get(1))){
                        runContext.scenario.write("Passed: Card Link Matched");
                    }
                    else
                    {
                        runContext.scenario.write("Failed: Contact Us card link url mismatch - of card"+count+1);
                    }
                }
            }

    }
}
