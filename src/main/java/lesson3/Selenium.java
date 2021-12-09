package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 1.Авторизация на сайте https://diary.ru/user/login
        driver.get("https://diary.ru/user/login");
        driver.findElement(By.id("loginform-username")).sendKeys("iTesti");
        driver.findElement(By.id("loginform-password")).sendKeys("Test111");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        driver.switchTo().parentFrame();
        Thread.sleep(10000);
        //driver.findElement(By.id("login_btn")).click();


        // 2.Создание новой записи
        Cookie cookie=new Cookie("_identity_","b57280e76b4977d2534bc59f08d418635aec21bd73fe2c0971049c44511fce4da%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3560430%2C%22YkO0r_h9R0JHzIwt5cbqax-UbfC8So-f%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@title='Новая запись']")).click();
        driver.findElement(By.id("postTitle")).sendKeys("TestPage");
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("Testovoe message");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("rewrite")).click();



        // 3. Добавить папку в сообщениях
        driver.navigate().refresh();
        driver.findElement(By.xpath("//span[@class=\"i-letter\"]")).click();
        driver.findElement(By.xpath("//a[@class=\"umail_folders\"]")).click();
        driver.findElement(By.id("folder-name")).sendKeys("newFolder");
        driver.findElement(By.xpath("//button[@class=\"tn btn-primary btn-lg\"]")).click();
        Thread.sleep(10000);
        driver.quit();

    }





}
