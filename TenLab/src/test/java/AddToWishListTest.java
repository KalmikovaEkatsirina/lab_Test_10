import Pages.JacketsPage;
import Pages.MainPage;
import Pages.SingleJacketPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToWishListTest {
    @Test
    public void checkIfAdded(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        String wishlistTestResult=new MainPage(driver)
                .openPage()
                .openMenu()
                .openJacketsPage()
                .acceptLocation()
                .openFilters()
                .rejectNews().
                chooseSize().
                openSingleJacketPage()
                .addToWishlist()
                .getResult();
        Assert.assertEquals(wishlistTestResult,"");
    }
}
