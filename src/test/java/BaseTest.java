import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import steps.UserSteps;

import static constant.BaseUrl.BASE_URL;

public class BaseTest {
    protected String accessToken;
    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserSwitcher.getDriver("chrome");
        driver.get(BASE_URL);

        RestAssured.baseURI = BASE_URL;
    }

    @After
    public void clearData() {
        if (accessToken != null) {
            UserSteps.userDelete(accessToken);
        }
        driver.quit();
    }
}
