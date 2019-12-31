package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static edu.ecnu.sei.st2019.DriverSingleton.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchResultPage extends BasePage{

    public SearchResultPage showNotice(String index){
        driver.findElement(By.cssSelector(".result_item:nth-child("+ index+ ") > .item_title div")).click();
        return this;
    }

    public SearchResultPage verifyTitle(String title ){
        assertThat(driver.getTitle(), is(title));
        return this;
    }

    public SearchResultPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public SearchResultPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }

    public SearchResultPage putWin(String win){
        super.putWin(win);
        return this;
    }

}
