package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

public class Logout extends BaseTest {

    @Test
    void logout() {

        HomePage homePage = new HomePage(page);
        LoginPage loginPage = new LoginPage(page);

        homePage.clickLogin();

        loginPage.login(
                "john1786516018919@test.com",
                "Password123!"
        );

        homePage.clickLogout();

        Assertions.assertTrue(
                page.locator("a[href='/login']").isVisible()
        );
    }
}