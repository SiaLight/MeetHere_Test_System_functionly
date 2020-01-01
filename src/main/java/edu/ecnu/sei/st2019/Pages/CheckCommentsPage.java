package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckCommentsPage extends BasePage {
    public CheckCommentsPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public CheckCommentsPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }
    public CheckCommentsPage changeMenu(String menu){
        driver.findElement(By.cssSelector(menu)).click();
        return this;
    }
    public CheckCommentsPage putWin(String win){
        super.putWin(win);
        return this;
    }
    public CheckCommentsPage checkUrl(String url){
        assertThat(driver.getCurrentUrl(), is(url));
        return this;
    }
    public CheckCommentsPage changeIndex(String index) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(index)).click();
        return this;
    }
    public CheckCommentsPage choosePass(String button) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(button)).click();
        return this;
    }
    public CheckCommentsPage confirm(String confirm){
        driver.findElement(By.cssSelector(confirm)).click();
        return this;
    }
    public CheckCommentsPage chooseNotPass(String button) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(button)).click();
        return this;
    }
    public void checkValue(String cell,String value){
        assertThat(driver.findElement(By.cssSelector(cell)).getText(), is(value));
    }
}
