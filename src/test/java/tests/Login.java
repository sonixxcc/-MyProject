package tests;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;

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

        assertTrue(
                page.locator("a[href='/logout']").isVisible()
        );
    }
}
