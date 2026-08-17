package tests;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import static org.testng.Assert.assertTrue;

public class Register extends BaseTest {

    @Test
    void successfulRegistration() {

        HomePage homePage = new HomePage(page);
        RegisterPage registerPage = new RegisterPage(page);

        homePage.clickRegister();

        registerPage.selectGender();
        registerPage.enterFirstName("John");
        registerPage.enterLastName("Smith");
        registerPage.enterEmail(
                "john" + System.currentTimeMillis() + "@test.com"
        );
        registerPage.enterPassword("Password123!");
        registerPage.enterConfirmPassword("Password123!");
        registerPage.clickRegister();

        assertTrue(
                page.locator(".result").isVisible()
        );
    }
}