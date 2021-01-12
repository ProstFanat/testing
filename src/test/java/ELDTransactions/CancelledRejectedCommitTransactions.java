package ELDTransactions;


import ELDTransactionPages.ELDMonitorPage;
import ELDTransactionPages.EldTransactionPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class CancelledRejectedCommitTransactions {

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

    @BeforeEach
    void beforeTest() {
        open("http://localhost:8080/TrackEnsure/app-admin/hos/#/eldTransactions/transactions");
    }

    @Test
    void rejectTransactionTest() {
        mainAdminScreenPage.clickSideMenuELDTransactionBtn();

        eldMainPage.getMainEldTableFragment().clickFirstActionBtn()
                .clickActionView();

        eldMonitorPage.getEldMonitorHeaderFragment().clickRejectBtn();
        eldMonitorPage.getEldMonitorModalWindowFragment().clickCancelBtn();
        eldMonitorPage.getEldMonitorHeaderFragment().rejectBtn.shouldBe(Condition.visible).click();

        eldMonitorPage.getEldMonitorModalWindowFragment().modalRejectBtn.shouldNotBe(Condition.visible, Condition.enabled);

        String comment = String.valueOf((int) (Math.random() * 10000));
        eldMonitorPage.getEldMonitorModalWindowFragment().typeComment(comment);
        eldMonitorPage.getEldMonitorModalWindowFragment().clickRejectBtn();

        eldMainPage.checkMessage("ELD Transaction was rejected successfully!").shouldBe(Condition.visible);
        eldMainPage.getMainEldFilterFragment().changeStatusFilter("Rejected")
                .clickFilterBtn();
        eldMainPage.getMainEldTableFragment().getTransactionByComment(comment).shouldHaveSize(1);
    }

    @Test
    void commiteTransactionTest() {
        mainAdminScreenPage.clickSideMenuELDTransactionBtn();

        eldMainPage.getMainEldTableFragment().clickFirstActionBtn()
                .clickActionView();

        eldMonitorPage.getEldMonitorHeaderFragment().clickCommiteBtn();
        eldMonitorPage.getEldMonitorModalWindowFragment().clickCancelBtn();
        eldMonitorPage.getEldMonitorHeaderFragment().commiteBtn.shouldBe(Condition.visible).click();

        eldMonitorPage.getEldMonitorModalWindowFragment().modalCommitBtn.shouldNotBe(Condition.visible, Condition.enabled);

        String comment = String.valueOf((int) (Math.random() * 10000));
        eldMonitorPage.getEldMonitorModalWindowFragment().typeComment(comment);
        eldMonitorPage.getEldMonitorModalWindowFragment().clickCommiteBtn();

        eldMainPage.checkMessage("ELD Transaction was committed successfully!").shouldBe(Condition.visible);
        eldMainPage.getMainEldFilterFragment().changeStatusFilter("Committed")
                .clickFilterBtn();
        eldMainPage.getMainEldTableFragment().getTransactionByComment(comment).shouldHaveSize(1);
    }

    @Test
    void cancelTransactionTest() {
        mainAdminScreenPage.clickSideMenuELDTransactionBtn();

        String transactionDate = eldMainPage.getMainEldTableFragment().getFirstTransactionDate().getText();

        eldMainPage.getMainEldTableFragment().clickFirstActionBtn()
                .clickDeleteBtn();
        eldMainPage.getConfirmModalWindowFragment().clickYesBtn();

        eldMainPage.checkMessage("ELD Transaction was deleted successfully!").shouldBe(visible);
        eldMainPage.getMainEldFilterFragment().changeStatusFilter("Cancelled")
                .clickFilterBtn();
        Assertions.assertTrue(eldMainPage.getMainEldTableFragment().findTransaction(transactionDate));
    }


}
