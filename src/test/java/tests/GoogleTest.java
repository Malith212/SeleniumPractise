package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.time.Duration;
import org.testng.Assert;

public class GoogleTest {

    @Test
    public void openGoogle() throws InterruptedException {

        String name="Rahul";

        WebDriverManager.chromedriver().setup(); // setup driver

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys(name);

        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");

        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

        System.out.println(driver.findElement(By.xpath("//h2")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Hello "+name+",");

        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        Thread.sleep(2000);

    }
}