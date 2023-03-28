package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver)
    {
        super(driver);
    }

    //Locators
    public final By new_user_button = By.xpath("//button[contains(.,'Add User')]");
    public final By firstNameField = By.name("FirstName");
    public final By lastNameField = By.name("LastName");
    public final By userNameField = By.name("UserName");
    public final By passwordField = By.name("Password");
    public final By roleDropdown = By.className("ng-scope");
    public final By roleList = By.name("RoleId");
    public final By customerRadioA = By.xpath("//input[@name='optionsRadios'][@value='15']");
    public final By customerRadioB = By.xpath("//input[@name='optionsRadios'][@value='16']");
    public final By radioList = By.className("radio");
    public final By emailField = By.name("Email");
    public final By cellPhoneField = By.name("Mobilephone");
    public final By saveButton = By.className("btn-success");
    public final By cancelButton = By.className("btn-danger");
    public final By searchBox = By.xpath("//input[@placeholder='Search']");
    public final By deleteButton = By.xpath("//button[@ng-click='delUser()']");
    public final By okButton = By.xpath("//button[text()='OK']");
    public final By editButton = By.xpath("//button[@type='edit']");


    //Functions
    public  void browseUrl(String url){getDriver().get(url);
    }
    public void newUserButtonClick() {getDriver().findElement(new_user_button).click(); }

    public  void firstNameInput(String firstName){getDriver().findElement(firstNameField).sendKeys(firstName);
    }

    public  void lastNameInput(String lastName){getDriver().findElement(lastNameField).sendKeys(lastName);
    }

    public void userNameInput(String userName){
        getDriver().findElement(userNameField).sendKeys(userName);
    }

    public  void passwordInput(String password){getElement(passwordField).sendKeys(password);
    }

    public  void roleSelection(String role) {
        Select roleDropdownSelect = new Select(getElement(roleDropdown));
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

    public  void roleSelectionByList(String role) {
/*        for (WebElement element: driver.findElements(roleList)) {
            if(element.getText().equals(role)){
                element.click();
                return;
            }
        }*/
        getDriver().findElement(roleList).click();
        new Select(getElement(roleList)).selectByVisibleText(role);

    }
    public  void customerRadioButton(String company) {
        if(company == "A"){
            driver.findElement(customerRadioA).click();
        } else if (company == "B") {
            driver.findElement(customerRadioB).click();
        }else {
            System.out.println("Invalid input. Pick betweeen A and B");
        }
    }

    public  void customerRadioButtonByList(String company) {
        for (WebElement element: driver.findElements(radioList)) {
            if(element.getText().equals(company)){
                 element.click();
                 return;
            }
        }
    }


    public  void emailInput(String email){driver.findElement(emailField).sendKeys(email);
    }

    public  void cellPhoneInput(String cellPhone){driver.findElement(cellPhoneField).sendKeys(cellPhone);
    }

    public  void saveButtonClick(){driver.findElement(saveButton).click();
    }

    public  void cancelButtonClick(){driver.findElement(cancelButton).click();
    }

    public  void createUserCustomer(){
        newUserButtonClick();
        firstNameInput("Sebastian");
        lastNameInput("Test");
        userNameInput("sebaTest");
        passwordInput("123");
        customerRadioButtonByList("Company AAA");
        roleSelectionByList("Customer");
        emailInput("sebatest@gmail.com");
        cellPhoneInput("5555353323");
        saveButtonClick();
    }

    public  void searchNewUser(String userEmail){
        searchUser(userEmail);

    }

    public  void deleteUser(String userName) {
        searchUser(userName);
        driver.findElement(deleteButton).click();
        driver.findElement(okButton).click();
    }

    public  void searchUser(String userEmail){
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(userEmail);
    }

    public boolean editButtonDisplayed(){
        if(driver.findElement(editButton).isDisplayed()) {
            System.out.println("Element is displayed");
            return true;
        }else {
            System.out.println("User was deleted properly");
            return false;
        }
    }

    public boolean validateUser() {
        try
        {
            driver.findElement(editButton).isDisplayed();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }
}
