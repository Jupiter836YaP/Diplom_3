import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserSwitcher {
    public static WebDriver getDriver(String browserName) {
        WebDriver driver;
        switch (browserName) {
            case "chrome":
                driver = WebDriverManager.chromedriver().create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                throw new RuntimeException("invalid browser name");
        }
        return driver;
    }
}
