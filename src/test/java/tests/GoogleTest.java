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

        String password=getPassword(driver);

        System.out.println(password);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys(name);

        driver.findElement(By.name("inputPassword")).sendKeys(password);

        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

        System.out.println(driver.findElement(By.xpath("//h2")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Hello "+name+",");

        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        Thread.sleep(2000);

    }

    public String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
        Thread.sleep(2000);

        String passwordText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
        System.out.println(passwordText);

        String password = passwordText.split("'")[1].split("'")[0];


        System.out.println(password);
        return password;
    }

}