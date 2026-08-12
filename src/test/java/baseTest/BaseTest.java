package baseTest;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    private boolean testFailed = false;

    @BeforeEach
    void setUp() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        context = browser.newContext();
        page = context.newPage();

        page.navigate("https://demowebshop.tricentis.com");
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {

        if (testFailed && page != null) {

            try {
                Path directory = Paths.get("screenshots");

                Files.createDirectories(directory);

                page.screenshot(
                        new Page.ScreenshotOptions()
                                .setPath(
                                        directory.resolve(
                                                testInfo.getDisplayName() + ".png"
                                        )
                                )
                                .setFullPage(true)
                );

            } catch (Exception e) {
                System.out.println(
                        "Could not save screenshot: " + e.getMessage()
                );
            }
        }

        if (context != null) {
            context.close();
        }

        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }

    protected void markTestAsFailed() {
        testFailed = true;
    }
}