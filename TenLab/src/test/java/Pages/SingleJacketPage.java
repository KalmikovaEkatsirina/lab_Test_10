package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SingleJacketPage {
    @FindBy(xpath = "/html/body/div[7]/div/div[1]/div/div/div[3]/add-to-wishlist-button")
    WebElement wishlistButton;
    @FindBy(xpath = "/html/body/div[4]/div[5]/logo-element")
    WebElement mainPageLogo;
    @FindBy(xpath = "/html/body/div[7]/div/div[1]/div/div/div[1]/h1")
    WebElement jacketName;
    WebDriver driver;
    public SingleJacketPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
    }
    public SingleJacketPage addToWishlist(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(wishlistButton)).click();
        return this;
    }
    public MainPage openMainPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(mainPageLogo)).click();
        return new MainPage(driver);
    }
    public String getResult(){
        return wishlistButton.getAttribute("is-active");
    }
    public String getJacketName(){
        return jacketName.getText();
    }
}
