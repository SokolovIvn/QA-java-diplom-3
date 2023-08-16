package practicum;


import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import practicum.pageObject.MainPage;

public class PersonalAccountTest extends BaseTest {
    @Before
    public void prepareData() throws InterruptedException {
        new MainPage(driver).clickLoginMainPageButton().inputEmail(email).inputPassword(password).clickLoginFormButton();

    }

    @Test
    @DisplayName("Проверить кнопку выход")
    public void checkPersonalAccount() throws InterruptedException {
        new MainPage(driver).clickPersonalAccountButton().checkLogoutButton();
    }

    @Test
    @DisplayName("Переход по кнопке контруктор")
    public void checkPersonalAccountToConstructorUsingConstructorButton() throws InterruptedException {
        new MainPage(driver).clickPersonalAccountButtonLogged().clickConstructorButton().checkMakeOrderButton();
    }

    @Test
    @DisplayName("Переход на главную по лого")
    public void checkPersonalAccountToConstructorUsingAppLogo() throws InterruptedException {
        new MainPage(driver).clickPersonalAccountButtonLogged().clickAppLogo().checkMakeOrderButton();
    }

    @Test
    @DisplayName("Разлогин из лк")
    public void checkPersonalAccountLogout() throws InterruptedException {
        new MainPage(driver).clickPersonalAccountButton().clickLogoutButton().checkLoginPageFormHeader();
    }
}
