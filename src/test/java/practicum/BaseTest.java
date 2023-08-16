package practicum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import practicum.user.User;
import java.util.concurrent.TimeUnit;
import static practicum.config.Config.APP_URI;

public class BaseTest {
    WebDriver driver;
    protected User user = new User("MyName", "adsfds@yy.ru", "123456");

    String name = user.getName();
    String email = user.getEmail();
    String password = user.getPassword();
    String incorrectPassword = "111";

    @Before
    public void init() {
        driver = WebDriverFactory.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(APP_URI);
    }

    @After
    public void clean() {
        driver.quit();
    }
}