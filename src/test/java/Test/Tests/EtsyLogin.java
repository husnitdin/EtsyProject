package Test.Tests;
import Test.Pages.*;
import Test.Utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EtsyLogin {
    LoginPage loginPage = new LoginPage();
    ItemSearch searchPage = new ItemSearch();

    @Test(description = "entering etsy.com")
    public void login() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

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

        /*WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        if ( (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class, 'wt-pt-xs-2')]")))).isDisplayed() ){
            searchPage.inputEtsy.sendKeys( "wooden spoon" );
            searchPage.inputEtsy.sendKeys(Keys.ENTER);
        } else {
            throw new Exception("element not found");
        }*/

    }

    @Test(description = "searching in etsy.com")
    public void search() throws Exception {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        if ( (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class, 'wt-pt-xs-2')]")))).isDisplayed() ){
            searchPage.inputEtsy.sendKeys( "wooden spoon" );
            searchPage.inputEtsy.sendKeys(Keys.ENTER);
        } else {
            throw new Exception("element not found");
        }
    }
}










