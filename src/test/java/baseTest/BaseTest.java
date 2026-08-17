package baseTest;

import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setUp() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        context = browser.newContext();
        page = context.newPage();

        page.navigate("https://demowebshop.tricentis.com");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (!result.isSuccess()) {

            try {
                Path directory = Paths.get("screenshots");
                Files.createDirectories(directory);

                String fileName = result.getMethod().getMethodName()
                        + "_" + System.currentTimeMillis() + ".png";

                page.screenshot(
                        new Page.ScreenshotOptions()
                                .setPath(directory.resolve(fileName))
                                .setFullPage(true)
                );

            } catch (Exception e) {
                System.out.println("Screenshot error: " + e.getMessage());
            }
        }

        context.close();
        browser.close();
        playwright.close();
    }
}