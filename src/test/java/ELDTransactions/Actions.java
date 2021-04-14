package ELDTransactions;


import ELDTransactionPages.ELDMonitorPage;
import ELDTransactionPages.EldTransactionPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import resources.AppConstants;

import java.util.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class Actions {

    public static LoginPage loginPage;
    public static EldTransactionPage eldMainPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static ELDMonitorPage eldMonitorPage;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        loginPage = new LoginPage();
        eldMainPage = new EldTransactionPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        eldMonitorPage = new ELDMonitorPage();
        loginPage.login("5", "test");
    }

    @Test
    void processedActionsTest() {
        mainAdminScreenPage.clickSideMenuELDTransactionBtn();

        eldMainPage.getMainEldFilterFragment().changeStatusFilter("Processed")
                .clickFilterBtn();
        String[] expectedActions = {"View","Take", "Delete Transaction"};
        String actualActions = eldMainPage.getMainEldTableFragment().clickFirstActionBtn().getActions().texts().toString();

        Assertions.assertEquals(Arrays.toString(expectedActions), actualActions);

    }

    @Test
    void committedActionsTest() {
        mainAdminScreenPage.clickSideMenuELDTransactionBtn();

        eldMainPage.getMainEldFilterFragment().changeStatusFilter("Committed")
                .clickFilterBtn();
        sleep(500);
        String[] expectedActions = {"Roll Back Transaction Changes", "Delete Transaction"};
        String actualActions = eldMainPage.getMainEldTableFragment().clickFirstActionBtn().getActions().texts().toString();

        Assertions.assertEquals(Arrays.toString(expectedActions), actualActions);

    }
    @Test
    void rejectedActionsTest() {
        mainAdminScreenPage.clickSideMenuELDTransactionBtn();
        eldMainPage.getMainEldTableFragment().clickFirstActionBtn()
                .clickActionView();
        eldMonitorPage.getEldMonitorHeaderFragment().clickRejectBtn();

        String comment = String.valueOf((int) (Math.random() * 10000));
        eldMonitorPage.getEldMonitorModalWindowFragment().typeComment(comment);
        eldMonitorPage.getEldMonitorModalWindowFragment().clickRejectBtn();
        eldMainPage.getMainEldFilterFragment().changeStatusFilter("Rejected")
                .clickFilterBtn();
        sleep(500);
        String[] expectedActions = { "Delete Transaction"};
        eldMainPage.getMainEldTableFragment().findTransactionByComment(comment);

        String actualActions = eldMainPage.getMainEldTableFragment().clickFirstActionBtn().getActions().texts().toString();


        Assertions.assertEquals(Arrays.toString(expectedActions), actualActions);

    }
}
