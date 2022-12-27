import Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckLastItemsTest {
    @Test
    public void checkLastItemTest(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        String wishlistTestResult=new MainPage(driver)
                .openPage()
                .openMenu()
                .openJacketsPage()
                .openSingleJacketPage()
                .openMainPage()
                        .openLastItem()
                                .getJacketName();
        Assert.assertEquals(wishlistTestResult,"СТЕГАНАЯ КУРТКА С ВОРОТНИКОМ-СТОЙКОЙ");
    }
}
