package practicum.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

import static org.junit.Assert.assertTrue;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginRegisterPageLink = By.xpath("//a[text() = 'Войти']");
    private final By registerButton = By.xpath("//button[text() = 'Зарегистрироваться']");
    private final By emailInputField = By.xpath("//fieldset[2]/div/div/input");
    private final By passwordInputField = By.xpath("//input[@type = 'password']");
    private final By invalidPasswordMessage = By.xpath("//p[text() = 'Некорректный пароль']");
    private final By nameInputField = By.xpath("//fieldset[1]/div/div/input");

    @Step
    public RegistrationPage inputName(String name){
        driver.findElement(nameInputField).sendKeys(name);
        return this;
    }

    @Step
    public RegistrationPage inputEmail(String email){
        driver.findElement(emailInputField).sendKeys(email);
        return this;
    }

    @Step
    public RegistrationPage inputPassword(String password){
        driver.findElement(passwordInputField).sendKeys(password);
        return this;
    }

    @Step
    public LoginPage clickRegisterButtonValid(){
        WebElement element = driver.findElement(registerButton);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new LoginPage(driver);
    }

    @Step
    public RegistrationPage clickRegisterButtonInvalid(){
        WebElement element = driver.findElement(registerButton);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return this;
    }

    @Step
    public void checkInvalidPasswordMessage(){
        var isDisplayed = driver.findElement(invalidPasswordMessage).isDisplayed();
        assertTrue("Не найдено сообщение об ошибке",isDisplayed);
    }

    @Step
    public LoginPage clickLoginRegisterPageLink(){
        WebElement element = driver.findElement(loginRegisterPageLink);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new LoginPage(driver);
    }

}