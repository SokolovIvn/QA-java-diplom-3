package practicum;


import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import practicum.pageObject.Header;
import practicum.pageObject.MainPage;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Авторизоваться с главной. Про верить кнопку Заказ")
    public void checkLoginFromMainPage() throws InterruptedException {

        new MainPage(driver)
                .clickLoginMainPageButton()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginFormButton()
                .checkMakeOrderButton();
    }

    @Test
    @DisplayName("Авторизоваться из ЛК. Проверить кнопку оформить заказ в ЛК")
    public void checkLoginFromPersonalAccount() throws InterruptedException {
        new Header(driver)
                .clickPersonalAccountButton()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginFormButton()
                .checkMakeOrderButton();
    }

    @Test
    @DisplayName("Авторизоваться со страницы регистрации. Проверить кнопку заказ")
    public void checkLoginFromRegistrationPage() throws InterruptedException {
        new Header(driver)
                .clickPersonalAccountButton()
                .clickRegisterLink()
                .clickLoginRegisterPageLink()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginFormButton()
                .checkMakeOrderButton();
    }

    @Test
    @DisplayName("Авторизоваться со страницы восстановления заказа. Проверить кнопку заказ")
    public void checkLoginFromPasswordRecoveryPage() throws InterruptedException {
        new Header(driver)
                .clickPersonalAccountButton()
                .clickPasswordRecoveryLink()
                .clickLoginLink()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginFormButton()
                .checkMakeOrderButton();
    }
}