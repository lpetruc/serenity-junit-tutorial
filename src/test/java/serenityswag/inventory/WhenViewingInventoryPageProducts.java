package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.User;
import serenityswag.authentication.actions.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenViewingInventoryPageProducts {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;

    InventoryPage inventoryPage;
    InventoryDetailPage inventoryDetailPage;

    @Test
    public void shouldSeeProductList() {
        login.as(User.STANDARD_USER);

        List<String> titles = inventoryPage.getProductTitles();
        assertThat(titles).hasSize(6).contains("Sauce Labs Bolt T-Shirt");
    }

    @Test
    public void highilightedProductsShouldDisplayTheCorrespondngImages() {
        login.as(User.STANDARD_USER);

        List<String> productTitles = inventoryPage.getProductTitles();

        // if we do that, the first time the assertion fails, it will stop
        /*
        productTitles.forEach(
                productTitle -> assertThat(inventoryPage.imageAltTextForProduct(productTitle)).isEqualTo(productTitle)
        );
        */

        // if we do that, the check will be done for all the elements, and ALL THE ERRORS will be reported !
        SoftAssertions softly = new SoftAssertions();
        productTitles.forEach(
                productTitle -> softly.assertThat(inventoryPage.imageAltTextForProduct(productTitle)).isEqualTo(productTitle)
        );
        softly.assertAll();

    }

    @Test
    public void shouldSeeProductDetail() {
        login.as(User.STANDARD_USER);

        List<String> titles = inventoryPage.getProductTitles();

        // select the first element of the list
        String title = titles.get(0);
        inventoryPage.selectProduct(title);

        Serenity.reportThat("The detail page shows the correct title",
                () -> assertThat(inventoryDetailPage.getTitle()).isEqualTo(title));

        Serenity.reportThat("The product detail image with correct ALT should be visible",
                () -> assertThat(inventoryDetailPage.productImageWithAltVaueOf(title).isCurrentlyVisible()));
        }
}
