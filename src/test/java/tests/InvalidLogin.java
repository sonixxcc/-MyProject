package tests;
import baseTest.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;

public class InvalidLogin extends BaseTest {

    @Test
    public void invalidLogin() {

        HomePage homePage = new HomePage(page);
        LoginPage loginPage = new LoginPage(page);

        homePage.clickLogin();

        loginPage.login(
                "idk@gmail.com",
                "ewfewfewf"
        );

        assertTrue(
                page.locator(".message-error").isVisible()
        );
    }
}