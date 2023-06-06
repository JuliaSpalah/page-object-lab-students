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
        JavascriptExecutor executor = mainPage.getJavaScriptExecutor();

        // Відкриває веб сторінку
        mainPage.openMainPage();
        try {
            // brandsElement це кнопка Brands
            brandsElement = driver.findElement(By.xpath("//a[text()='Brands']"));
        } catch (NoSuchElementException e) {
            fail("There was no 'Brands' link found on page");
            return;
        }
        // екзекьютор виконує js code. Скролиться до brandsElement.
        // Міняти треба тільки його, якщо що, а решта - сталий код (не чіпати).
        executor.executeScript("arguments[0].scrollIntoView(true);", brandsElement);
        // Почекати секунду
        TimeUnit.SECONDS.sleep(1);
        try {
            // Спроба клікнути по елементу
            brandsElement.click();
        } catch (ElementClickInterceptedException e) {
            // Якщо не вдалось клікнути, то відповідний месседж
            fail("Can't click on 'Brands' element");
            return;
        }
        // Alternatively, doesn't simulate the user click properly. May work even if element was blocked.
        // Альтернативний варіант. Не імітує клацання користувача належним чином. Може працювати, навіть якщо елемент був заблокований.
        // executor.executeScript("arguments[0].click();", brandsElement);

        try {
            // На наступній сторінці шукаємо елемент з ID Content
            contentElement = driver.findElement(By.xpath("//*[@id='content']"));
        } catch (NoSuchElementException e) {
            fail("There was no element with id='content' found on page");
            return;
        }
//************************************************************************************
        List<WebElement> brandElements = contentElement.findElements(By.xpath(
                "//a[text()='Apple' or text()='Canon' or text()='Hewlett-Packard' or text()='HTC' or text()='Palm' or text()='Sony']"));
        assertEquals(6, brandElements.size(), "The number of brand elements must be 6");

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
    @Test
    public void testClickOnMyAccount() {
        WebDriver driver = mainPage.getDriver();
        JavascriptExecutor executor = mainPage.getJavaScriptExecutor();

        mainPage.openMainPage();

        try {
            // в try одразу спроба для двох дій. Спочатку знайти елемент, а потім спробувати клікнути
            WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
            myAccount.click();
        } catch (NoSuchElementException e) {
            fail("There was no 'My Account' button found on page");
            return;
        } catch (ElementClickInterceptedException e) {
            // Якщо не вдалось клікнути, то відповідний месседж
            fail("Can't click on 'My Account' element");
            return;
        }

        try {
            WebElement register = driver.findElement(By.xpath("//a[@class='dropdown-item' and text()='Register']"));
            register.click();
        } catch (NoSuchElementException e) {
            fail("There was no 'Register' button found on page");
            return;
        } catch (ElementClickInterceptedException e) {
            // Якщо не вдалось клікнути, то відповідний месседж
            fail("Can't click on 'Register' element");
            return;
        }

        try {
            WebElement firstNameField = driver.findElement(By.id("input-firstname"));
            firstNameField.sendKeys("John");
        } catch (NoSuchElementException e) {
            fail("There was no 'First name' field found on page");
            return;
        }
        try {
            WebElement lastNameField = driver.findElement(By.id("input-lastname"));
            lastNameField.sendKeys("Snow");
        } catch (NoSuchElementException e) {
            fail("There was no 'Last name' field found on page");
            return;
        }
        try {
            WebElement eMail = driver.findElement(By.id("input-email"));
            eMail.sendKeys("john.snow@mail.com");
        } catch (NoSuchElementException e) {
            fail("There was no 'E-mail' field found on page");
            return;
        }
        try {
            WebElement eMail = driver.findElement(By.id("input-password"));
            eMail.sendKeys("K0zadereza#123");
        } catch (NoSuchElementException e) {
            fail("There was no 'Password' field found on page");
            return;
        }

        try {
            WebElement agreeCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));
            executor.executeScript("arguments[0].scrollIntoView(true);", agreeCheckbox);
            TimeUnit.SECONDS.sleep(1);
            agreeCheckbox.click();
        } catch (NoSuchElementException e) {
            fail("There was no 'Agree' checkbox found on page");
            return;
        } catch (ElementClickInterceptedException e) {
            // Якщо не вдалось клікнути, то відповідний месседж
            fail("Can't click on 'Agree' checkbox element");
            return;
        } catch (InterruptedException e) {
            fail("The waiting for 1 second was interrupted");
            return;
        }
        try {
            WebElement continueButton = driver.findElement(By.xpath("//button[text()='Continue']"));
            continueButton.click();
        } catch (NoSuchElementException e) {
            fail("There was no 'Continue' button found on page");
            return;
        } catch (ElementClickInterceptedException e) {
            // Якщо не вдалось клікнути, то відповідний месседж
            fail("Can't click on 'Continue' button element");
            return;
        }

        try {
            driver.findElement(By.xpath("//title[text()='Welcome']"));
        } catch (NoSuchElementException e) {
            fail("There was no 'Welcome' title found on page");
            return;
        }
    }
}
