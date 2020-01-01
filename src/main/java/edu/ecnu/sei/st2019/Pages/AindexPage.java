package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AindexPage extends  BasePage {
    public AindexPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public AindexPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }
    public  AindexPage changeMenu(String menu){
        driver.findElement(By.cssSelector(menu)).click();
        return this;
    }
    public AindexPage putWin(String win){
        super.putWin(win);
        return this;
    }
    public AindexPage checkUrl(String url){
        assertThat(driver.getCurrentUrl(), is(url));
        return this;
    }
    public AindexPage goAdminIndexPage(){
        driver.get("http://localhost:8080/AdminIndex");
        assertThat(driver.getTitle(), is("meetHere"));
        return this;
    }
}
