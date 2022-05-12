package com.nuffieldhealth.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class HomePage {

    WebDriver driver ;
    WebDriverWait wait;
    JavascriptExecutor jse;

    String url = "https://www.nuffieldhealth.com/gyms";

    @FindBy(id = "location-finder__input-00000160-4eeb-de17-a579-dffb7ab70000")
    private WebElement weSearchTextbox;

//    @FindBy(xpath = "(.//li[@class='grid__cell'])[2]")
    //@FindBy(xpath = "(.//div[@class='location-finder__address'])[1]")
    @FindBy(xpath = "(.//div[@class='location-finder__address'])[1]/p/span")
    private WebElement weFirstGymAddress;

    //@FindBy(id = "ccc-notify-accept")
    //@FindBy(xpath = ".//button[@id='ccc-notify-accept']/span")
    //private WebElement weAcceptCookiesBtn;

    @FindBy(xpath = ".//span[contains(text(),'Accept cookies')]")
    private WebElement weAcceptCookiesBtn;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        jse = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.navigate().to(url);
        try {
            jse.executeScript("return document.readyState").equals("complete");
            wait.until(ExpectedConditions.visibilityOf(weAcceptCookiesBtn)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchZipCode(String zipcode) {
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS );
        wait.until(ExpectedConditions.visibilityOf(weSearchTextbox));
        weSearchTextbox.click();
        //Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS );
        enterText(zipcode);
        //Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS );
        weSearchTextbox.sendKeys(Keys.DOWN);
        weSearchTextbox.sendKeys(Keys.ENTER);
    }

    public void getTheNearestGymAddress() {
        try {
            wait.until(ExpectedConditions.visibilityOf(weFirstGymAddress));
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(driver, this);
            wait.until(ExpectedConditions.visibilityOf(weFirstGymAddress));
        }
        Assert.assertEquals(weFirstGymAddress.getText(), "One Cabot Square");
        System.out.println(weFirstGymAddress.getText());;
    }

    public void enterText(String text) {
        char[] character = text.toCharArray();
        int counter = character.length;
        for (int i = 0; i < counter; i++) {
            weSearchTextbox.sendKeys(Character.toString(character[i]));
            Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
        }
    }

}
