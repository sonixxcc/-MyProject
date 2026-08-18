package tests;
import baseTest.BaseTest;
import data.TestDataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;

public class InvalidLogin extends BaseTest {

    @Test
            (dataProvider = "invalidLoginData",
            dataProviderClass = TestDataProvider.class)
    public void invalidLogin(String email, String password) {

        HomePage homePage = new HomePage(page);
        LoginPage loginPage = new LoginPage(page);

        homePage.clickLogin();

        loginPage.login(email, password);

        assertTrue(
                page.locator(".message-error").isVisible()
        );
    }
}