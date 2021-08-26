package eldTransactionsTest;


import createTransactions.CreateTransaction;
import eldTransactionPages.ELDMonitorPage;
import eldTransactionPages.EldTransactionPage;
import loginAndMainPages.LoginPage;
import loginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.AppConstants;

import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class CancelledRejectedCommitTransactions {

    public static LoginPage loginPage;
    public static EldTransactionPage eldMainPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static ELDMonitorPage eldMonitorPage;
    public static Random random;
    public static CreateTransaction createTransaction;

@BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        loginPage = new LoginPage();
        eldMainPage = new EldTransactionPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        eldMonitorPage = new ELDMonitorPage();
        createTransaction = new CreateTransaction();
        loginPage.login("adrian@mail.com", "test");
        random = new Random();
       // createTransaction.createTransaction(10, "comment");
       // loginPage.login("adrian@mail.com", "test");
}

    @BeforeEach
    void beforeTest() {
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app-admin/hos/#/eldTransactions/transactions");
    }

    @Test
    void rejectTransactionTest() {

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
      //  Assertions.assertTrue(eldMainPage.getMainEldTableFragment().findTransactionByComment(comment));
    }

    @Test
    void commitTransactionTest() {

        eldMainPage.getMainEldTableFragment().clickFirstActionBtn()
                .clickActionView();

        eldMonitorPage.getEldMonitorHeaderFragment().clickCommiteBtn();
        eldMonitorPage.getEldMonitorModalWindowFragment().clickCancelBtn();
        eldMonitorPage.getEldMonitorHeaderFragment().commiteBtn.shouldBe(Condition.visible).click();

        eldMonitorPage.getEldMonitorModalWindowFragment().modalCommitBtn.shouldNotBe(Condition.visible, Condition.enabled);

        String comment = String.valueOf((int) (Math.random() * 10000));
        eldMonitorPage.getEldMonitorModalWindowFragment().typeComment(comment);
        eldMonitorPage.getEldMonitorModalWindowFragment().clickCommiteBtn();
        System.out.println(comment);
        eldMainPage.checkMessage("ELD Transaction was committed successfully!").shouldBe(Condition.visible);
        eldMainPage.getMainEldFilterFragment().changeStatusFilter("Committed")
                .clickFilterBtn();
        sleep(500);
        Assertions.assertTrue(eldMainPage.getMainEldTableFragment().findTransactionByComment(comment));

}

    @Test
    void cancelTransactionTest() {

        String transactionDate = eldMainPage.getMainEldTableFragment().getFirstTransactionDriver().getText();

        eldMainPage.getMainEldTableFragment().clickFirstActionBtn()
                .clickDeleteBtn();
        eldMainPage.getConfirmModalWindowFragment().clickYesBtn();

        eldMainPage.checkMessage("ELD Transaction was deleted successfully!").shouldBe(visible);
        eldMainPage.getMainEldFilterFragment().changeStatusFilter("Cancelled")
                .clickFilterBtn();
        Assertions.assertTrue(eldMainPage.getMainEldTableFragment().findTransaction(transactionDate));
    }


}
