package practicum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class AccountPage {

    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By logoutButton = By.xpath(".//button[text() = 'Выход']");

    @Step
    public LoginPage clickLogoutButton() throws InterruptedException {
        WebElement element = driver.findElement(logoutButton);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1500);
        element.click();
        return new LoginPage(driver);
    }

    @Step
    public void checkLogoutButton() {
        var isDisplayed = driver.findElement(logoutButton).isDisplayed();
        assertTrue("Выхода из аккаунта", isDisplayed);
    }
}
