package pages;

import com.microsoft.playwright.Page;

public class RegisterPage {

    private Page page;

    public RegisterPage(Page page) {
        this.page = page;
    }

    public void selectGender() {
        page.locator("#gender-male").check();
    }

    public void enterFirstName(String firstName) {
        page.locator("#FirstName").fill(firstName);
    }

    public void enterLastName(String lastName) {
        page.locator("#LastName").fill(lastName);
    }

    public void enterEmail(String email) {
        page.locator("#Email").fill(email);
    }

    public void enterPassword(String password) {
        page.locator("#Password").fill(password);
    }

    public void enterConfirmPassword(String password) {
        page.locator("#ConfirmPassword").fill(password);
    }

    public void clickRegister() {
        page.locator("#register-button").click();
    }
}