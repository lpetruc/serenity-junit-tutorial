package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;


public class InventoryPage extends PageObject {

    public String getHeading() {
        return $(".title").getText();
    }

    public List<String> getProductTitles() {
        //return findAll(By.className("inventory_item_name")).textContents();
        return findAll(".inventory_item_name").textContents();
    }
}
