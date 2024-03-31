package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPaswordPage extends BasePage{
    private final By linkLogin = By.xpath(".//a[text()='Войти']");
    public RecoverPaswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на ссылку входа")
    public LoginPage clickLinkLogin() {
        driver.findElement(linkLogin).click();
        return new LoginPage(driver);
    }

}
