package com.novatec;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NovatecTest {

    private static final String MAIN_PAGE_URL = "https://www.novatec-gmbh.de";

    private static final String ACCEPT_COOKIE_BUTTON_XPATH = "//*[@id=\"site\"]/dialog/div/div[5]/button[1]";

    private static final String MENU_TOGGLE_XPATH = "//*[@id=\"site-header\"]/div/div[1]";

    private static final String CAREER_LINK_XPATH = "//*[@id=\"site-header\"]/div/div[2]/ul[2]/li[4]/a";

    private static final String CAREER_DECLINE_COOKIE_BUTTON_XPATH = "//*[@id=\"ccm-widget\"]/div/div[2]/div[3]/button[2]";

    private static final String JOB_LIST_XPATH = "//*[@data-role=\"list\"]";

    private static final String JOB_ITEM_XPATH = "//*[@data-role=\"job-item\"]";

    private static final String APPLY_BUTTON_TEXT = "Jetzt bewerben";

    private static WebDriver webDriver;

    @BeforeClass
    public static void beforeClass(){
        webDriver = new ChromeDriver();
    }

    @AfterClass
    public static void afterClass(){
        webDriver.close();
    }

    @Test
    public void applyButtonIsClickable() throws InterruptedException {
        openMainPage();

        openMenu();

        openCareerPage();

        clickOnVacancy();

        clickApplyButton();
    }

    private static void openMainPage() throws InterruptedException {
        webDriver.get(MAIN_PAGE_URL);

        clickAndCloseElementByXpath(ACCEPT_COOKIE_BUTTON_XPATH, "Accept cookie button");
    }

    private static void openMenu() throws InterruptedException {
        clickOnElementByXpath(MENU_TOGGLE_XPATH, "Menu");
    }

    private static void openCareerPage() throws InterruptedException {
        clickOnElementByXpath(CAREER_LINK_XPATH, "Career link");

        clickAndCloseElementByXpath(CAREER_DECLINE_COOKIE_BUTTON_XPATH, "Decline Cookie Button");
    }

    private static void clickOnVacancy() throws InterruptedException {
        WebElement jobList = webDriver.findElement(By.xpath(JOB_LIST_XPATH));

        assertTrue(jobList.isDisplayed());

        new Actions(webDriver).moveToElement(jobList).perform();

        Thread.sleep(5 * 1000);

        clickOnElementByXpath(JOB_ITEM_XPATH, "Job item");
    }

    private static void clickApplyButton() throws InterruptedException {
        WebElement applyButton = webDriver.findElement(By.linkText(APPLY_BUTTON_TEXT));

        assertTrue(applyButton.isDisplayed());

        applyButton.click();

        Thread.sleep(1000);

        assertFalse(applyButton.isDisplayed());
    }

    private static void clickOnElementByXpath(String xpath, String elementDescription) throws InterruptedException {
        WebElement element = webDriver.findElement(By.xpath(xpath));

        assertTrue(elementDescription + " is not visible", element.isDisplayed());

        element.click();

        Thread.sleep(1000);
    }

    private static void clickAndCloseElementByXpath(String xpath, String elementDescription) throws InterruptedException {
        WebElement element = webDriver.findElement(By.xpath(xpath));

        assertTrue(elementDescription + " is not visible", element.isDisplayed());

        element.click();

        Thread.sleep(1000);

        assertFalse(elementDescription + " is still visible", element.isDisplayed());
    }
}
