import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {

    WebDriver driver;
     public ResultPage (WebDriver driver)
     {
         this.driver = driver;
     }

    private By heading =  By.xpath ("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[2]/div");
    private By advertisements = By.xpath ("//*[@id=\"gsr\"]");


     public String getFirstResultText()
     {
      return driver.findElement(heading).getText();
     }

    public String getAdvertisementsText()
    {
        return driver.findElement(advertisements).getText();
    }
}
