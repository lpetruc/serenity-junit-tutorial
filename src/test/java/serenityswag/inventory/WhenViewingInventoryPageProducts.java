package serenityswag.inventory;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.User;
import serenityswag.authentication.actions.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenViewingInventoryPageProducts {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    InventoryPage inventoryPage;

    @Test
    public void shouldSeeProductList() {
        login.as(User.STANDARD_USER);

        List<String> titles = inventoryPage.getProductTitles();
        assertThat(titles).hasSize(6).contains("Sauce Labs Bolt T-Shirt");
    }

}
