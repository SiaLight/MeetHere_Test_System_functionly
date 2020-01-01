package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IndexPage extends  BasePage {
    public IndexPage verifyTitle(String title ){
        assertThat(driver.getTitle(), is(title));
        return this;
    }
    public IndexPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public IndexPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }

    public IndexPage putWin(String win){
        super.putWin(win);
        return this;
    }

    public  IndexPage changeMenu(String menu){
        driver.findElement(By.cssSelector(menu)).click();
        return this;
    }

    public IndexPage assertUrl(String url){

        assertThat(driver.getCurrentUrl(),is(url));
        return this;
    }

    public IndexPage goUserIndexPage(){
        driver.get("http://localhost:8080/index");
        assertThat(driver.getTitle(), is("meetHere"));
        return this;
    }

    public  IndexPage clickText(String text){
        driver.findElement(By.linkText(text)).click();
        return this;
    }
}
