package tests;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class Search extends BaseTest {

    @Test
    public void searchProduct() {

        HomePage homePage = new HomePage(page);

        homePage.searchProduct("computer");

        assertTrue(
                page.locator(".product-item").isVisible()
        );
    }
}