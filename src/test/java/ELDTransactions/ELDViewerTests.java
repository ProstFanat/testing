package ELDTransactions;

import ELDTransactionPages.ELDMonitorPage;
import ELDTransactionPages.EldTransactionPage;
import ELDTransactionPages.ELDViewerPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class ELDViewerTests {

    public static LoginPage loginPage;
    public static EldTransactionPage eldMainPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static ELDMonitorPage eldMonitorPage;
    public static Random random;
    public static ELDViewerPage eldViewerPage;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");
        loginPage = new LoginPage();
        eldMainPage = new EldTransactionPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        eldMonitorPage = new ELDMonitorPage();
        eldViewerPage = new ELDViewerPage();
        loginPage.login("5", "test");
    }

    @BeforeEach
    void beforeTest() {
        open("http://localhost:8080/TrackEnsure/app-admin/hos/#/eldTransactions/transactions");
    }

    @Test
    void dateFilterTest() {
        mainAdminScreenPage.clickSideMenuELDTransactionBtn();

        eldMainPage.getMainEldTableFragment().clickFirstActionBtn()
                .clickActionView();

        eldMonitorPage.getEldMonitorTabsFragment().eldViewerTabClick();

        int firstDay = 1;    // set calendar days
        int lastDay = 30;    // to Filter
        eldViewerPage.selectDateRangeDays(firstDay,lastDay);
        eldViewerPage.getGraphsDays().shouldHaveSize((firstDay - lastDay)+1);
    }

    @Test
    void legendTest() {
        mainAdminScreenPage.clickSideMenuELDTransactionBtn();

        eldMainPage.getMainEldTableFragment().clickFirstActionBtn()
                .clickActionView();

        eldMonitorPage.getEldMonitorTabsFragment().eldViewerTabClick();

        eldViewerPage.getLegendBtn().shouldBe(Condition.visible, Condition.enabled);
        eldViewerPage.legendBtnClick()
                .getLegends().shouldHaveSize(15);
    }









}
