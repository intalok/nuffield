package com.nuffieldhealth.stepdef;

import com.nuffieldhealth.pages.HomePage;
import cucumber.api.java8.En;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomePageStepDef implements En {

    WebDriver driver;
    HomePage homePage;

    public HomePageStepDef() {


        Given("^Open chrome browser$", () -> {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-logging");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            homePage = new HomePage(driver);
        });

        When("^open the nuffield health url$", () -> {
            homePage.openHomePage();
        });

        Then("enter the zipcode {string}", (String zipcode) -> {
            homePage.searchZipCode(zipcode);
        });

        Then("^verify the nearest gym address$", () -> {
            homePage.getTheNearestGymAddress();
        });
        

    }
}
