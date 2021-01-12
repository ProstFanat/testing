package ELDTransactions;


import ELDTransactionPages.ELDMonitorPage;
import ELDTransactionPages.EldTransactionPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class Actions {

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
    }


    @Test
    void processedActionsTest() {
        mainAdminScreenPage.clickSideMenuELDTransactionBtn();

        eldMainPage.getMainEldFilterFragment().changeStatusFilter("Processed")
                .clickFilterBtn();

        eldMainPage.getMainEldTableFragment().clickFirstActionBtn().getActions();

//       .shouldHaveSize(3);
       // eldMainPage.getMainEldTableFragment().getActions().shouldHave(CollectionCondition.texts(" View"),CollectionCondition.texts(" Take"),CollectionCondition.texts(" Delete Transaction"));


    }










}
