package project.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    //protected WebDriver variable (only classes in same folder (pages) will get driver)
    protected WebDriver driver;

    //set driver for base page
    public void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    //method for get driver from any page
    public WebDriver getDriver() {
        return driver;
    }
    public JavascriptExecutor getJavaScriptExecutor() {
        return (JavascriptExecutor) driver;
    }

}
