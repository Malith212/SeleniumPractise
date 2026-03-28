package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class StaticDropdown {

    public void openGoogle() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        WebElement staticDropdown = driver.findElement(By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency']"));

        Select dropdown = new Select(staticDropdown);

        dropdown.selectByIndex(2);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        driver.quit();
    }
}