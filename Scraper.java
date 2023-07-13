import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scraper {
    public static void main(String[] args) {
    	
    	//String proxy = "137.184.232.148:80";
        //chromeOptions.addArguments("--proxy-server=" + proxy);   
    	//only necessary if you want to route your web traffic through a proxy server
    	
        System.setProperty("webdriver.chrome.driver", "ADD CHROMEDRIVER PATH HERE");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://lirarate.org");

        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for a maximum of 10 seconds
        WebElement buyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("latest-buy")));
        WebElement sellElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("latest-sell")));
        System.out.println(buyElement.getText());
        System.out.println(sellElement.getText());

        driver.quit();
    }
}