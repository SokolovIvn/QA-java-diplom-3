package practicum;

import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import practicum.pageObject.MainPage;

public class ConstructorTest extends BaseTest{
    @Test
    @DisplayName("Переключить на вкладку Соусы")
    public void checkSwitchToSauceTab() throws InterruptedException {
        new MainPage(driver)
                .clickSauceTab()
                .checkSauceTabActive();
    }

    @Test
    @DisplayName("Переключить на вкладку Булки")
    public void checkSwitchToBunTab() throws InterruptedException {
        new MainPage(driver)
                .clickSauceTab()
                .clickBunTab()
                .checkBunTabActive();
    }

    @Test
    @DisplayName("Переключить на вкладку Начинки")
    public void checkSwitchToIngredientsTab() throws InterruptedException {
        new MainPage(driver)
                .clickIngredientsTab()
                .checkIngredientsTabActive();
    }
}
