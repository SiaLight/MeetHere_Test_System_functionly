package edu.ecnu.sei.st2019;

import edu.ecnu.sei.st2019.Pages.*;
import org.junit.Test;

public class UserOrderTest extends BaseTest {

    BasePage basePage = new BasePage();
    IndexPage indexPage = new IndexPage();
    LoginPage loginPage = new LoginPage();
    UserOrderPage userOrderPage = new UserOrderPage();

    @Test

    public  void should_delete_unchecked_order_successful_when_click_cancel(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zh")
                .inputPassword("123456")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win1")
                .putHandler("order")
                .switchToWin("win1");

        userOrderPage.assertUrl("http://localhost:8080/index/appointment")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(2)")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(1)")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(2)")
                .clickSelector(".el-table__row:nth-child(1) span")
                .checkAlert("取消成功")
                .closePage("win1");

    }

    @Test
    public  void should_delete_have_checked_order_successful_when_click_cancel(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zh")
                .inputPassword("123456")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win1")
                .putHandler("order")
                .switchToWin("win1");

        userOrderPage.assertUrl("http://localhost:8080/index/appointment")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(2)")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(1)")
                .clickSelector(".el-table__row:nth-child(1) span")
                .checkAlert("取消成功")
                .closePage("win1");
    }

    @Test
    public  void should_change_unchecked_order_successful_when_click_OK(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zh")
                .inputPassword("123456")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win1")
                .putHandler("order")
                .switchToWin("win1");

        userOrderPage.assertUrl("http://localhost:8080/index/appointment")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(2)")
                .clickSelector(".el-table__row:nth-child(1) .el-icon")
                .clickSelector(".el-date-editor > #start")
                .clickSelector(".el-date-picker__editor-wrap:nth-child(2) .el-input__inner")
                .clickSelector(".el-time-spinner__wrapper:nth-child(1) .el-time-spinner__item:nth-child(10)")
                .clickSelector(".confirm")
                .clickSelector(".el-picker-panel__footer")
                .clickSelector(".el-button--default > span")
               .clickSelector("#finishTime .el-input__inner")
                .input("#finishTime .el-input__inner","2019-12-31 12:00:00")
                .clickSelector(".el-col:nth-child(1) .el-button > span")
                .checkAlert("修改成功")
                .closePage("win1");
    }
    @Test
    public  void should_change_checked_order_successful_when_click_OK(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zh")
                .inputPassword("123456")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win1")
                .putHandler("order")
                .switchToWin("win1");

        userOrderPage.assertUrl("http://localhost:8080/index/appointment")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(2)")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(1)")
                .clickSelector(".el-table__row:nth-child(1) .el-icon")
                .clickSelector(".el-date-editor > #start")
                .clickSelector(".el-date-picker__editor-wrap:nth-child(2) .el-input__inner")
                .clickSelector(".el-time-spinner__wrapper:nth-child(1) .el-time-spinner__item:nth-child(10)")
                .clickSelector(".confirm")
                .clickSelector(".el-picker-panel__footer")
                .clickSelector(".el-button--default > span")
                .clickSelector("#finishTime .el-input__inner")
                .input("#finishTime .el-input__inner","2019-12-03 12:00:00")
                .clickSelector(".el-col:nth-child(1) .el-button > span")
                .checkAlert("修改成功")
                .closePage("win1");
    }
    @Test
    public  void should_change_unchecked_order_failed_when_click_OK(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zh")
                .inputPassword("123456")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win1")
                .putHandler("order")
                .switchToWin("win1");

        userOrderPage.assertUrl("http://localhost:8080/index/appointment")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(2)")
                .clickSelector(".el-table__row:nth-child(1) .el-icon")
                .clickSelector(".el-date-editor > #start")
                .input(".el-date-editor > #start","2019-12-31 13:00:00")
                .clickSelector("#finishTime .el-input__inner")
                .input("#finishTime .el-input__inner","2019-12-31 15:00:00")
                .clickSelector(".el-col:nth-child(1) .el-button > span")
                .checkAlert("修改失败")
                .closePage("win1");
    }

    @Test
    public  void should_change_checked_order_failed_when_click_OK(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zh")
                .inputPassword("123456")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win1")
                .putHandler("order")
                .switchToWin("win1");

        userOrderPage.assertUrl("http://localhost:8080/index/appointment")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(2)")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(1)")
                .clickSelector(".el-table__row:nth-child(1) .el-icon")
                .clickSelector(".el-date-editor > #start")
                .input(".el-date-editor > #start","2019-12-31 13:00:00")
                .clickSelector("#finishTime .el-input__inner")
                .input("#finishTime .el-input__inner","2019-12-31 15:00:00")
                .clickSelector(".el-col:nth-child(1) .el-button > span")
                .checkAlert("修改失败")
                .closePage("win1");
    }

    @Test
    public  void should_cancel_change_unchecked_order_failed_when_click_cancel(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zh")
                .inputPassword("123456")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win1")
                .putHandler("order")
                .switchToWin("win1");

        userOrderPage.assertUrl("http://localhost:8080/index/appointment")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(2)")
                .clickSelector(".el-table__row:nth-child(1) .el-icon")
                .clickSelector(".el-date-editor > #start")
                .input(".el-date-editor > #start","2019-12-31 13:00:00")
                .clickSelector("#finishTime .el-input__inner")
                .input("#finishTime .el-input__inner","2019-12-31 15:00:00")
                .clickSelector(".el-col:nth-child(2) .el-button")
                .closePage("win1");
    }
    @Test
    public  void should_cancel_change_checked_order_failed_when_click_cancel(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zh")
                .inputPassword("123456")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win1")
                .putHandler("order")
                .switchToWin("win1");

        userOrderPage.assertUrl("http://localhost:8080/index/appointment")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(2)")
                .clickSelector(".el-menu-demo > .el-menu-item:nth-child(1)")
                .clickSelector(".el-table__row:nth-child(1) .el-icon")
                .clickSelector(".el-date-editor > #start")
                .input(".el-date-editor > #start","2019-12-31 13:00:00")
                .clickSelector("#finishTime .el-input__inner")
                .input("#finishTime .el-input__inner","2019-12-31 15:00:00")
                .clickSelector(".el-col:nth-child(2) .el-button")
                .closePage("win1");
    }

}
