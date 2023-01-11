package com.novatec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private static final String MAIN_PAGE_URL = "https://www.novatec-gmbh.de";

    private static final String ACCEPT_COOKIE_BUTTON_XPATH = "//*[@id=\"site\"]/dialog/div/div[5]/button[1]";

    private static final String MENU_TOGGLE_XPATH = "//*[@id=\"site-header\"]/div/div[1]";

    private static final String CAREER_LINK_XPATH = "//*[@id=\"site-header\"]/div/div[2]/ul[2]/li[4]/a";

    private final WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get(MAIN_PAGE_URL);
    }

    public void acceptCookies() {
        WebElement element = webDriver.findElement(By.xpath(ACCEPT_COOKIE_BUTTON_XPATH));

        element.click();
    }

    public void openMenu() throws InterruptedException {
        WebElement element = webDriver.findElement(By.xpath(MENU_TOGGLE_XPATH));

        element.click();

        Thread.sleep(1000);
    }

    public void clickCareerLink() throws InterruptedException {
        WebElement element = webDriver.findElement(By.xpath(CAREER_LINK_XPATH));

        element.click();

        Thread.sleep(1000);
    }
}
