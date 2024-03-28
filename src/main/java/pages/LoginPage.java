package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private final By linkRegister = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By recoverPassword = By.xpath(".//a[text()='Восстановить пароль']");
    private final By inputEmail = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='name']");
    private final By inputPassword = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='Пароль']");
    private final By buttonLogin = By.xpath(".//button[text() = 'Войти']");
    private final By windowLoginText = By.xpath(".//h2[text() = 'Вход']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на ссылку 'Зарегистрироваться'")
    public RegisterPage clickLinkRegister() {
        driver.findElement(linkRegister).click();
        return new RegisterPage(driver);
    }

    @Step("Ввести личные данные пользвателя")
    public LoginPage setInputPersonalData(String email, String password) {
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        return new LoginPage(driver);
    }

    @Step("Нажать на кнопку 'Войти'")
    public MainPage clickLoginButton() {
        driver.findElement(buttonLogin).click();
        return new MainPage(driver);
    }

    @Step("Проверяем появление окна входа")
    public String getLoginWindowText() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(windowLoginText));
        return driver.findElement(windowLoginText).getText();
    }

    @Step("Нажать на ссылку 'Восстановить пароль'")
    public RecoverPaswordPage clickRecoverPasswordLink() {
        driver.findElement(recoverPassword).click();
        return new RecoverPaswordPage(driver);
    }
}
