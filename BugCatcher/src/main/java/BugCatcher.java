import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BugCatcher {
    public static void main(String[] args) {
        String browserName = "chrome";

        WebDriver driver = null;
        if(browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if(browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.get("https://bugcatcher-primer.coe.revaturelabs.com/?dev=11");


    }
}
