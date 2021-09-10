package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

public class InventoryDetailPage extends PageObject {

    public String getTitle() {
        return $(".inventory_details_name").getText();
    }

    public WebElementState productImageWithAltVaueOf(String title) {
        return find(By.cssSelector(".inventory_details_container img[alt='" + title + "']"));
    }
}
