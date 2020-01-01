package edu.ecnu.sei.st2019;

import edu.ecnu.sei.st2019.Pages.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class stadiumManagementTest extends BaseTest{
    BasePage basePage = new BasePage();
    AindexPage aindexPage = new AindexPage();
    StadiumManagementPage stadiumManagementPage=new StadiumManagementPage();
    LoginPage loginPage=new LoginPage();
    IndexPage indexPage=new IndexPage();

    //管理员必须登录才能进行操作
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
//管理员添加场馆
    @Test
    public void add_stadium() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win2")
                .putHandler("addStadium")
                .switchToWin("win2");
        //行数例如10，可以自行修改，添加到第几行就设置为第几行
        stadiumManagementPage.checkUrl("http://localhost:8080/AdminIndex/stadiumManagement")
                .add(".table-grid-address > .el-button")
                .typeContent(".el-input__inner","xxxxx",".el-textarea__inner","YYYYYYYYYYY")
                .confirm(".el-button--primary:nth-child(2)")
//                .checkValue(".el-table__row:nth-child(10) > .el-table_1_column_2 > .cell","xxxxx")
//                .checkValue(".el-table__row:nth-child(10) > .el-table_1_column_3 > .cell","YYYYYYYYYYY")
                .quit(".is-plain");
        basePage.closePage("win2");
    }
//管理员删除场馆
    @Test
    public void delete_stadium() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win3")
                .putHandler("deleteStadium")
                .switchToWin("win3");
        stadiumManagementPage.checkUrl("http://localhost:8080/AdminIndex/stadiumManagement")
                .delete(".el-table__row:nth-child(4) .el-button--danger")
                .confirm(".el-button--default:nth-child(2)")
                .quit(".is-plain");
        basePage.closePage("win3");
    }
    //管理员编辑场馆
    @Test
    public void edit_stadium() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win4")
                .putHandler("deleteStadium")
                .switchToWin("win4");
        stadiumManagementPage.checkUrl("http://localhost:8080/AdminIndex/stadiumManagement")
                .editStadium(".el-table__row:nth-child(4) > .el-table_1_column_5 .el-button--primary > span")
                .typeContent(".el-input__inner","temp",".el-textarea__inner","temp")
                .confirm(".el-button--primary:nth-child(2)")
                .quit(".is-plain");
        basePage.closePage("win4");
    }
    //管理员查看场馆详情，为其添加场地,场地所有信息都不为空
    @Test
    public void check_details_of_stadium() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win4")
                .putHandler("addSite")
                .switchToWin("win4");
        stadiumManagementPage.checkUrl("http://localhost:8080/AdminIndex/stadiumManagement")
                .checkDetail(".el-table__row:nth-child(5) > .el-table_1_column_4 span")
                .add("div:nth-child(2) > .el-button--primary > span")
                .typeContentOneByOne(".el-form-item:nth-child(1) .el-input__inner","乒乓球馆")
                .typeContentOneByOne(".el-form-item:nth-child(2) .el-input__inner","88")
                .typeContentOneByOne(".el-form-item:nth-child(3) .el-input__inner","中山北路")
                .typeContentOneByOne(".el-textarea__inner","靠墙")
                .confirm(".el-button--primary:nth-child(2) > span")
                .confirm(".el-button--default:nth-child(2)");
        basePage.closePage("win4");
    }
    //管理员查看场馆详情，为其删除场地
    @Test
    public void delete_site_of_stadium() throws InterruptedException {
        aindexPage.putHandler("window_handles")
                .changeMenu(".el-menu-item:nth-child(2)")
                .putWin("win5")
                .putHandler("deleteSite")
                .switchToWin("win5");
        stadiumManagementPage.checkUrl("http://localhost:8080/AdminIndex/stadiumManagement")
                .checkDetail(".el-table__row:nth-child(5) > .el-table_1_column_4 span")
                .delete(".el-button--danger:nth-child(1) > span")
                .confirm(".el-button--small:nth-child(2) > span")
                .confirm("div:nth-child(2) > .el-button--default");
        basePage.closePage("win5");
    }

}
