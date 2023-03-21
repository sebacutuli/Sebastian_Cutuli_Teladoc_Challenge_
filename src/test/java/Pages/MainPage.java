package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MainPage {

    public static WebDriver driver= null;

    //Locators
    public static WebElement new_user_button = driver.findElement(By.linkText(" Add User"));
    public static WebElement firstNameField = driver.findElement(By.name("FirstName"));
    public static WebElement lastNameField = driver.findElement(By.name("LastName"));
    public static WebElement passwordField = driver.findElement(By.name("Password"));
    public static WebElement roleDropdown = driver.findElement(By.className("ng-scope"));
    public static List<WebElement> roleList = driver.findElements(By.className("ng-scope"));
    public static WebElement customerRadioA = driver.findElement(By.xpath("//input[@name='optionsRadios'][@value='15']"));
    public static WebElement customerRadioB = driver.findElement(By.xpath("//input[@name='optionsRadios'][@value='16']"));
    public static List<WebElement> radioList = driver.findElements(By.className("radio"));
    public static WebElement emailField = driver.findElement(By.name("Email"));
    public static WebElement cellPhoneField = driver.findElement(By.name("Mobilephone"));
    public static WebElement saveButton = driver.findElement(By.className("btn btn-success"));
    public static WebElement cancelButton = driver.findElement(By.className("btn btn-danger"));
    public static WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
    public static WebElement deleteButton = driver.findElement(By.xpath("//button[@ng-click='delUser()']"));
    public static WebElement okButton = driver.findElement(By.xpath("//button[text()='OK']"));
    public static WebElement editButton = driver.findElement(By.xpath("//button[@type='edit']"));


    //Functions
    public static void browseUrl(String url){
        driver.get(url);
    }
    public static void newUserButtonClick(){
        new_user_button.click();
    }

    public static void firstNameInput(String firstName){
        firstNameField.sendKeys(firstName);
    }

    public static void lastNameInput(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public static void passwordInput(String password){
        passwordField.sendKeys(password);
    }

    public static void roleSelection(String role) {
        Select roleDropdownSelect = new Select(roleDropdown);
        if (role == "Sales Team") {
            roleDropdownSelect.selectByVisibleText("Sales Team");
        } else if (role == "Customer") {
            roleDropdownSelect.selectByVisibleText("Customer");
        } else if (role == "Admin") {
            roleDropdownSelect.selectByVisibleText("Admin");
        } else {
            System.out.println("Role is not valid");
        }
    }

    public static void roleSelectionByList(String role) {
        for (WebElement element: roleList) {
            if(element.getText().equals(role)){
                element.click();
                return;
            }
        }
    }
    public static void customerRadioButton(String company) {
        if(company == "A"){
            customerRadioA.click();
        } else if (company == "B") {
            customerRadioB.click();
        }else {
            System.out.println("Invalid input. Pick betweeen A and B");
        }
    }

    public static void customerRadioButtonByList(String company) {
        for (WebElement element: radioList) {
            if(element.getText().equals(company)){
                 element.click();
                 return;
            }
        }
    }


    public static void emailInput(String email){
        emailField.sendKeys(email);
    }

    public static void cellPhoneInput(String cellPhone){
        cellPhoneField.sendKeys(cellPhone);
    }

    public static void saveButtonClick(){
        saveButton.click();
    }

    public static void cancelButtonClick(){
        cancelButton.click();
    }

    public static void createUserCustomer(){
        newUserButtonClick();
        firstNameInput("Sebastian");
        lastNameInput("Test");
        passwordInput("123");
        roleSelectionByList("Customer");
        customerRadioButtonByList("Company AAA");
        emailInput("sebatest@gmail.com");
        cellPhoneInput("5555353323");
        saveButtonClick();
    }

    public static void searchNewUser(String userEmail){
        searchBox.sendKeys(userEmail);
        if(editButton.isDisplayed()){
            System.out.println("User was created successfully");
        }
    }

    public static void deleteUser(String userName) {
        searchBox.sendKeys(userName);
        deleteButton.click();
        okButton.click();
    }

    public static void searchUser(String userEmail){
        searchBox.sendKeys(userEmail);
    }
}
