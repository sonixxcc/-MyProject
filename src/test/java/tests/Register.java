package tests;

import baseTest.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.RegisterPage;

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

        Assertions.assertTrue(
                page.locator(".result").isVisible()
        );
    }
}