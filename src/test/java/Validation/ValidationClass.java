package Validation;

import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ValidationClass {
    public static WebDriver driver = null;

    public static void main(String[] args) {
        setupBrowser();
        addUser();
        validateNewUser();
        deleteUserNovak();
        validateUserDeletion();
    }
    public static void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
    }


    //Add a new customer user
    public static void addUser(){
        MainPage.createUserCustomer();
    }

    //Validate new user is found
    public static void validateNewUser(){
        MainPage.searchNewUser("sebatest@gmail.com");
    }

    //Delete user "Novak"
    public static void deleteUserNovak(){
        MainPage.deleteUser("novak");
    }

    public static void validateUserDeletion(){
        MainPage.searchUser("asa@asd.cz");
        if(!MainPage.editButton.isDisplayed()){
            System.out.println("User was deleted properly");
        }
    }

}
