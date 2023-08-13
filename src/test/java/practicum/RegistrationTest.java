package practicum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import practicum.pageObject.Header;
import practicum.user.User;
import practicum.user.UserGenerator;


public class RegistrationTest extends BaseTest {

    User user;
    Header header;

    @Before
    public void setUp() throws InterruptedException {
        user = new UserGenerator().makeUser();
        header = new Header(driver);
        header.clickPersonalAccountButton().clickRegisterLink().inputName(name).inputEmail(user.getEmail());
    }

    @Test
    @DisplayName("Зарегистрироваться через шапку")
    public void checkRegistrationWithValidData() throws InterruptedException {

        header.clickPersonalAccountButton()
                .clickRegisterLink().inputName(name)
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickRegisterButtonValid()
                .checkLoginPageFormHeader();
    }

    @Test
    @DisplayName("Зарегистрироваться с некорректными данными")
    public void checkRegistrationWithInvalidPassword() throws InterruptedException {
        header.clickPersonalAccountButton()
                .clickRegisterLink()
                .inputName(name)
                .inputEmail(user.getEmail())
                .inputPassword(incorrectPassword)
                .clickRegisterButtonInvalid()
                .checkInvalidPasswordMessage();
    }
}


