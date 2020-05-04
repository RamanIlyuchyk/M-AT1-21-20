import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Weather {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        //driver.navigate().to("http://ya.ru");
        //driver.navigate().back();
        //driver.navigate().refresh();
        //System.out.println("Title: " + driver.getTitle());
        //System.out.println("URL: " + driver.getCurrentUrl());
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Погода Минск");
        //input.submit();
        WebElement aside = driver.findElement(By.xpath("//div[@id='lga']"));
        aside.click();
        WebElement search = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[contains(@value,'Google')]")); //version #1
        //WebElement search = driver.findElement(By.cssSelector(".FPdoLc.tfB0Bf input[name='btnK']")); //version #2
        search.click();
        WebElement buttonForTomorrow = driver.findElement(By.xpath("//div[@class='wob_df'][1]"));
        buttonForTomorrow.click();
        String day = driver.findElement(By.xpath("//*[@id='wob_dp']/div[2]/div[@class='vk_lgy']")).getAttribute("aria-label");
        String time = "12:00";
        String scale = "Celsius";
        String info = "//*[contains(@aria-label, '%s %s') and contains(@aria-label, '%s')][1]";
        String weatherForTomorrow = driver.findElement(By.xpath(String.format(info, day, time, scale))).getAttribute("aria-label");
        String MSG = "Tomorrow's forecast at %s is %s%s";
        System.out.print(String.format(MSG, time, weatherForTomorrow.substring(0, weatherForTomorrow.indexOf("C")), scale.substring(0, 1)));
        //driver.close();
        //driver.quit();
    }
}