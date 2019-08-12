package steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Runcontext {
    public Scenario scenario;
    public WebDriver webDriver;

    @Before
    public void init(Scenario scenario)
    {
        String path = new File("src//main//java//drivers//chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", path);
        this.scenario = scenario;
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void tearUp(Scenario scenario)
    {
        webDriver.close();
        System.out.println("Tear up");
    }
}
