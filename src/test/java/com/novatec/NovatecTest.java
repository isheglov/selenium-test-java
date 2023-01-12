package com.novatec;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;

public class NovatecTest {

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
    public void applyJobButtonIsClickable() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.open();

        mainPage.acceptCookies();

        mainPage.openMenu();

        CareerPage careerPage = mainPage.clickCareerLink();

        careerPage.declineCookies();

        careerPage.scrollDownToTheJobList();

        JobPage jobPage = careerPage.clickOnTheFirstJobItem();

        jobPage.clickApplyJobButton();

        assertFalse("Apply job button is still displayed", jobPage.isDisplayedApplyButton());
    }
}
