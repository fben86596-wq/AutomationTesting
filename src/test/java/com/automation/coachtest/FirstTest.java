package com.automation.coachtest;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;	
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

    private WebDriver driver;

    @AfterMethod(alwaysRun = true)
    void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void pricingPageOpensFromHomePage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        // Step 1: Open Home Page
        driver.get("https://dev.coachverge.com/");

        // Step 2: Click Pricing
        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/pricing']")
            )
        ).click();

        // Step 3: Verify Pricing page opened
        wait.until(
            ExpectedConditions.urlContains("/pricing")
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/pricing"),
                "Pricing page should open after clicking the Pricing link"
        );
    }
}
