import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Booking {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");

        WebElement direction = driver.findElement(By.id("ss"));
        direction.sendKeys("Париж");

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

        WebElement maxBudget = driver.findElement(By.xpath("//*[@data-id='pri-5']"));
        maxBudget.click();
        String maxBudgetDay = maxBudget.getText().replaceAll("[^0-9]+", "");
        System.out.println("Maximum budget per night from " + maxBudgetDay);
        int budgetDay = Integer.parseInt(maxBudgetDay);

        WebElement lowest = driver.findElement(By.xpath("//*[@data-category='price']"));
        lowest.click();
        Thread.sleep(15000);

        WebElement MinFromMax = driver.findElement(By.xpath("//*[@data-hotelid][1]//div[contains(@class,'bui-price-display__value prco-inline-block-maker-helper')]"));
        String minPriceFromMax = MinFromMax.getText().replaceAll("[^0-9]+", "");
        int hotelPerNight = Integer.parseInt(minPriceFromMax) / 7;
        System.out.println("Minimum price per night from " + hotelPerNight);

        assert hotelPerNight >= budgetDay : "Something wrong";
        //driver.close();
        //driver.quit();
    }
}