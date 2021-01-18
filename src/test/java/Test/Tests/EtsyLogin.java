package Test.Tests;
import Test.Pages.*;
import Test.Utils.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class EtsyLogin {
    LoginPage loginPage = new LoginPage();
    ItemSearch searchPage = new ItemSearch();

    @Test(description = "entering etsy.com")
    public void login() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage = new LoginPage();
        // Call the objects

        loginPage.signInEtsy.click();
        loginPage.usernameEtsy.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordEtsy.sendKeys(ConfigurationReader.getProperty("password"));

        if( loginPage.checkInEtsy.isEnabled() ) {
            loginPage.checkInEtsy.click();
            loginPage.loginButtonEtsy.click();
        } else {
            loginPage.loginButtonEtsy.click();
            if (loginPage.errorMessageEtsy.isDisplayed()){
                System.out.println("wrong username OR password");
            }
        }
        //Assert.assertTrue(loginPage.errorMessageEtsy.isDisplayed(), "wrong username OR password");

        wait(10);

        searchPage.inputEtsy.sendKeys( "wooden spoon" );
        searchPage.inputEtsy.sendKeys(Keys.ENTER);
    }

    //@Test(description = "searching in etsy.com")
    public void search() throws InterruptedException {

        searchPage.inputEtsy.sendKeys( "wooden spoon" );
        searchPage.inputEtsy.sendKeys(Keys.ENTER);
    }
}










