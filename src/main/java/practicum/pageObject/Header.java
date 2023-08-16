package practicum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    private final By personalAccountButton = By.xpath("//p[text() = 'Личный Кабинет']");
    private final By constructorButton = By.xpath("//p[text() = 'Конструктор']");
    private final By appLogo = By.className("AppHeader_header__logo__2D0X2");

    @Step
    public LoginPage clickPersonalAccountButton() throws InterruptedException {
        WebElement element = driver.findElement(personalAccountButton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1000);
        element.click();
        return new LoginPage(driver);
    }

    @Step
    public MainPage clickConstructorButton() throws InterruptedException {
        WebElement element = driver.findElement(constructorButton);

        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1000);
        element.click();
        return new MainPage(driver);
    }

    @Step
    public MainPage clickAppLogo() throws InterruptedException {
        WebElement element = driver.findElement(appLogo);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        Thread.sleep(1000);
        element.click();
        return new MainPage(driver);
    }

}