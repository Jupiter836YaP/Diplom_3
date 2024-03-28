import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {
    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void transitionsToSectionsBuns() {
        String displayedActiveBuns = new MainPage(driver)
                .clickButtonSauces()
                .clickButtonBuns()
                .getTextActiveSection();
        assertTrue("Текст не совпадает или отсутствует", displayedActiveBuns.contains("Булки"));
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void transitionsToSectionsSauces() {
        String displayedActiveBuns = new MainPage(driver)
                .clickButtonSauces()
                .getTextActiveSection();
        assertTrue("Текст не совпадает или отсутствует", displayedActiveBuns.contains("Соусы"));
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void transitionsToSectionsFilling() {
        String displayedActiveBuns = new MainPage(driver)
                .clickButtonFilling()
                .getTextActiveSection();
        assertTrue("Текст не совпадает или отсутствует", displayedActiveBuns.contains("Начинки"));
    }

}
