package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LivelyRootSearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Launch Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.livelyroot.com/");
    }

    @Test
    public void searchValidProduct() throws InterruptedException {
        // Click on search input
        WebElement searchBox = driver.findElement(By.cssSelector("input[type='search']"));
        searchBox.sendKeys("Air Plants");
        searchBox.submit();

        Thread.sleep(3000); // wait for results to load

        // Verify results
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Air Plant"), "Search results do not contain expected product.");
    }

    @Test
    public void searchInvalidProduct() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.cssSelector("input[type='search']"));
        searchBox.sendKeys("Laptop");
        searchBox.submit();

        Thread.sleep(3000);

        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("No products") || pageSource.contains("0 results"),
                "Invalid search did not show correct message.");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
