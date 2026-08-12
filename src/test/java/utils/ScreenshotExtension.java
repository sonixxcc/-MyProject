package utils;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.nio.file.Paths;

public class ScreenshotExtension implements TestWatcher {

    private Page page;

    public ScreenshotExtension(Page page) {
        this.page = page;
    }

    @Override
    public void testFailed(
            ExtensionContext context,
            Throwable cause
    ) {

        page.screenshot(
                new Page.ScreenshotOptions()
                        .setPath(Paths.get(
                                "screenshots/" +
                                        context.getDisplayName() +
                                        ".png"
                        ))
                        .setFullPage(true)
        );
    }
}