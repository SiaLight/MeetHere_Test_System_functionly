package edu.ecnu.sei.st2019.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserManagementPage extends BasePage{
    public UserManagementPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public UserManagementPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }
    public UserManagementPage putWin(String win){
        super.putWin(win);
        return this;
    }
    public UserManagementPage checkUrl(String url){
        assertThat(driver.getCurrentUrl(), is(url));
        return this;
    }
    public UserManagementPage clickUpdate(String button){
        driver.findElement(By.cssSelector(button)).click();
        return this;
    }

    public void confirmUpdate() throws InterruptedException, AWTException {
        Thread.sleep(2000);
        // assertThat(driver.switchTo().alert().getText(), is("此操作将升级用户权限为管理员, 是否继续?"));
        // driver.switchTo().alert().dismiss();这种写法会在控制台报NoAlertPresentException: no alert open错误
        Robot robot = new Robot();//在基本屏幕坐标系中构造一个 Robot 对象
        robot.keyPress(KeyEvent.VK_SPACE);//按下给定的键
        robot.keyRelease(KeyEvent.VK_SPACE);//释放该键
    }
//    public UserManagementPage cancelUpdate(){
//      assertThat(driver.switchTo().alert().getText(), is("此操作将升级用户权限为管理员, 是否继续?"));
//      driver.switchTo().alert().dismiss();
//        return this;
//    }
    public UserManagementPage clickDelete(String delbutton){
        driver.findElement(By.cssSelector(delbutton)).click();
        return this;
    }
    public void confirmDelete() throws InterruptedException, AWTException {
        Thread.sleep(2000);
//        assertThat(driver.switchTo().alert().getText(), is("此操作将永久删除该用户, 是否继续?"));
//        driver.switchTo().alert().accept();
//        return this;
        Robot robot = new Robot();//在基本屏幕坐标系中构造一个 Robot 对象
        robot.keyPress(KeyEvent.VK_SPACE);//按下给定的键
        robot.keyRelease(KeyEvent.VK_SPACE);//释放该键
    }
//    public UserManagementPage cancelDelete(){
//        assertThat(driver.switchTo().alert().getText(), is("此操作将永久删除该用户, 是否继续?"));
//        driver.switchTo().alert().dismiss();
//        return this;
//    }

}
