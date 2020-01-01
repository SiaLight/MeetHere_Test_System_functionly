package edu.ecnu.sei.st2019;

import edu.ecnu.sei.st2019.Pages.AindexPage;
import edu.ecnu.sei.st2019.Pages.BasePage;
import edu.ecnu.sei.st2019.Pages.CheckCommentsPage;
import edu.ecnu.sei.st2019.Pages.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class CheckCommentsTest extends BaseTest{
    BasePage basePage = new BasePage();
    AindexPage aindexPage = new AindexPage();
    CheckCommentsPage checkCommentsPage=new CheckCommentsPage();
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
    //查看未审核留言并予以通过
    @Test
    public void list_unaudited_comment_and_choose_pass() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(6)")
                .putWin("win2")
                .putHandler("checkUnauditComment")
                .switchToWin("win2");
        checkCommentsPage.checkUrl("http://localhost:8080/AdminIndex/checkReply")
                .changeIndex(".is-active:nth-child(1)")
                .choosePass(".el-button--small:nth-child(1)")
                .confirm(".el-button--default:nth-child(2) > span")
                .changeIndex(".el-menu-demo > .el-menu-item:nth-child(2)")
                .changeIndex(".is-active:nth-child(2)");
        basePage.closePage("win2");

    }
    //查看未审核留言并予以删除
    @Test
    public void list_unaudited_comment_and_choose_not_pass() throws InterruptedException {
        aindexPage.changeMenu(".el-menu-item:nth-child(3)")
                .changeMenu(".el-menu-item:nth-child(6)")
                .putWin("win3")
                .putHandler("checkUnauditComment")
                .switchToWin("win3");
        checkCommentsPage.checkUrl("http://localhost:8080/AdminIndex/checkReply")
                .changeIndex(".is-active:nth-child(1)")
                .chooseNotPass(".el-button--danger")
                .confirm(".el-button--default:nth-child(2)")
                .changeIndex(".el-menu-demo > .el-menu-item:nth-child(3)");
        basePage.closePage("win3");
    }
    //查看已通过留言
    @Test
    public void list_passed_comment() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-demo > .el-menu-item:nth-child(6)")
                .putWin("win4")
                .putHandler("checkPassedComments")
                .switchToWin("win4");
        checkCommentsPage.checkUrl("http://localhost:8080/AdminIndex/checkReply")
                .changeIndex(".el-menu-demo > .el-menu-item:nth-child(2)")
                .checkValue(".el-table__row--striped > .el-table_1_column_5 > .cell","已发布");
        basePage.closePage("win4");

    }
    //查看被忽略留言
    @Test
    public void list_not_passed_comment() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(6)")
                .putWin("win5")
                .putHandler("checkNotPassedComments")
                .switchToWin("win5");
        checkCommentsPage.checkUrl("http://localhost:8080/AdminIndex/checkReply")
                .changeIndex(".el-menu-demo > .el-menu-item:nth-child(3)")
                .checkValue(".el-table__row--striped > .el-table_1_column_5 > .cell","已忽略");
        basePage.closePage("win5");

    }

}
