package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {
    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "section.container.intro div.inner")
    public WebElement loadCheck;

    @FindBys({@FindBy(how = How.CSS, using = "section.container.content div.row.inner div.post")})
    public List<WebElement> searchResultsList;
}
