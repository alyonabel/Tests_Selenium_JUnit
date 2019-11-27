import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import java.awt.*;
import java.awt.event.KeyEvent;

public class MainPage {
    private WebDriver driver;
    private MainPage mainPage ;
    Robot r = new Robot();

    public MainPage (WebDriver driver) throws AWTException {
        this.driver = driver;
    }

    private By logo= By.xpath("//*[@id=\"hplogo\"]");
    private By field_search  = By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[1]/div/div[2]/input");
    private By button_search= By.xpath ("/html/body/div/div[4]/form/div[2]/div[1]/div[3]/center/input[1]");


    public MainPage typeUrl (String url){
        driver.findElement(field_search).sendKeys(url);
        return this;
   }

    public ResultPage clickButtonSearch(){
        driver.findElement(button_search).click();
        return new ResultPage(driver);
    }

    public ResultPage search (String url)
    {
        this.typeUrl(url);
        this.clickButtonSearch();
        return new ResultPage(driver);
    }

    public ResultPage searchEnter (String url)
    {
        this.typeUrl(url);
        r.keyPress(KeyEvent.VK_ENTER);
        return new ResultPage(driver);
    }

}
