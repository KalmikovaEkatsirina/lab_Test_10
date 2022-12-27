package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    String mainPage="https://www.pullandbear.com/by/%D0%B4%D0%BB%D1%8F-%D0%B6%D0%B5%D0%BD%D1%89%D0%B8%D0%BD-n6417";
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/ul/li[3]/a/p")
    WebElement clothes;
    @FindBy(xpath = "//*[@id=\"subitems-cont-1030207046\"]/li[6]/a/p")
    WebElement jackets;
    @FindBy(xpath = "/html/body/div[6]/div[4]/div/div/div/div[3]/div/div/div/div/div[1]/a/div/div/img")
    WebElement lastOpenedItem;

    WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
    }

    public MainPage openPage(){
        driver.get(mainPage);
        return this;
    }
    public MainPage openMenu(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(clothes)).click();
        return this;
    }
    public JacketsPage openJacketsPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(jackets)).click();
        return new JacketsPage(driver);
    }
    public SingleJacketPage openLastItem(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(lastOpenedItem)).click();
        return new SingleJacketPage(driver);
    }
}
