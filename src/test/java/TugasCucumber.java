import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TugasCucumber {

    static WebDriver driver;
    static String URL = "https://www.opencart.com/index.php";

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);

        driver.manage().window().maximize();
    }

    @Test
    public void b_Behavior() throws Exception{
        driver.navigate().to(URL+"?route=cms/demo");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        String titlenya = driver.getTitle();
        System.out.println("Title webnya adalah "  + titlenya);

        String pageSourcenya = driver.getPageSource();
        System.out.println("Isian Page :  ");
        System.out.println(pageSourcenya);

        Thread.sleep(3000);
    }



    @Test
    public void a_c_InteractionWebElement() throws Exception {
        driver.navigate().to(URL+"?route=account/login");
        driver.findElement(By.id("input-email")).sendKeys("ramonesdai@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Halamadrid");
        driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[2]/div/div[1]/form/div[3]/div[1]/button[1]")).submit();


        String textnya = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[2]/div[1]")).getText();
        System.out.println(textnya);

        String getCSS = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[2]/div[2]/div[1]/form/div[3]/div[1]/button[1]")).getCssValue("font-size");
        String getCSS2 = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[2]/div[2]/div[1]/form/div[3]/div[1]/button[1]")).getCssValue("text-decoration");
        System.out.println("Font Size = "+getCSS);
        System.out.println("Decnya adalah = "+getCSS2);

        String getAttribut = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[2]/div[2]/div[1]/form/div[3]/div[1]/button[1]")).getAttribute("class");
        System.out.println(getAttribut);

        WebElement getSizenih = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[2]/div[2]/div[1]/form/div[3]/div[1]/button[1]"));
        Dimension dimensi = getSizenih.getSize();

        System.out.println("Dimensinya yaitu = "+dimensi);

        WebElement getLokasinya = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[2]/div[2]/div[1]/form/div[3]/div[1]/button[1]"));
        Point pointnya = getLokasinya.getLocation();

        System.out.println("Lokasi X nya yaitu = "+ pointnya.x + " dan Y nya " + pointnya.y);

        Thread.sleep(5000);
    }

//    @Test
//    public void d_radiobutton() throws Exception{
//        driver.navigate().to("https://ultimateqa.com/selenium-java-2");
//        driver.findElement(By.xpath("//*[@id=\"post-215583\"]/div/div/div/div[1]/div/div[1]/div[10]/a")).click();
//        driver.findElement(By.xpath("//*[@id=\"payment-option-paypal\"]")).click();
//        Thread.sleep(3000);
//    }

    @Test
    public void b_dropDown() {
        driver.navigate().to("https://demoqa.com/select-menu");
        driver.findElement(By.id("oldSelectMenu")).click();

    }

    @Test
    public void c_checkbox() {
        driver.navigate().to("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[1]")).click();
    }

    @Test
    public void h_HandleAlert() throws Exception{
        driver.navigate().to(URL+"?route=account/login");
        driver.findElement(By.id("input-email")).sendKeys("ramonesdai@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Halamadrid");
        driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[2]/div/div[1]/form/div[3]/div[1]/button[1]")).submit();


        String textnya = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[2]/div[1]")).getText();
        System.out.println(textnya);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}
