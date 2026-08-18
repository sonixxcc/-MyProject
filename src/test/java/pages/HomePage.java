package pages;

import pages.BasePage;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public void clickLogin() {
        page.locator("a[href='/login']").click();
    }

    public void clickRegister() {
        page.locator("a[href='/register']").click();
    }

    public void searchProduct(String product) {
        page.locator("#small-searchterms").fill(product);
        page.locator("input[value='Search']").click();
    }

    public void clickLogout() {
        page.locator("a[href='/logout']").click();
    }
}