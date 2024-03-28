import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pojo.User;
import steps.UserSteps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    Faker faker = new Faker();
    private String email;
    private String password;
    private String name;

    @Before
    public void createUser() {
        name = faker.name().firstName();
        password = faker.internet().password(6, 10);
        email = faker.internet().emailAddress();

        User user = new User(email, password, name);
        ValidatableResponse response = UserSteps.userCreate(user);
        accessToken = response.extract().path("accessToken");
        response.assertThat().body("success", equalTo(true)).and().statusCode(200);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void loginUserOnMainPageByButtonLogAcc(){
        String displayedCreateOrderText = new MainPage(driver)
                .clickButtonLogAccount()
                .setInputPersonalData(email, password)
                .clickLoginButton()
                .getTextCreateOrder();
        assertTrue("Текст не совпадает или отсутствует", displayedCreateOrderText.contains("Оформить заказ"));
    }

    @Test
    @DisplayName("Вход по кнопке «Личный кабинет» на главной странице")
    public void loginUserOnMainPageByButtonPersonalAcc(){
        String displayedCreateOrderText = new MainPage(driver)
                .clickButtonPersonalAccountWithoutAuth()
                .setInputPersonalData(email, password)
                .clickLoginButton()
                .getTextCreateOrder();
        assertTrue("Текст не совпадает или отсутствует", displayedCreateOrderText.contains("Оформить заказ"));
    }

    @Test
    @DisplayName("Вход по линку «Войти» на странице регистрации")
    public void loginUserOnRegisterPage(){
        String displayedCreateOrderText = new MainPage(driver)
                .clickButtonLogAccount()
                .clickLinkRegister()
                .clickLinkLoginInRegister()
                .setInputPersonalData(email, password)
                .clickLoginButton()
                .getTextCreateOrder();
        assertTrue("Текст не совпадает или отсутствует", displayedCreateOrderText.contains("Оформить заказ"));
    }

    @Test
    @DisplayName("Вход по линку «Войти» на странице восстановления пароля")
    public void loginUserOnRecoverPasswordPage(){
        String displayedCreateOrderText = new MainPage(driver)
                .clickButtonLogAccount()
                .clickRecoverPasswordLink()
                .clickLinkLogin()
                .setInputPersonalData(email, password)
                .clickLoginButton()
                .getTextCreateOrder();
        assertTrue("Текст не совпадает или отсутствует", displayedCreateOrderText.contains("Оформить заказ"));
    }

}
