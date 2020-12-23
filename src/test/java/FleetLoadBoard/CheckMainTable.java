package FleetLoadBoard;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import com.sun.xml.xsom.XSUnionSimpleType;
import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.open;

public class CheckMainTable {

    public static MainFleetBoardTablePage mainTablePage;
    public static LoginPage loginPage;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");
        mainTablePage = new MainFleetBoardTablePage();
        loginPage.login("10", "test");
    }

    @BeforeEach
    void beforeTest() {
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
    }


    @Test
    void checkTableRows(){


    }
}
