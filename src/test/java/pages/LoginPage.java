package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void enterEmail(String email) {
        page.locator("#Email").fill(email);
    }

    public void enterPassword(String password) {
        page.locator("#Password").fill(password);
    }

    public void clickLogin() {
        page.locator("input[value='Log in']").click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}