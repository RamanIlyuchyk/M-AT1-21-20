import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Booking_task3 {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");

        WebElement direction = driver.findElement(By.id("ss"));
        direction.sendKeys("Oslo");

        WebElement period = driver.findElement(By.xpath("//*[@data-mode='checkin']"));
        period.click();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date oneDay = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date twoDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays = dateFormat.format(oneDay);
        String datePlusTenDays = dateFormat.format(twoDays);
        WebElement checkIn = driver.findElement(By.xpath(String.format("//*[@data-date='%s']", datePlusThreeDays)));
        checkIn.click();
        WebElement checkOut = driver.findElement(By.xpath(String.format("//*[@data-date='%s']", datePlusTenDays)));
        checkOut.click();

        WebElement guests = driver.findElement(By.xpath("//*[@id='xp__guests__toggle']"));
        guests.click();

        WebElement children = driver.findElement(By.xpath("//*[@aria-describedby='group_children_desc'][2]"));
        children.click();

        WebElement search = driver.findElement(By.xpath("//*[@class='sb-searchbox__button ']"));
        search.click();
        TimeUnit.SECONDS.sleep(5);

        WebElement threeStarHotels = driver.findElement(By.xpath("//*[@data-id='class-3']"));
        threeStarHotels.click();
        TimeUnit.SECONDS.sleep(5);

        WebElement fourStarHotels = driver.findElement(By.xpath("//*[@data-id='class-4']"));
        fourStarHotels.click();
        TimeUnit.SECONDS.sleep(5);

        String tenthHotelPath = "//*[@data-hotelid][10]";
        WebElement tenthHotel = driver.findElement(By.xpath(tenthHotelPath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", tenthHotel);
        TimeUnit.SECONDS.sleep(3); //just to have time to see this action

        String nameOfTenthHotelPath = tenthHotelPath + "//span[contains(@class,'sr-hotel__name')]";
        WebElement nameOfTenthHotel = driver.findElement(By.xpath(nameOfTenthHotelPath));
        new Actions(driver).moveToElement(nameOfTenthHotel).perform();
        TimeUnit.SECONDS.sleep(3); //just to have time to see this action

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='green'", tenthHotel);
        TimeUnit.SECONDS.sleep(3); //just to have time to see this action

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color='red'", nameOfTenthHotel);
        TimeUnit.SECONDS.sleep(3); //just to have time to see this action

        Assert.assertEquals("Something wrong", "color: red;", nameOfTenthHotel.getAttribute("style"));
        driver.quit();
    }
}