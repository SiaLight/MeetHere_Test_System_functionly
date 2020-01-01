package edu.ecnu.sei.st2019;

import edu.ecnu.sei.st2019.Pages.AindexPage;
import edu.ecnu.sei.st2019.Pages.BasePage;
import edu.ecnu.sei.st2019.Pages.LoginPage;
import edu.ecnu.sei.st2019.Pages.OrderCountPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class OrderCountTest extends BaseTest {
    BasePage basePage = new BasePage();
    AindexPage aindexPage = new AindexPage();
    OrderCountPage ordersCountPage = new OrderCountPage();
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

    //根据输入内容搜索带此关键字的相应订单
    @Test
    public void search_Orders_by_any_key(){
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win2")
                .putHandler("orderCount")
                .switchToWin("win2");
        ordersCountPage.checkUrl("http://localhost:8080/AdminIndex/ordersCount")
                .searchPassedOrderByKey("中北健身馆");
        basePage.closePage("win2");
    }
}
