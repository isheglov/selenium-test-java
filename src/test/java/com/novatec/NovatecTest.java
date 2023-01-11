package com.novatec;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;

public class NovatecTest {

    private static WebDriver webDriver;

    private static MainPage mainPage;

    private static CareerPage careerPage;

    private static JobPage jobPage;

    @BeforeClass
    public static void beforeClass(){
        webDriver = new ChromeDriver();
        mainPage = new MainPage(webDriver);
        careerPage = new CareerPage(webDriver);
        jobPage = new JobPage(webDriver);
    }

    @AfterClass
    public static void afterClass(){
        webDriver.close();
    }

    @Test
    public void applyButtonIsClickable() throws InterruptedException {
        mainPage.open();

        mainPage.acceptCookies();

        mainPage.openMenu();

        mainPage.clickCareerLink();

        careerPage.declineCookies();

        careerPage.scrollDownToTheJobList();

        careerPage.clickOnTheFirstJobItem();

        jobPage.init();

        jobPage.clickApplyButton();

        assertFalse("Apply button is still displayed", jobPage.isDisplayedApplyButton());
    }
}
