package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

public class Login extends BaseTest {

    @Test
    void successfulLogin() {

        HomePage homePage = new HomePage(page);
        LoginPage loginPage = new LoginPage(page);

        homePage.clickLogin();

        loginPage.login(
                "john1786516018919@test.com",
                "Password123!"
        );

        Assertions.assertTrue(
                page.locator("a[href='/logout']").isVisible()
        );
    }
}
