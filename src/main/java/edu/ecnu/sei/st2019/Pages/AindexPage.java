package edu.ecnu.sei.st2019.Pages;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AindexPage extends  BasePage {
    public AindexPage putHandler(String handlers){
        super.putHandler(handlers);
        return this;
    }

    public AindexPage switchToWin(String win){
        super.switchToWin(win);
        return this;
    }

    public AindexPage putWin(String win){
        super.putWin(win);
        return this;
    }

    public AindexPage checkUrl(String url){
        assertThat(driver.getCurrentUrl(), is(url));
        return this;
    }

}
