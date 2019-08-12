package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "img.retina.logo-digital-pulse")
    public WebElement loadCheck;

    @FindBy(how = How.CSS, using = "a.flex-next")
    public WebElement nextCarousel;

    @FindBy(how = How.CSS, using = "a.flex-prev")
    public WebElement previousCarousel;

    @FindBys({@FindBy(how = How.CSS, using = "li.flex.flex-active-slide div.card")})
    public List<WebElement> productCardsList;

    @FindBys({@FindBy(how = How.CSS, using = "li.flex.flex-active-slide div.card h2")})
    public List<WebElement> productCardsTextList;

    @FindBy(how = How.CSS, using = "i.btr.bt-bars.trigger")
    public WebElement hamburgerMenu;

    @FindBy(how = How.CSS, using = "div.menu-holder li a[href*='contact-us']")
    public WebElement contactUsMenu;

    @FindBy(how = How.CSS, using = "i.btr.bt-search")
    public WebElement searchIcon;

    @FindBy(how = How.CSS, using = "input.search-field")
    public WebElement searchTextField;
}

