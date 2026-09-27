package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    
    // for warning and password manage after login 
    private By warningCloseButton =
            By.cssSelector("mat-dialog-actions button[mat-dialog-close]");
    
    
    private By activatedOnDateField =
            By.cssSelector("input[placeholder='Activated On Date']");

   
    private By activationCalendarButton =
            By.cssSelector("button[aria-label='Open calendar']");
    
    private By todayDate =
            By.cssSelector("mat-calendar button[aria-current='date']");
    
    private By confirmButton =
            By.xpath("//button[normalize-space()='Confirm']");
    
    
    public void clickActivationCalendar() {
        click(activationCalendarButton);
    }
    
    public void selectToday() {

        String todayDateValue = java.time.LocalDate.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("d MMMM yyyy"));

        By todayDate = By.cssSelector(
                "mat-calendar button[aria-label='" + todayDateValue + "']"
        );

        WebElement today = wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .elementToBeClickable(todayDate)
        );

        today.click();
        
        
    }
    public void clickConfirm() {
        click(confirmButton);
    }
    
    public void closeWarning() {
        click(warningCloseButton);
    }


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

        // Wait until client names are loaded
        waitForElementPresence(clientNames);

        List<WebElement> elements = findElements(clientNames);

        List<String> names = new ArrayList<>();

        for (int i = 0; i < Math.min(5, elements.size()); i++) {

            String name = elements.get(i).getText().trim();

            if (!name.isEmpty()) {
                names.add(name);
            }
        }

        return names;
    }
    public String getPendingClientName() {

        By clientRows = By.cssSelector("div.list-row");

        waitForElementPresence(clientRows);

        List<WebElement> rows = findElements(clientRows);

        for (WebElement row : rows) {

            String rowText = row.getText().trim();

            if (rowText.contains("PENDING")) {

                WebElement nameElement =
                        row.findElement(By.cssSelector("span.name"));

                return nameElement.getText().trim();
            }
        }

        throw new RuntimeException(
                "No PENDING client found on Clients page."
        );
    } 
    
    public boolean isClientActive(String clientName) {

        By clientRow = clientRow(clientName);

        WebElement row = wait.until(
            ExpectedConditions.visibilityOfElementLocated(clientRow)
        );

        String rowText = row.getText().trim();

        System.out.println("Activated Client Row: " + rowText);

        return rowText.contains("ACTIVE");
    }
    
}