package edu.ecnu.sei.st2019;

import edu.ecnu.sei.st2019.Pages.AindexPage;
import edu.ecnu.sei.st2019.Pages.BasePage;
import edu.ecnu.sei.st2019.Pages.CheckOrderPage;
import edu.ecnu.sei.st2019.Pages.LoginPage;
import org.junit.Before;
import org.junit.Test;


public class CheckOrderTest extends BaseTest {
    BasePage basePage = new BasePage();
    AindexPage aindexPage = new AindexPage();
    CheckOrderPage checkOrderPage = new CheckOrderPage();
    LoginPage loginPage=new LoginPage();


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
    //查看未审核订单并尝试通过，遇到确认框弹出默认确定，并查看已通过订单里是否存在
    @Test
    public void list_unaudited_order_and_choose_pass() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(3)")
                .putWin("win2")
                .putHandler("checkUnauditOrder")
                .switchToWin("win2");
        checkOrderPage.checkUrl("http://localhost:8080/AdminIndex/checkOrder")
                .changeIndex(".is-active:nth-child(1)")
                .choosePass(".el-button--small:nth-child(1)")
                .confirm(".el-button--default:nth-child(2)")
                .changeIndex(".el-menu-demo > .el-menu-item:nth-child(2)");
        basePage.closePage("win2");
    }
    //查看未审核订单并尝试不通过，遇到确认框默认确定，并查看未被通过订单里是否存在
    @Test
    public void list_unaudited_order_and_choose_not_pass() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(3)")
                .putWin("win2")
                .putHandler("checkUnauditOrder")
                .switchToWin("win2");
        checkOrderPage.checkUrl("http://localhost:8080/AdminIndex/checkOrder")
                .changeIndex(".is-active:nth-child(1)")
                .chooseNotPass(".el-button--small:nth-child(2)")
                .confirm(".el-button--default:nth-child(2)")
                .changeIndex(".el-menu-demo > .el-menu-item:nth-child(3)");
        basePage.closePage("win2");
    }
    //查看已通过订单
    @Test
    public void list_passed_order() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(3)")
                .putWin("win2")
                .putHandler("checkPassedOrder")
                .switchToWin("win2");
        checkOrderPage.checkUrl("http://localhost:8080/AdminIndex/checkOrder")
                .changeIndex(".el-menu-demo > .el-menu-item:nth-child(2)")
                .checkValue(".el-table__row--striped > .el-table_1_column_8 > .cell","通过");
        basePage.closePage("win2");
    }
    //查看未被通过订单
    @Test
    public void list_not_passed_order() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(3)")
                .putWin("win2")
                .putHandler("checkPassedOrder")
                .switchToWin("win2");
        checkOrderPage.checkUrl("http://localhost:8080/AdminIndex/checkOrder")
                .changeIndex(".el-menu-demo > .el-menu-item:nth-child(3)")
                .checkValue(".el-table__row:nth-child(1) > .el-table_1_column_8 > .cell","不通过");
        basePage.closePage("win2");
    }
    //查看被用户取消的订单
    @Test
    public void list_canceled_order() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(3)")
                .putWin("win2")
                .putHandler("checkPassedOrder")
                .switchToWin("win2");
        checkOrderPage.checkUrl("http://localhost:8080/AdminIndex/checkOrder")
                .changeIndex(".el-menu-demo > .el-menu-item:nth-child(4)")
                .checkValue(".el-table__row > .el-table_1_column_8 > .cell","已取消");
        basePage.closePage("win2");
    }
}
