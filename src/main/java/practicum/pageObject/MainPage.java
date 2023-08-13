package practicum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginMainPageButton = By.xpath("//button[text() = 'Войти в аккаунт']");
    private final By bunTab = By.xpath("//span[text() = 'Булки']");
    private final By ingredientsTab = By.xpath("//span[text() = 'Начинки']");
    private final By sauceTab = By.xpath("//span[text() = 'Соусы']");
    private final By activeSauceTab = By.xpath("//div[contains(@class, 'current')]/*[contains(text(),'Соусы')]");
    private final By activeBunTab = By.xpath("//div[contains(@class, 'current')]/*[contains(text(),'Булки')]");
    private final By activeTopingTab = By.xpath("//div[contains(@class, 'current')]/*[contains(text(),'Начинки')]");
    private final By personalAccountButton = By.xpath("//p[text() = 'Личный Кабинет']");
    private final By ingredientsTabParent = By.xpath("//span[text() = 'Начинки']/parent::div");
    private final By makeOrderButton = By.xpath("//button[text() = 'Оформить заказ']");

    @Step
    public AccountPage clickPersonalAccountButton() throws InterruptedException {
        WebElement element = driver.findElement(personalAccountButton);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1000);
        element.click();
        return new AccountPage(driver);
    }

    @Step
    public Header clickPersonalAccountButtonLogged() throws InterruptedException {
        WebElement element = driver.findElement(personalAccountButton);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1000);
        element.click();
        return new Header(driver);
    }

    @Step
    public LoginPage clickLoginMainPageButton() throws InterruptedException {
        WebElement element = driver.findElement(loginMainPageButton);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1500);
        element.click();
        return new LoginPage(driver);
    }

    @Step
    public void checkMakeOrderButton() {
        var isDisplayed = driver.findElement(makeOrderButton).isDisplayed();
        assertTrue("Не найдена кнопка заказа", isDisplayed);
    }

    @Step
    public MainPage clickBunTab() throws InterruptedException {
        WebElement element = driver.findElement(bunTab);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1000);
        element.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(activeBunTab));
        return new MainPage(driver);
    }

    @Step
    public MainPage clickSauceTab() throws InterruptedException {
        WebElement element = driver.findElement(sauceTab);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1000);
        element.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(activeSauceTab));
        return new MainPage(driver);
    }

    @Step
    public MainPage clickIngredientsTab() throws InterruptedException {
        WebElement element = driver.findElement(ingredientsTab);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1000);
        element.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(activeTopingTab));
        return new MainPage(driver);
    }

    @Step
    public void checkSauceTabActive() {
        assertEquals("Вкладка неактивна", 1, driver.findElements(activeSauceTab).size());
    }

    @Step
    public void checkBunTabActive() {
        assertEquals("Вкладка неактивна", 1, driver.findElements(activeBunTab).size());
    }

    @Step
    public void checkIngredientsTabActive() {
        WebElement element = driver.findElement(ingredientsTabParent);
        String expectedResult = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        var actualResult = element.getAttribute("class");
        assertEquals("Элемент не выбран", expectedResult, actualResult);
    }
}