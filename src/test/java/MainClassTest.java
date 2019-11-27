import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class MainClassTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() throws AWTException {
        System.setProperty("webdriver.gecko.driver","D:\\Projects\\Idea\\test_selenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get ("https://google.com");
        mainPage = new MainPage(driver);
    }

    @Test
    public void check()
    {
        ResultPage resultPage = mainPage.search("yandex.ru");
        String heading = resultPage.getFirstResultText();
        Assert.assertTrue(heading.contains("Яндекс — поисковая система и интернет-портал"));
    }

    @Test
    public void checkEnter()
    {
        ResultPage resultPage = mainPage.searchEnter("yandex.ru");
        String heading = resultPage.getFirstResultText();
        Assert.assertTrue(heading.contains("Яндекс — поисковая система и интернет-портал"));
    }


    @After
    public void tearDown()
    {
       driver.quit();
    }


}
