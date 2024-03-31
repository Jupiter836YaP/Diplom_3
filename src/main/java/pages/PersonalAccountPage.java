package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage extends BasePage {
    private final By buttonExit = By.xpath("//*[text()='Выход']");
    private final By buttonProfile = By.xpath("//*[text()='Профиль']");
    private final By buttonConstructor = By.xpath(".//p[text()='Конструктор']");
    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на кнопку 'Выход'")
    public LoginPage clickExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonExit));
        driver.findElement(buttonExit).click();
        return new LoginPage(driver);
    }

    @Step("Получить текст из кнопки 'Профиль'")
    public String getProfileText() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonProfile));
        return driver.findElement(buttonProfile).getText();
    }

    @Step("Нажать на кнопку 'Конструктор'")
    public MainPage clickButtonConstructor () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonConstructor));
        driver.findElement(buttonConstructor).click();
        return new MainPage(driver);
    }
}
