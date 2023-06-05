package project.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import project.pages.MainPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class BaseTest {

    MainPage mainPage = new MainPage();

    @Before
    public void setUp() {
        //creating new instance of wed driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //set driver into base page
        mainPage.setDriver(driver);
        //get driver from base page and maximize window
        mainPage.getDriver().manage().window().maximize();
    }

    @After
    public void closeDriver() {
        //get driver from base page and quite it
        mainPage.getDriver().quit();
    }

    @Test
    public void testClickOnBrands() throws InterruptedException {
        WebElement brandsElement;
        WebElement contentElement;
        WebDriver driver = mainPage.getDriver();
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        mainPage.openMainPage();
        try {
            brandsElement = driver.findElement(By.xpath("//a[text()='Brands']"));
        } catch (NoSuchElementException e) {
            fail("There was no 'Brands' link found on page");
            return;
        }
        executor.executeScript("arguments[0].scrollIntoView(false);", brandsElement);
        TimeUnit.SECONDS.sleep(1);
        brandsElement.click();
        // Alternatively, doesn't simulate the user click properly. May work even if element was blocked.
        // Альтернативний варіант. Не імітує клацання користувача належним чином. Може працювати, навіть якщо елемент був заблокований.
        // executor.executeScript("arguments[0].click();", brandsElement);

        try {
            contentElement = driver.findElement(By.xpath("//*[@id='content']"));
        } catch (NoSuchElementException e) {
            fail("There was no element with id='content' found on page");
            return;
        }

//        List<WebElement> brandElements = contentElement.findElements(By.xpath(
//                "//a[text()='Apple' or text()='Canon' or text()='Hewlett-Packard' or text()='HTC' or text()='Palm' or text()='Sony']"));
//        assertEquals("The number of brand elements must be 6", 6, brandElements.size());

        String[] xpathes = {
                "//a[text()='Apple']",
                "//a[text()='Canon']",
                "//a[text()='Hewlett-Packard']",
                "//a[text()='HTC']",
                "//a[text()='Palm']",
                "//a[text()='Sony']",
        };
        for (String xpath : xpathes) {
            List<WebElement> elements = contentElement.findElements(By.xpath(xpath));
            assertNotEquals(elements.size(), 0, "Element with xpath='" + xpath + " was not found in brands elements");
            assertFalse(elements.size() > 1, "Element with xpath='" + xpath + " is duplicated in brands elements");
        }
    }
}
