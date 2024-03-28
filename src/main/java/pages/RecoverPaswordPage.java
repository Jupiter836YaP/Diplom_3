package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPaswordPage extends BasePage{
    private final By linkLogin = By.xpath(".//a[text()='Войти']");
    public RecoverPaswordPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLinkLogin() {
        driver.findElement(linkLogin).click();
        return new LoginPage(driver);
    }

}
