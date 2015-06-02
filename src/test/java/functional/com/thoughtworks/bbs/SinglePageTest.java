package functional.com.thoughtworks.bbs;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class SinglePageTest {

    private static WebDriver driver;
    private static final String host = "http://localhost:8080/bbs_team_b";

    @BeforeClass
    public static void classInit() {
        driver = new FirefoxDriver();
    }

    @Test
    public void shouldOpenHomePage() {
        driver.get(host);
        WebElement element = driver.findElement(By.className("brand"));
        assertEquals(element.getText(), "ThoughtWorks BBS");
    }

    @Test
    public void shouldLogInwithAccount() {
        driver.get(host);
        WebElement element = driver.findElement(By.tagName("button"));
        assertEquals(element.getText(), "Search");
        element.click();
        driver.findElement(By.name("j_username")).sendKeys("huan");
        driver.findElement(By.name("j_password")).sendKeys("123456");
        driver.findElement(By.className("btn")).submit();
//        assertEquals(driver.findElements(By.tagName("nav_link")));
    }

    @AfterClass
    public static void tearAfter() {
        driver.close();
    }
}
