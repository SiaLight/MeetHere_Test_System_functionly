package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static edu.ecnu.sei.st2019.DriverSingleton.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchPage extends BasePage {


    public SearchPage searchNotice(String keywords) {

        driver.findElement(By.id("go-search")).click();
        driver.findElement(By.name("keyword")).click();
        driver.findElement(By.name("keyword")).sendKeys(keywords);
        return this;
    }

    public SearchPage clickSearch(){
        driver.findElement(By.cssSelector(".search")).click();
        return this;
    }

    public SearchPage verifyTitle(String title ){
        assertThat(driver.getTitle(), is(title));
        return this;
    }

    public SearchPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public SearchPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }

    public SearchPage putWin(String win){
        super.putWin(win);
        return this;
    }
 }
