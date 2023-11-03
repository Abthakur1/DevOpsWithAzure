package com.testCasesAbhi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class TestMultipleWindows {

    @Test
    public void tc_01() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://chercher.tech/python/windows-selenium-python.php");
        driver.findElement(By.xpath("//a[@id='two-window']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()) {
            String parent = it.next();
            String child = it.next();
            driver.switchTo().window(child);
            driver.findElement(By.xpath("//a[@aria-label='Gmail (opens a new tab)']")).click();
            driver.close();
            driver.switchTo().window(parent);
        }

        System.out.println(driver.getTitle());
        driver.quit();
    }
}

