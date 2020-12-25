package ELDTransactions;


import ELDTransactionPages.ELDMonitorPage;
import ELDTransactionPages.EldTransactionPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RejectedCommitTransactions {

    public static LoginPage loginPage;
public static EldTransactionPage eldMainPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static ELDMonitorPage eldMonitorPage;


    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");
        loginPage = new LoginPage();
        eldMainPage = new EldTransactionPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        eldMonitorPage = new ELDMonitorPage();
        loginPage.login("5", "test");
    }

    @BeforeEach
    void beforeTest(){
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
    }


//@Test
//    void rejectTransactionTest(){
//        mainAdminScreenPage.clickSideMenuELDTransactionBtb();
//
//        eldMainPage.getMainEldTableFragment().clickFirstActionBtn()
//                .clickActionView();
//        eldMonitorPage.clictTakeTransactionBtn()
//                .clickRejectBtn();
//    eldMonitorPage.getModalWindowFragment().clickCancelBrtn();
//    eldMonitorPage.getMainMonitorTableFragment().clickRejectBtn();
//
//    eldMonitorPage.getModalWindowFragment().rejectBtn.   // not clicsble
//    eldMonitorPage.getModalWindowFragment().typeComment(randomComment);
//    String comment =  randomComment;
//            .clickRejectBtn();
//
//    eldMainPage.checkMessage("ELD Transaction was rejected successfully!").shouldBe(Visible);
//    eldMainPage.getFilterFragment().changeStatusFilter("Rejected")
//            .clickFilterBtn();
//    eldMainPage.getMainEldTableFragment().getTransactionByComment(comment).shouldBe(exist);
//    }
}
