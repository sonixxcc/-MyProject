package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

public class InvalidLogin extends BaseTest {

    @Test
    void invalidLogin() {

        HomePage homePage = new HomePage(page);
        LoginPage loginPage = new LoginPage(page);

        homePage.clickLogin();

        loginPage.login(
                "idk@gmail.com",
                "ewfewfewf"
        );

        Assertions.assertTrue(
                page.locator(".message-error").isVisible()
        );
    }
}
