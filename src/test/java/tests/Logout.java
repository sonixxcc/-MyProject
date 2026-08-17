package tests;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;

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

        assertTrue(
                page.locator("a[href='/login']").isVisible()
        );
    }
}