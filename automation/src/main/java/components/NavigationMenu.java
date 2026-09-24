package components;

import org.openqa.selenium.By;

import base.BasePage;

public class NavigationMenu extends BasePage {

    private By institutionMenu =
            By.xpath("//a[@class='mat-mdc-menu-trigger tab-link ng-star-inserted']");

    private By clientsMenu =
            By.xpath("//span[contains(text(), 'Clients')]");


    public void clickInstitution() {
        click(institutionMenu);
    }

    public void clickClients() {
        click(clientsMenu);
    }
}