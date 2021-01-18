package Test.Pages;
import Test.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemSearch {
        public ItemSearch(){
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(xpath = "//input[@id='global-enhancements-search-query']")
        public WebElement inputEtsy;

}

