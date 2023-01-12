package com.novatec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareerPage {

    private static final String CAREER_DECLINE_COOKIE_BUTTON_XPATH = "//*[@id=\"ccm-widget\"]/div/div[2]/div[3]/button[2]";

    private static final String JOB_LIST_XPATH = "//*[@data-role=\"list\"]";

    private static final String JOB_ITEM_XPATH = "//*[@data-role=\"job-item\"]";

    private final WebDriver webDriver;

    public CareerPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void declineCookies() {
        WebElement element = webDriver.findElement(By.xpath(CAREER_DECLINE_COOKIE_BUTTON_XPATH));

        element.click();
    }

    public void scrollDownToTheJobList() {
        WebElement jobList = webDriver.findElement(By.xpath(JOB_LIST_XPATH));

        new Actions(webDriver).moveToElement(jobList).perform();
    }

    public JobPage clickOnTheFirstJobItem() {
        WebDriverWait wt = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JOB_ITEM_XPATH)));

        WebElement element = webDriver.findElement(By.xpath(JOB_ITEM_XPATH));

        element.click();

        return new JobPage(webDriver);
    }
}
