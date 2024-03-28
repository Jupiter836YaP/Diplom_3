package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    private final By buttonPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By buttonLogAccount = By.xpath(".//section[2]/div/button");
    private final By logoBurger = By.xpath(".//div/a[@href='/']");
    private final By buttonBunsSection = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");
    private final By buttonSaucesSection = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");
    private final By buttonFillingsSection = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");
    private final By activeSection = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");
    private final By buttonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Нажать на кнопку 'Личный кабнет' до авторизации")
    public LoginPage clickButtonPersonalAccountWithoutAuth () {
        driver.findElement(buttonPersonalAccount).click();
        return new LoginPage(driver);
    }

    @Step ("Нажать на кнопку 'Личный кабинет' после авторизации")
    public PersonalAccountPage clickButtonPersonalAccountWithAuth () {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonPersonalAccount));
        driver.findElement(buttonPersonalAccount).click();
        return new PersonalAccountPage(driver);
    }

    @Step ("Нажать на кнопку 'Войти в аккаунт'")
    public LoginPage clickButtonLogAccount () {
        driver.findElement(buttonLogAccount).click();
        return new LoginPage(driver);
    }

    @Step ("Нажать на лого бургера")
    public MainPage clickLogoBurger () {
        driver.findElement(logoBurger).click();
        return new MainPage(driver);
    }


    @Step ("Нажать на кнопку 'Булки' в конструкторе")
    public MainPage clickButtonBuns () {
        driver.findElement(buttonBunsSection).click();
        return new MainPage(driver);
    }

    @Step ("Нажать на кнопку 'Соусы' в конструкторе")
    public MainPage clickButtonSauces () {
        driver.findElement(buttonSaucesSection).click();
        return new MainPage(driver);
    }

    @Step ("Нажать на кнопку 'Начинки' в конструкторе")
    public MainPage clickButtonFilling () {
        driver.findElement(buttonFillingsSection).click();
        return new MainPage(driver);
    }

    @Step("Извлекаем текст из активного раздела в конструкторе")
    public String getTextActiveSection() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(activeSection));
        return driver.findElement(activeSection).getText();
    }

    @Step("Извлекаем текст из кнопки 'Оформить заказ'")
    public String getTextCreateOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonCreateOrder));
        return driver.findElement(buttonCreateOrder).getText();
    }
}
