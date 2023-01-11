package com.novatec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobPage {

    private static final String APPLY_BUTTON_TEXT = "Jetzt bewerben";

    private final WebDriver webDriver;

    private WebElement applyButton;

    public JobPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void init() {
        applyButton = webDriver.findElement(By.linkText(APPLY_BUTTON_TEXT));
    }

    public void clickApplyButton() throws InterruptedException {
        applyButton.click();

        Thread.sleep(1000);
    }

    public boolean isDisplayedApplyButton() {
        return applyButton.isDisplayed();
    }
}
