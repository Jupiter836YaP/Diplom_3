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

public class PersonalAccountTest extends BaseTest {
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
    @DisplayName("Проверка перехода в личный кабинет, при нажатии на кнопку 'Личный кабинет'")
    public void switchToPersonalAcc() {
        String displayedProfileText = new MainPage(driver)
                .clickButtonPersonalAccountWithoutAuth()
                .setInputPersonalData(email, password)
                .clickLoginButton()
                .clickButtonPersonalAccountWithAuth()
                .getProfileText();
        assertTrue("Текст не совпадает или отсутствует", displayedProfileText.contains("Профиль"));
    }


    @Test
    @DisplayName("Проверка перехода к конструктору, при нажатии на кнопку 'Конструктор'")
    public void switchToConstruct() {
        String displayedProfileText = new MainPage(driver)
                .clickButtonPersonalAccountWithoutAuth()
                .setInputPersonalData(email, password)
                .clickLoginButton()
                .clickButtonPersonalAccountWithAuth()
                .clickButtonConstructor()
                .getTextCreateOrder();
        assertTrue("Текст не совпадает или отсутствует", displayedProfileText.contains("Оформить заказ"));
    }

    @Test
    @DisplayName("Проверка выхода из личного кабинета")
    public void logoutPersonalAccount() {
        String displayedProfileText = new MainPage(driver)
                .clickButtonPersonalAccountWithoutAuth()
                .setInputPersonalData(email, password)
                .clickLoginButton()
                .clickButtonPersonalAccountWithAuth()
                .clickExitButton()
                .getLoginWindowText();
        assertTrue("Текст не совпадает или отсутствует", displayedProfileText.contains("Вход"));
    }
}
