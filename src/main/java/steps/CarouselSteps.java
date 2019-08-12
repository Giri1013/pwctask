package steps;

import helpers.ClassHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CarouselSteps extends BaseSteps{

    private Runcontext runContext;
    public CarouselSteps(Runcontext runContext){
        super(runContext);
        this.runContext = runContext;
    }
    @Given("I navigate to the PwC Digital Pulse website")
    public void i_navigate_to_the_PwC_Digital_Pulse_website() {
        runContext.webDriver.get("https://www.digitalpulse.pwc.com.au/");
    }

//    @When("I am viewing the \"([^\"]*)\" page")
//    public void i_am_viewing_the_page(String pageName) throws Exception {
//        // Reflections can be used to handle page load checks without if conditions.
//        if(pageName.contains("Home"))
//        {
//            HomePage homePage = new HomePage(runContext.webDriver);
//            if(homePage.loadCheck.isDisplayed())
//                runContext.scenario.write("Load Check of "+pageName+" performed successfully");
//            else
//            {
//                runContext.scenario.write("Failed load check of "+pageName);
//                throw new Exception("Failed Load check");
//            }
//        }
//    }

    @When("I am viewing the \"([^\"]*)\" page")
    public void i_am_viewing_the_page_generic(String pageName) throws Exception {
        // Reflections can be used to handle page load checks without if conditions.
        Object  obj= ClassHelper.getPageObject(runContext.webDriver,pageName);
        Field field = obj.getClass().getField("loadCheck");
        WebElement loadCheck = (WebElement) field.get(obj);
            if(loadCheck.isDisplayed())
                runContext.scenario.write("Load Check of "+pageName+" performed successfully");
            else
            {
                runContext.scenario.write("Failed load check of "+pageName);
                throw new Exception("Failed Load check");
            }

    }
    @Then("I am presented with a carousel displaying \"([^\"]*)\" featured articles")
    public void i_am_presented_with_a_carousel_displaying_featured_articles(String numberArticles) throws Exception {
        HomePage homePage = new HomePage(runContext.webDriver);
        if(homePage.productCardsList.size() == Integer.parseInt(numberArticles)){
                runContext.scenario.write("Product Card List Count is as expected");

        }
        else
        {
            runContext.scenario.write("Failed : Card list count is not matching with  "+numberArticles);
            throw new Exception("Failed Load check");
        }
    }

    // Performs click on expected chevron and verify whether current set of cards text matched with any of the previously loaded ones
    @Then("Clicking the \"([^\"]*)\" button on the carousel will load the \"([^\"]*)\" \"([^\"]*)\" featured articles")
    public void clicking_the_button_on_the_carousel_will_load_the_next_featured_articles(String chevronToClick,String items,String count) throws Exception {
        HomePage homePage = new HomePage(runContext.webDriver);
        List<String> currentCardsText = new ArrayList<>();

        for(WebElement element:homePage.productCardsTextList){
            currentCardsText.add(element.getText());
        }
        if(chevronToClick.equalsIgnoreCase("next")){
            homePage.nextCarousel.click();
        }
        else
            homePage.previousCarousel.click();
        homePage = new HomePage(runContext.webDriver);

        if(homePage.productCardsList.size() == Integer.parseInt(count)){
            runContext.scenario.write("Product Card List Count is as expected");

        }
        else
        {
            runContext.scenario.write("Failed : Card list count is not matching with  "+count);
            throw new Exception("Failed Load check");
        }

        if(currentCardsText.size()>0){
            for(WebElement element:homePage.productCardsTextList) {
                for (String cardText : currentCardsText) {
                    if (cardText.equalsIgnoreCase(element.getText())){
                        throw new Exception("Exception while fetching carousel cards text on home page");
                    }
                    else{
                        System.out.println("Old Card Text = "+cardText);
                        System.out.println("New Card Text = "+element.getText());
                    }
                }
            }
        }
        else
            throw new Exception("Exception while fetching carousel cards text on home page");

    }

}
