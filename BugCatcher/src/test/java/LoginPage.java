
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    static WebDriver driver;

    public LoginPage(WebDriver driver) {
        LoginPage.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(By.name("username")).sendKeys(username);
    }

    public void enterName() {
        driver.findElement(By.name("username")).sendKeys("g8tor");
    }
    public void enterPassword(String password) {
        driver.findElement(By.name("pass")).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/fieldset/button")).click();
    }
}


