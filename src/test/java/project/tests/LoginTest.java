package project.tests;

import org.junit.Test;
import project.pages.MainPage;

public class LoginTest extends BaseTest {

    private MainPage mainPage;

    @Test
    public void registrationWithValidCredentials() {
        mainPage = new MainPage();
        mainPage.openMainPage();
    }

}
