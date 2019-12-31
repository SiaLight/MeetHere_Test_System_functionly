package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StadiumPage extends  BasePage {

    public StadiumPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public StadiumPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }

    public StadiumPage putWin(String win){
        super.putWin(win);
        return this;
    }
    public StadiumPage clickStadium(String tag){
        driver.findElement(By.cssSelector(tag)).click();
        return this;

    }

    public  StadiumPage assertUrl(String url){
        assertThat(driver.getCurrentUrl(),is(url));
        return this;

    }


}
