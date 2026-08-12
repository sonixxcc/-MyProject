package tests;

import baseTest.BaseTest;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import java.nio.file.Paths;

public class Search extends BaseTest {

    @Test
    void searchProduct() {

        HomePage homePage = new HomePage(page);

        homePage.searchProduct("computer");

        page.screenshot(
                new Page.ScreenshotOptions()
                        .setPath(Paths.get("screenshots/search.png"))
                        .setFullPage(true)
        );

        Assertions.assertTrue(
                page.locator(".product-item").isVisible()
        );
    }
}