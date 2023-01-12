package com.novatec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

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

    public void scrollDownToTheJobList() throws InterruptedException {
        WebElement jobList = webDriver.findElement(By.xpath(JOB_LIST_XPATH));

        assertTrue(jobList.isDisplayed());

        new Actions(webDriver).moveToElement(jobList).perform();

        Thread.sleep(5 * 1000);
    }

    public JobPage clickOnTheFirstJobItem() throws InterruptedException {
        WebElement element = webDriver.findElement(By.xpath(JOB_ITEM_XPATH));

        element.click();

        Thread.sleep(1000);

        return new JobPage(webDriver);
    }
}
