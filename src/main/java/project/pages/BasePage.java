package project.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

  //protected WebDriver variable (only classes in same folder (pages) will get driver)
  protected static WebDriver driver;

  //set driver for base page
  public static void setDriver(WebDriver webDriver) {
    driver = webDriver;
  }

  //method for get driver from any page
  public static WebDriver getDriver() {
    return driver;
  }

}
