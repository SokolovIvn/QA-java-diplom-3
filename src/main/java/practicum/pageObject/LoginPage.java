package practicum.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By registerLink = By.xpath("//a[text() = 'Зарегистрироваться']");
    private final By passwordRecoveryLink = By.xpath("//a[text() = 'Восстановить пароль']");
    private final By passwordInputField = By.xpath("//input[@type = 'password']");
    private final By emailInputField = By.xpath("//input[@name = 'name']");
    private final By loginFormButton = By.xpath("//button[text() = 'Войти']");
    private final By loginFormHeader = By.xpath("//h2[text() = 'Вход']");

    @Step
    public RegistrationPage clickRegisterLink() {
        WebElement element = driver.findElement(registerLink);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new RegistrationPage(driver);
    }

    @Step
    public void checkLoginPageFormHeader() {
        var isDisplayed = driver.findElement(loginFormHeader).isDisplayed();
        assertTrue("Не найден заголовок формы логина", isDisplayed);
    }

    @Step
    public LoginPage inputEmail(String email) {
        driver.findElement(emailInputField).sendKeys(email);
        return this;
    }

    @Step
    public MainPage clickLoginFormButton() {
        WebElement element = driver.findElement(loginFormButton);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new MainPage(driver);
    }

    @Step
    public PasswordRecoveryPage clickPasswordRecoveryLink() {
        WebElement element = driver.findElement(passwordRecoveryLink);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new PasswordRecoveryPage(driver);
    }

    @Step
    public LoginPage inputPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
        return this;
    }

}
