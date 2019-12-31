package edu.ecnu.sei.st2019;

import edu.ecnu.sei.st2019.Pages.BasePage;
import edu.ecnu.sei.st2019.Pages.IndexPage;
import edu.ecnu.sei.st2019.Pages.InfoPage;
import edu.ecnu.sei.st2019.Pages.LoginPage;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class InfoTest extends  BaseTest{
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    IndexPage indexPage = new IndexPage();
    InfoPage infoPage = new InfoPage();

//    @BeforeEach
//    public  void init(){
//        loginPage.goLoginPage()
//                .putHandler("window_handles")
//                .inputName("zhang")
//                .inputPassword("134")
//                .clickLoginButton()
//                .putWin("win4185")
//                .putHandler("root")
//                .switchToWin("win4185");
//
//        indexPage.assertUrl("http://localhost:8080/index")
//                .changeMenu(".el-menu-item:nth-child(4)")
//                .putWin("win4")
//                .putHandler("info")
//                .switchToWin("win4");
//    }

    @Test
    public  void should_modify_name_when_the_new_name_is_legal(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zhang")
                .inputPassword("134")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.assertUrl("http://localhost:8080/index")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4");

           infoPage.assertUrl("http://localhost:8080/index/info")
                   .inputInfo(".el-form-item:nth-child(1) .el-input__inner","jasmine")
                   .clickOK(".el-form-item:nth-child(1) .el-button--primary")
                   .checkAlert("修改名称成功")
                   .closePage("win4");
    }


    @Test
    public  void should_modify_name_failed_when_the_new_name_is_not_legal(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("jasmine")
                .inputPassword("134")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.assertUrl("http://localhost:8080/index")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4");

        infoPage.assertUrl("http://localhost:8080/index/info")
                .inputInfo(".el-form-item:nth-child(1) .el-input__inner","j")
                .clickOK(".el-form-item:nth-child(1) .el-button--primary")
                .checkAlert("用户名或密码不合法")
                .closePage("win4");
    }

    @Test
    public  void should_modify_name_failed_when_the_new_name_and_old_name_is_same(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("jasmine")
                .inputPassword("134")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.assertUrl("http://localhost:8080/index")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4");

        infoPage.assertUrl("http://localhost:8080/index/info")
                .inputInfo(".el-form-item:nth-child(1) .el-input__inner","jasmine")
                .clickOK(".el-form-item:nth-child(1) .el-button--primary")
                .checkAlert("失败")
                .closePage("win4");
    }

    @Test
    public  void should_modify_phone_failed_when_the_new_password_is_not_legal(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("jasmine")
                .inputPassword("134")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.assertUrl("http://localhost:8080/index")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4");

        infoPage.assertUrl("http://localhost:8080/index/info")
                .inputInfo(".el-form-item:nth-child(5) .el-input__inner","12")
                .clickOK(".el-form-item:nth-child(5) .el-button--primary")
                .checkAlert("输入手机位数不合法")
                .closePage("win4");
    }

    @Test
    public  void should_modify_phone_successful_when_the_new_password_is_legal(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("jasmine")
                .inputPassword("134")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.assertUrl("http://localhost:8080/index")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4");

        infoPage.assertUrl("http://localhost:8080/index/info")
                .inputInfo(".el-form-item:nth-child(5) .el-input__inner","18221028663")
                .clickOK(".el-form-item:nth-child(5) .el-button--primary")
                .checkAlert("修改电话成功")
                .closePage("win4");
    }

    @Test
    public  void should_modify_password_failed_when_the_input_of_old_password_is_not_correct(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("jasmine")
                .inputPassword("134")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.assertUrl("http://localhost:8080/index")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4");

        infoPage.assertUrl("http://localhost:8080/index/info")
                .inputInfo(".el-form-item:nth-child(2) .el-input__inner","1")
                .inputInfo(".el-form-item:nth-child(3) .el-input__inner","123")
                .inputInfo(".el-form-item:nth-child(4) .el-input__inner","123")
                .clickOK(".el-form-item:nth-child(2) .el-button--primary > span")
                .checkAlert("用户名或密码不正确")
                .closePage("win4");
    }

    @Test
    public  void should_modify_password_failed_when_the_input_of_new_password_is_not_legal(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("jasmine")
                .inputPassword("134")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.assertUrl("http://localhost:8080/index")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4");

        infoPage.assertUrl("http://localhost:8080/index/info")
                .inputInfo(".el-form-item:nth-child(2) .el-input__inner","134")
                .inputInfo(".el-form-item:nth-child(3) .el-input__inner","1")
                .inputInfo(".el-form-item:nth-child(4) .el-input__inner","1")
                .clickOK(".el-form-item:nth-child(2) .el-button--primary > span")
                .checkAlert("用户名或密码不合法")
                .closePage("win4");
    }

    @Test
    public  void should_modify_password_failed_when_the_input_of_new_password_and_old_password_is_same(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("jasmine")
                .inputPassword("134")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.assertUrl("http://localhost:8080/index")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4");

        infoPage.assertUrl("http://localhost:8080/index/info")
                .inputInfo(".el-form-item:nth-child(2) .el-input__inner","134")
                .inputInfo(".el-form-item:nth-child(3) .el-input__inner","134")
                .inputInfo(".el-form-item:nth-child(4) .el-input__inner","134")
                .clickOK(".el-form-item:nth-child(2) .el-button--primary > span")
                .checkAlert("新密码与原密码一样")
                .closePage("win4");
    }

    @Test
    public  void should_modify_password_successful_when_the_input_of_new_password_is_legal(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("jasmine")
                .inputPassword("134")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.assertUrl("http://localhost:8080/index")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4");

        infoPage.assertUrl("http://localhost:8080/index/info")
                .inputInfo(".el-form-item:nth-child(2) .el-input__inner","134")
                .inputInfo(".el-form-item:nth-child(3) .el-input__inner","1345")
                .inputInfo(".el-form-item:nth-child(4) .el-input__inner","1345")
                .clickOK(".el-form-item:nth-child(2) .el-button--primary > span")
                .checkAlert("修改密码成功")
                .closePage("win4");
    }


    @Test

    public  void should_show_old_name_when_click_cancel(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zhang")
                .inputPassword("123")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.assertUrl("http://localhost:8080/index")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4");

        infoPage.assertUrl("http://localhost:8080/index/info")
                .inputInfo(".el-form-item:nth-child(1) .el-input__inner","jasmine")
                .clickCancel(".el-form-item:nth-child(1) .el-button--default > span")
                 .assertValue(".el-form-item:nth-child(1) .el-input__inner","zhang")
                .closePage("win4");
    }

    @Test
    public  void should_show_password_null_when_click_cancel(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zhang")
                .inputPassword("123")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.assertUrl("http://localhost:8080/index")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4");

        infoPage.assertUrl("http://localhost:8080/index/info")
                .inputInfo(".el-form-item:nth-child(2) .el-input__inner","134")
                .inputInfo(".el-form-item:nth-child(3) .el-input__inner","1345")
                .inputInfo(".el-form-item:nth-child(4) .el-input__inner","1345")
                .clickCancel(".el-form-item:nth-child(2) .el-button--default > span")
                .assertValue(".el-form-item:nth-child(2) .el-input__inner","")
                .assertValue(".el-form-item:nth-child(3) .el-input__inner","")
                .assertValue(".el-form-item:nth-child(4) .el-input__inner","")
                .closePage("win4");
    }

    @Test
    public  void should_show_telephone_null_when_click_cancel(){
        loginPage.goLoginPage()
                .putHandler("window_handles")
                .inputName("zhang")
                .inputPassword("123")
                .clickLoginButton()
                .putWin("win4185")
                .putHandler("root")
                .switchToWin("win4185");

        indexPage.assertUrl("http://localhost:8080/index")
                .changeMenu(".el-menu-item:nth-child(4)")
                .putWin("win4")
                .putHandler("info")
                .switchToWin("win4");

        infoPage.assertUrl("http://localhost:8080/index/info")
                .inputInfo(".el-form-item:nth-child(5) .el-input__inner","18221028663")
                .clickCancel(".el-form-item:nth-child(5) .el-button--default > span")
                .assertValue(".el-form-item:nth-child(5) .el-input__inner","15317872182")
                .closePage("win4");
    }

}
