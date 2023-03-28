import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Validation {
    private WebDriver driver= null;
    public  MainPage mpObj;

    @BeforeTest
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterTest
    public void Teardown()
    {
        if(driver!=null) driver.quit();
    }
    @Test
    public void testSuite(){
        addUser();
        validateNewUser();
        deleteUserNovak();
        validateUserDeletion();
    }

    //Add a new customer user
    public void addUser() {
        mpObj = new MainPage(driver);
        mpObj.browseUrl("https://www.way2automation.com/angularjs-protractor/webtables/");
        mpObj.createUserCustomer();
    }

    //Validate new user is found
    public void validateNewUser () {
        mpObj.searchNewUser("sebatest@gmail.com");
        Assert.assertTrue(mpObj.validateUser(),"User was not present");
    }

    //Delete user "Novak"
    public void deleteUserNovak () {
        mpObj.deleteUser("novak");
    }

    public void validateUserDeletion () {
        mpObj.browseUrl("https://www.way2automation.com/angularjs-protractor/webtables/");
        mpObj.searchUser("asa@asd.cz");
        mpObj.editButtonDisplayed();
    }
}

