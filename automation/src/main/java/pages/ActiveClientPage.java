package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import components.NavigationMenu;

public class ActiveClientPage extends BasePage {

    private NavigationMenu navigationMenu;

    public ActiveClientPage() {
        super();
        navigationMenu = new NavigationMenu();
    }

    // Clients page
    private By clientSearchField =
            By.cssSelector(
                "input[placeholder='Search by client name, external Id, mobile']");

    // Dynamic client row
    private By clientRow(String clientName) {
        return By.xpath(
            "//div[contains(@class,'list-row')]" +
            "[.//span[contains(@class,'name') and contains(normalize-space(),'" +
            clientName + "')]]"
        );
    }

    // Client profile hamburger menu
    private By actionsMenu =
            By.cssSelector("mat-icon.actions-menu");

    // Actions submenu
    private By actionsMenuItem =
            By.xpath(
                "//button[@mat-menu-item]" +
                "[.//span[contains(@class,'mat-mdc-menu-item-text')" +
                " and normalize-space()='Actions']]"
            );

    // Activate
    private By activateMenuItem =
            By.xpath(
                "//button[@mat-menu-item]" +
                "[.//span[contains(@class,'mat-mdc-menu-item-text')" +
                " and normalize-space()='Activate']]"
            );
    
    private By clientNames =
            By.cssSelector("div.list-row span.name");


    public void navigateToClients() {
        navigationMenu.clickInstitution();
        navigationMenu.clickClients();
    }

    public void searchClient(String clientName) {
        type(clientSearchField, clientName);
    }

    public void clickClient(String clientName) {
        click(clientRow(clientName));
    }

    public void clickActionsMenu() {
        click(actionsMenu);
    }

    public void clickActions() {
        click(actionsMenuItem);
    }

    public void clickActivate() {
        click(activateMenuItem);
    }
    
    public List<String> getRecentClientNames() {

        List<WebElement> elements = findElements(clientNames);

        List<String> names = new ArrayList<>();

        for (int i = 0; i < Math.min(5, elements.size()); i++) {
            names.add(elements.get(i).getText().trim());
        }

        return names;
    }
}