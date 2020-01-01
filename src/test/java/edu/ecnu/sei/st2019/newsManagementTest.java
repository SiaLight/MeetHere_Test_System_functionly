package edu.ecnu.sei.st2019;

import edu.ecnu.sei.st2019.Pages.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class newsManagementTest extends BaseTest{
    BasePage basePage = new BasePage();
    AindexPage aindexPage = new AindexPage();
    NewsManagementPage newsManagementPage= new NewsManagementPage();
    LoginPage loginPage=new LoginPage();
    IndexPage indexPage=new IndexPage();
    seeNewsPage seenews=new seeNewsPage();


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
    //管理员发布新闻，并确认用户端已显示
    @Test
    public void add_news() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(5)")
                .putWin("win2")
                .putHandler("addNews")
                .switchToWin("win2");
        newsManagementPage.checkUrl("http://localhost:8080/AdminIndex/checkNews")
                .addNews(".table-grid-content > .el-button")
                .typeContent(".el-input__inner","xxxxx",".el-textarea__inner","YYYYYYYYYYY")
                .confirm("div:nth-child(2) > .el-button:nth-child(2)")
                .quit(".is-plain > span");

        indexPage.goUserIndexPage()
                .putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(3)")
                .putWin("win3")
                .putHandler("news")
                .switchToWin("win3");

        //newsDetail的Url最后一位number取决于添加测试执行后的新闻总数，请自己调整
        seenews.assertUrl("http://localhost:8080/index/seeNews")
                .clickNews(".timeline:nth-child(1) h4")
                .putWin("win3")
                .putHandler("detail")
                .switchToWin("win3")
//                .assertUrl("http://localhost:8080/index/newsDetail/12")
                .clickNews(".el-page-header__title")
                .putWin("win4")
                .putHandler("news1")
                .switchToWin("win4")
                .assertUrl("http://localhost:8080/index/seeNews");
        basePage.closePage("win4");
    }
    //管理员删除新闻，并确定用户端已删除
    @Test
    public void delete_news() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(5)")
                .putWin("win21")
                .putHandler("deleteNews")
                .switchToWin("win21");
        newsManagementPage.checkUrl("http://localhost:8080/AdminIndex/checkNews")
                .deleteNews(".el-table__row:nth-child(5) .el-button--danger")
                .confirm(".el-button--default:nth-child(2) > span");

        indexPage.goUserIndexPage()
                .putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(3)")
                .putWin("win31")
                .putHandler("news")
                .switchToWin("win31");

        seenews.assertUrl("http://localhost:8080/index/seeNews")
                .clickNews(".timeline:nth-child(1) h4");

        basePage.closePage("win31");
    }
    //管理员删除新闻，并确定客户端已修改
    @Test
    public void edit_news() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(5)")
                .putWin("win22")
                .putHandler("deleteNews")
                .switchToWin("win22");
        newsManagementPage.checkUrl("http://localhost:8080/AdminIndex/checkNews")
                .editNews(".el-table__row:nth-child(3) .el-button--primary > span")
                .typeContent(".el-form-item:nth-child(2) .el-input__inner","bbbbb",".el-textarea__inner","CCCCCC")
                .confirm("div:nth-child(2) > .el-button--primary > span");
        indexPage.goUserIndexPage()
                .putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(3)")
                .putWin("win32")
                .putHandler("news")
                .switchToWin("win32");
        seenews.assertUrl("http://localhost:8080/index/seeNews")
                .clickNews(".timeline:nth-child(1) h4");
        basePage.closePage("win32");
    }
}
