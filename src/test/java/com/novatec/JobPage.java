package com.novatec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobPage {

    private static final String APPLY_BUTTON_TEXT = "Jetzt bewerben";

    private final WebDriver webDriver;

    private WebElement applyButton;

    public JobPage(WebDriver webDriver) {
        this.webDriver = webDriver;

        init();
    }

    public void clickApplyJobButton() {
        applyButton.click();

        WebDriverWait wt = new WebDriverWait(webDriver, Duration.ofSeconds(1));

        wt.until(ExpectedConditions.invisibilityOf(applyButton));
    }

    public boolean isDisplayedApplyButton() {
        return applyButton.isDisplayed();
    }

    private void init() {
        WebDriverWait wt = new WebDriverWait(webDriver, Duration.ofSeconds(1));

        wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(APPLY_BUTTON_TEXT)));

        applyButton = webDriver.findElement(By.linkText(APPLY_BUTTON_TEXT));
    }
}
