package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class StaticDropdown {

    public static void main(String[] args) {
        StaticDropdown obj = new StaticDropdown();
        obj.openGoogle();
    }

    public void openGoogle() {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize window
            driver.manage().window().maximize();

            // Implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // Open URL
            driver.get("https://rahulshettyacademy.com/locatorspractice/");

            // Locate dropdown
            WebElement staticDropdown = driver.findElement(
                    By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency']")
            );

            // Select dropdown
            Select dropdown = new Select(staticDropdown);

            // Select by index
            dropdown.selectByIndex(2);
            System.out.println("Selected by index: " +
                    dropdown.getFirstSelectedOption().getText());

            // Select by value
            dropdown.selectByValue("INR");
            System.out.println("Selected by value: " +
                    dropdown.getFirstSelectedOption().getText());

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
//test 1247231