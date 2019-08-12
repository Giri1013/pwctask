package helpers;

import org.openqa.selenium.WebDriver;

public class ClassHelper {
    public static Object getPageObject(final WebDriver webdriver, String page) throws Exception {
        Object genericObject = null;
        try {
            page = StringUtils.getPascalCaseString(page+" Page");
            Class<?> c = Class.forName("pageobjects." + page);
            genericObject = c.getDeclaredConstructor(WebDriver.class).newInstance(webdriver);
        } catch (Exception e) {
            throw new Exception("Exception in getting instance of class ");
        }
        return genericObject;
    }
}
