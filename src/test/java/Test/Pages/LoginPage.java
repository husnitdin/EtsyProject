package Test.Pages;
import Test.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

        public LoginPage(){
            PageFactory.initElements(Driver.getDriver(), this);
        }

        // from now on we stop using findElement
        @FindBy(xpath = "//button[contains(@class, 'select-signin')]")
        public WebElement signInEtsy;

        @FindBy(xpath = "//input[@id='join_neu_email_field']")
        public WebElement usernameEtsy;

        @FindBy(xpath = "//input[@id='join_neu_password_field']")
        public WebElement passwordEtsy;

        @FindBy(xpath = "//button[@value='sign-in']")
        public WebElement loginButtonEtsy;

        @FindBy(xpath= "//div[.='Password was incorrect.']")
        public WebElement errorMessageEtsy;

        @FindBy(xpath= "//div[@class='wt-checkbox ']")
        public WebElement checkInEtsy;

        public void login(String username, String password){
            usernameEtsy.sendKeys(username);
            passwordEtsy.sendKeys(password);
            loginButtonEtsy.click();
        }
    }
