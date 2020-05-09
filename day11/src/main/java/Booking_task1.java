import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Booking_task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/");

        WebElement direction = driver.findElement(By.id("ss"));
        direction.sendKeys("Paris");

        WebElement period = driver.findElement(By.xpath("//*[@data-mode='checkin']"));
        period.click();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date tenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays = dateFormat.format(threeDays);
        String datePlusTenDays = dateFormat.format(tenDays);
        WebElement checkIn = driver.findElement(By.xpath(String.format("//*[@data-date='%s']", datePlusThreeDays)));
        checkIn.click();
        WebElement checkOut = driver.findElement(By.xpath(String.format("//*[@data-date='%s']", datePlusTenDays)));
        checkOut.click();

        WebElement guests = driver.findElement(By.xpath("//*[@id='xp__guests__toggle']"));
        guests.click();

        WebElement adults = driver.findElement(By.xpath("//*[@aria-describedby='group_adults_desc'][2]"));
        adults.click();
        adults.click();

        WebElement rooms = driver.findElement(By.xpath("//*[@aria-describedby='no_rooms_desc'][2]"));
        rooms.click();

        WebElement search = driver.findElement(By.xpath("//*[@class='sb-searchbox__button ']"));
        search.click();
        TimeUnit.SECONDS.sleep(5);

        WebElement budget = driver.findElement(By.xpath("//*[@data-id='pri-5']"));
        budget.click();
        String budgetFrom = budget.getText().replaceAll("[^0-9]+", "");
        System.out.println("Budget per night from " + budgetFrom);
        int budgetPerNight = Integer.parseInt(budgetFrom);
        TimeUnit.SECONDS.sleep(5);

        WebElement lowest = driver.findElement(By.xpath("//*[contains(@class,'sort_price')]"));
        lowest.click();
        TimeUnit.SECONDS.sleep(5);

        WebElement MinFromMax = driver.findElement(By.xpath("(//*[contains(@class,'bui-price-display')]/div[2]/div)[1]"));
        String minPriceFromMax = MinFromMax.getText().replaceAll("[^0-9]+", "");
        int hotelPerNight = Integer.parseInt(minPriceFromMax) / 7;
        System.out.println("Minimum price per night from " + hotelPerNight);

        Assert.assertTrue("Something wrong", hotelPerNight >= budgetPerNight);
        driver.quit();
    }
}