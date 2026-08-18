package utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtils {

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot(Page page) {

        return page.screenshot(
                new Page.ScreenshotOptions()
                        .setFullPage(true)
        );
    }
}