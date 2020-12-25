package ELDTransactions;


import ELDTransactionPages.ELDMonitorPage;
import ELDTransactionPages.EldTransactionPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class RejectedCommitTransactions {

    public static LoginPage loginPage;
    public static EldTransactionPage eldMainPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static ELDMonitorPage eldMonitorPage;
    public static Random random;

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
        random = new Random();
    }

    @Test
    void rejectTransactionTest() {
        mainAdminScreenPage.clickSideMenuELDTransactionBtb();

        eldMainPage.getMainEldTableFragment().clickFirstActionBtn()
                .clickActionView();

        eldMonitorPage.getEldMonitorHeaderFragment().clickRejectBtn();
        eldMonitorPage.getEldMonitorModalWindowFragment().clickCancelBtn();
        eldMonitorPage.getEldMonitorHeaderFragment().rejectBtn.shouldBe(Condition.visible).click();

        eldMonitorPage.getEldMonitorModalWindowFragment().modalRejectBtn.shouldNotBe(Condition.visible, Condition.enabled);

        String comment = String.valueOf(Math.random());
        eldMonitorPage.getEldMonitorModalWindowFragment().typeComment(comment);
        eldMonitorPage.getEldMonitorModalWindowFragment().clickRejectBtn();

        eldMainPage.checkMessage("ELD Transaction was rejected successfully!").shouldBe(Condition.visible);
        eldMainPage.getMainEldFilterFragment().changeStatusFilter("Rejected")
                    .clickFilterBtn();
        eldMainPage.getMainEldTableFragment().getTransactionByComment(comment).shouldHaveSize(1);


    }


}
