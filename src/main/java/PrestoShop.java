import static org.openqa.selenium.Keys.chord;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrestoShop {

    private static int countScreen;
    private static WebDriver driver;

    public static final String imgDir = "E:\\java\\scrnsht\\";
    private static final SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

    static {
        try {
            File dir = new File(imgDir);

            if (dir.exists() && dir.isDirectory() && dir.list() != null) {
                String[] list = dir.list();
                Arrays.sort(list);
                String w = list[list.length - 1];
                String numbers = w.substring(w.length() - 12, w.lastIndexOf("."));
                countScreen = Integer.parseInt(numbers);
            }
        } catch (Exception e) {
            countScreen = 0;
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\Java\\chromedriver.exe");



        driver = new ChromeDriver();
        String urlPrestoShop = "http://prestashop.qatestlab.com.ua/en/";
        driver.get(urlPrestoShop);

        Thread.sleep(3000);



        screensotDo();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("E:\\java\\scrnsht\\newscr.png"));

        driver.manage().window().maximize();


        WebElement languege = driver.findElement(By.id("languages-block-top"));
        languege.click();

        String url = driver.getCurrentUrl();
        String ukrUrl = "http://prestashop.qatestlab.com.ua/uk/";

        if (!url.equals(ukrUrl)) {
            WebElement ukr = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions
                            .elementToBeClickable(By.xpath("//a[@href='http://prestashop.qatestlab.com.ua/uk/']")));
            ukr.click();
        }

        screensotDo();
        //File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(screenshot1,new File("E:\\java\\scrnsht\\newscr.png"));

        //driver.manage().window().setSize(new Dimension(1000, 1000)); //уменьшение размеров окна

        WebElement login = driver.findElement(By.xpath("//a[@class='login']"));
        login.click();

        screensotDo("login");
        //File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(screenshot2,new File("E:\\hachik NE TROGAT\\тестирование\\prog\\newscr2.png"));

        WebElement createAccaunt = driver.findElement(By.xpath("//input[@id='email_create']"));

        Actions builder = new Actions(driver);
        builder.sendKeys(createAccaunt,"seriislon@gmail.com").build().perform();

        screensotDo("createaccaunt");
       // File screenshot3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(screenshot3,new File("E:\\hachik NE TROGAT\\тестирование\\prog\\newscr3.png"));

        createAccaunt.submit();
        Thread.sleep(3000);

        createAccaunt.clear();

        builder.sendKeys(createAccaunt,"dtgpechat2@gmail.com").build().perform();
        createAccaunt.submit();


        /*WebElement sex = (new WebDriverWait(driver,20))
                        .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//input[@id='id_gender1']")));

        sex.click();

        WebElement name = driver.findElement(By.id("customer_firstname"));
        name.sendKeys("dtg");

        WebElement sekondName = driver.findElement(By.id("customer_lastname"));
        sekondName.sendKeys("dtg");

        WebElement pass = driver.findElement(By.xpath("//input[@id='passwd']"));
        pass.sendKeys("123456");

        Select dayDrop = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        dayDrop.selectByValue("1");

        Select monthDrop = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        monthDrop.selectByValue("1");

        WebElement yer = (new WebDriverWait(driver,10))
                        .until(ExpectedConditions
                        .elementToBeClickable((By.xpath("//div[@class='col-xs-4 lineForm']"))));
        yer.click();

        yer.findElement(By.xpath("//span[@val='2018']")).click();

        driver.manage().window().setSize(new Dimension(1000,1000));

        File screenshot7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot7,new File("E:\\hachik NE TROGAT\\тестирование\\prog\\newscr7.png"));

        WebElement registr = driver.findElement(By.xpath("//button[@id='submitAccount']"));
        registr.click();*/




        builder.moveToElement(createAccaunt)
                .moveByOffset(20,0)
                .clickAndHold()
                .moveByOffset(-180,0)
                .sendKeys(chord(Keys.CONTROL+"c"))
                .perform();
        //screensotDo();

        //File screenshot4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(screenshot4,new File("E:\\hachik NE TROGAT\\тестирование\\prog\\newscr4.png"));

        WebElement vhod = driver.findElement(By.xpath("//input[@id='email']"));

        builder.sendKeys(vhod,chord(Keys.CONTROL,"v")).perform();
        //screensotDo();
        //File screenshot5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(screenshot5,new File("E:\\hachik NE TROGAT\\тестирование\\prog\\newscr5.png"));

        WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
        password.sendKeys("123456");

        screensotDo();

        WebElement vhodParol = driver.findElement(By.xpath("//button[@id='SubmitLogin']//span"));
        vhodParol.click();

        //screensotDo();
        //File screenshot6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(screenshot6,new File("E:\\hachik NE TROGAT\\тестирование\\prog\\newscr6.png"));


        WebElement mainPage = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
        mainPage.click();

        int sizeIFrame = driver.findElements(By.tagName("iframe")).size();
        System.out.println(sizeIFrame);

        Thread.sleep(3000);



        WebElement order = driver.findElement(By.xpath("//ul[@id='homefeatured']" +
                "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line" +
                " first-item-of-mobile-line']//div[@class='product-container']" +
                "//div[@class='left-block']//div[@class='product-image-container']//a[@class='product_img_link']"));

        builder.moveToElement(order).build().perform();
        //order.click();
        //int sizeIFrame2 = driver.findElements(By.tagName("iframe")).size();
        //System.out.println(sizeIFrame2);

        //WebElement plus = driver.findElement(By.xpath("//span[@class='span_link no-print']"));
        //plus.click();

        //WebElement str = (new WebDriverWait(driver,10)
                //.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Next']"))));
        //builder.click(str).click(str).click(str).build().perform();
        //увеличение изображения и переключение фото

        //WebElement x = driver.findElement(By.xpath("//a[@title='Close']"));
       // x.click();




        WebElement addTshort = (new WebDriverWait(driver,10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[contains(text(),'У Кошик')]")));
        addTshort.click();



        WebElement closeAddTshort = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='cross']")));
        closeAddTshort.click();
        

        /*WebElement coshikprod = (new WebDriverWait(driver,10)
                        .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//a[@title='Перейти до кошика']"))));
        Thread.sleep(3000);
        coshikprod.click();*/

        WebElement coshikAlon = driver.findElement(By.xpath("//div[@class='shopping_cart']//a"));

        builder.moveToElement(coshikAlon).build().perform();

        WebElement del = (new WebDriverWait(driver,10)
                        .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//a[@class='ajax_cart_block_remove_link']"))));

        del.click();







    }
    public static void screensotDo () throws IOException {

        File screen  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String formatMask = imgDir+"newscrCount%08d.png";

        FileUtils.copyFile(screen,new File(String.format(formatMask, ++countScreen)));

    }

    public static void screensotDo(String a) throws IOException {
        File screen  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String time = data.format(System.currentTimeMillis());
        FileUtils.copyFile(screen,new File(imgDir+time+"_"+a+".png"));
    }

        
    }

