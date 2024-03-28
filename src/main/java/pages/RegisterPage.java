package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    private final By inputEmail = By.xpath("//fieldset[2]/div/div/input");
    private final By inputPassword = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='Пароль']");
    private final By inputName = By.xpath("//fieldset[1]/div/div/input");
    private final By buttonRegister = By.xpath(".//button[text() ='Зарегистрироваться']");
    private final By errorMessage = By.xpath(".//p[text() ='Некорректный пароль']");
    private final By linkLoginInRegister = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Войти']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод личных данных для регистрации с корректным паролем")
    public RegisterPage setInputPersonalData(String email, String password, String name) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        return new RegisterPage(driver);
    }

    @Step("Нажимаем на кнопкку 'Зарегистрироваться' с корректным паролем")
    public LoginPage clickButtonRegisterWithCorrectPassword() {
        driver.findElement(buttonRegister).click();
        return new LoginPage(driver);
    }

    @Step("Нажимаем на кнопкку 'Зарегистрироваться' с некорректным паролем")
    public String clickButtonRegisterWithIncorrectPassword() {
        driver.findElement(buttonRegister).click();
        return driver.findElement(errorMessage).getText();
    }

    @Step("Нажимаем на линк 'Войти'")
    public LoginPage clickLinkLoginInRegister() {
        driver.findElement(linkLoginInRegister).click();
        return new LoginPage(driver);
    }


}
