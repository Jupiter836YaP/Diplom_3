import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserSwitcher {
    public static WebDriver getDriver(String browserName) {
        WebDriver webDriver;
        switch (browserName) {
            case "chrome":
                webDriver = WebDriverManager.chromedriver().create();
                break;
            case "firefox":
                webDriver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                throw new RuntimeException("invalid browser name");
        }
        return webDriver;
    }
}
