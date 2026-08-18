package baseTest;

import com.microsoft.playwright.*;
import config.ConfigManager;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ScreenshotUtils;

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
                        .setHeadless(
                                Boolean.parseBoolean(
                                        ConfigManager.get("headless")
                                )
                        )
        );

        context = browser.newContext();

        page = context.newPage();

        page.navigate(
                ConfigManager.get("baseUrl")
        );
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (!result.isSuccess()) {
            ScreenshotUtils.takeScreenshot(page);
        }

        context.close();
        browser.close();
        playwright.close();
    }
}