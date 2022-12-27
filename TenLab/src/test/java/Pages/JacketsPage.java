package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JacketsPage {

    @FindBy(xpath = "//*[@id=\"saveStore\"]")
    WebElement location;
    @FindBy(xpath = "/html/body/div[8]/div[3]/section/div[2]/div/button[1]/span[2]")
    WebElement filter;
    @FindBy(xpath = "/html/body/div[9]/div/div[2]/div[3]/div[2]/div/button[2]")
    WebElement size;
    @FindBy(xpath = "/html/body/div[8]/div[3]/div[2]/div/div/div[2]/div[1]/div[1]/div/div[1]/a/div/div/figure/img")
    WebElement chooseJacket;
    @FindBy(xpath = "/html/body/div[18]/div[1]")
    WebElement newsReject;
    WebDriver driver;
    public JacketsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
    }
    public JacketsPage acceptLocation(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(location)).click();
        return this;
    }
    public JacketsPage openFilters(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(filter)).click();
        return this;
    }
    public JacketsPage rejectNews(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(newsReject)).click();
        return this;
    }
    public JacketsPage chooseSize(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(size)).click();
        return this;
    }
    public SingleJacketPage openSingleJacketPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(chooseJacket)).click();
        return new SingleJacketPage(driver);
    }
}
