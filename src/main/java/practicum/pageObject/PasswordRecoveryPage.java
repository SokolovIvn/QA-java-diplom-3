package practicum.pageObject;



import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordRecoveryPage {
    WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By loginLink = By.xpath("//a[text() = 'Войти']");

    @Step
    public LoginPage clickLoginLink(){
        WebElement element = driver.findElement(loginLink);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return new LoginPage(driver);
    }

}