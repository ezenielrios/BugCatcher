import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class LoginFeature {
    String browserName = "chrome";
    WebDriver driver = null;
    LoginPage LoginPage ;

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        if(browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if(browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        LoginPage = new LoginPage(driver);
        driver.get("https://bugcatcher-primer.coe.revaturelabs.com/?dev=11");
        driver.manage().window().maximize();
        System.out.println("step - user is an login page");
    }


    @When("The employee types {string} into username input")
    public void the_employee_types_username_into_username_input(String username){
        LoginPage.enterUsername(username);
        System.out.println("Username entered is :"+username);
    }

    @When("The employee types {string} into password input")
    public void the_employee_types_password_into_password_input(String password) {
        LoginPage.enterPassword(password);
        System.out.println("Password entered is :"+password);

    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        LoginPage.clickLogin();
        System.out.println("clicked Log in");
    }



    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String role) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://bugcatcher-primer.coe.revaturelabs.com/?dev=11";
        assertEquals(expectedURL, actualURL);
        System.out.println("Role is :"+role);

    }

    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_fname_lname_on_the_home_page(String fname,String lname) {
        System.out.println("FName and lname is "+fname+"  "+lname);
    }


    @When("The employee types \"chOmp! into password input")
    public void the_employee_types_ch_omp_into_password_input() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public boolean isAlertPresent(){
            try
            {
                driver.switchTo().alert();
                return true;

            }   // try
            catch (NoAlertPresentException Ex)
            {
                return false;
            }   // catch
        }


}














