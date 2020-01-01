package edu.ecnu.sei.st2019;
import edu.ecnu.sei.st2019.Pages.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;


public class userManagementTest extends BaseTest{
    BasePage basePage = new BasePage();
    LoginPage loginPage=new LoginPage();
    AindexPage aindexPage = new AindexPage();
    UserManagementPage userManagementPage=new UserManagementPage();

    @Before
    public void login(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("li")
                .inputPassword("123")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        aindexPage.checkUrl("http://localhost:8080/AdminIndex");
    }

    //测试升级用户权限，遇到弹框请自主点击确定取消按钮，原因请查看userManagementPage的注释
    @Test
    public void update_user_permission_to_admin_and_confirm_when_alert() throws InterruptedException, AWTException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(1)")
                .putWin("win2")
                .putHandler("userManagement")
                .switchToWin("win2");

        userManagementPage.checkUrl("http://localhost:8080/AdminIndex/userManagement")
                .clickUpdate(".el-table__row:nth-child(3) span > span")
                .confirmUpdate();
        basePage.closePage("win2");
    }


    //测试删除用户,遇到弹框请自主点击确定/取消按钮，原因请查看userManagementPage的注释
    @Test
    public void delete_user_and_confirm_when_alert() throws AWTException, InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(1)")
                .putWin("win3")
                .putHandler("userManagement")
                .switchToWin("win3");
        userManagementPage.checkUrl("http://localhost:8080/AdminIndex/userManagement")
                .clickDelete(".el-table__row:nth-child(4) .el-button--danger > span")
                .confirmDelete();
        basePage.closePage("win3");
    }

}
