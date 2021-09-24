package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import serenityswag.authentication.User;
import serenityswag.authentication.ui.LoginForm;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as a standard user")
    public void asAStandardUser() {
        openUrl("https://saucedemo.com");

        // Login as a standard user
        $("[data-test='username']").sendKeys("standard_user");
        $("[data-test='password']").sendKeys("secret_sauce");
        $("[data-test='login-button']").click();
    }

    @Step("Log in as {0}")
    public void withCredentials(String username, String password) {
        openUrl("https://saucedemo.com");

        // Login as a standard user
        $("[data-test='username']").sendKeys(username);
        $("[data-test='password']").sendKeys(password);
        $("[data-test='login-button']").click();
    }

    @Step("Log in as {0}")
    public void as(User user) {
        openUrl("https://www.saucedemo.com");

        // Login as a user
        // Selector By ID
        //find(By.id("user-name")).sendKeys(user.getUsername());
        $(LoginForm.USER_NAME).sendKeys(user.getUsername());
        $(LoginForm.PASSWORD).sendKeys(user.getPassword());
        $(LoginForm.LOGIN_BUTTON).click();
    }
}
