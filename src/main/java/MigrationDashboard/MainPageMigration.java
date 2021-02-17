package MigrationDashboard;

import com.codeborne.selenide.SelenideElement;
import loadDashboardPages.fragments.LoadSettingsFragment;

import static com.codeborne.selenide.Selenide.$x;

public class MainPageMigration {
    SelenideElement migrationDateInput = $x(""),
                    chooseMonthAndYearBtn = $x("//button[@aria-label='Choose month and year']"),
                    eldFromInput = $x(""),
                    toEldInput = $x(""),
                    companyInput = $x(""),
                    driverInput = $x(""),
                    statusInput = $x(""),
                    responsibleInput = $x(""),
                    applyBtn = $x(""),
                    clearBtn = $x(""),
                    createNewBtn = $x(""),
                    actionBtn = $x(""),
                    manageBtn = $x(""),
                    cancelMigrationBtn = $x(""),
                    retryMigrationBtn = $x("");

    SelenideElement idTable = $x(""),
                    orgTable = $x(""),
                    fromEldTable = $x(""),
                    toEldTable = $x(""),
                    migrationDateTable = $x(""),
                    driversTable = $x(""),
                    trucksTable = $x(""),
                    trailerTable = $x(""),
                    userTable = $x(""),
                    responsibleTable = $x(""),
                    commentTable = $x("");

    public void inputMigrationDate(){

    }


    public void setPickupDate(int dayFrom, int dayTo, String month, int year) {
        migrationDateInput.click();
        chooseMonthAndYearBtn.click();
        $x("//td[@aria-label='" + year + "']").click();
        $x("//span[text()= '" + month + "']").click();
        $x("//span[text()= '" + day + "']").click();
        setDatePickerBtn.click();
        return this;
    }

}
