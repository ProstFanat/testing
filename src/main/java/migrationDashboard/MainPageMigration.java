package migrationDashboard;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.*;

public class MainPageMigration {
    SelenideElement migrationDateInput = $x("//input[@ng-reflect-name = 'migrationDate']"),
                    chooseMonthAndYearBtn = $x("//button[@aria-label='Choose month and year']"),
                    eldFromInput = $x("//*[@formcontrolname = 'originalELDType']//input"),
                    eldToInput = $x("//*[@formcontrolname = 'targetELDType']//input"),
                    companyInput = $x("//*[@formcontrolname = 'orgId']//input"),
                    btnFindCompany = $x("//*[@formcontrolname = 'orgId']//..//button"),
                    driverInput = $x("//*[@formcontrolname = 'driverId']//input"),
                    statusInput = $x("//*[@formcontrolname = 'status']//input"),
                    responsibleInput = $x("//*[@formcontrolname = 'responsible']//input"),
                    applyBtn = $x("//button[text() = ' Apply ']"),
                    clearBtn = $x("//button[text() = ' Clear ']"),
                    createNewBtn = $x("//button[text() = ' Create New ']"),
                    actionBtn = $x("//button[text() = ' Actions '][1]"),
                    manageBtn = $x("//*[@role = 'menuitem']//i[contains(@class, 'fa-pencil')]"),
                    cancelMigrationBtn = $x("//*[@role = 'menuitem']//*[contains(@class, 'fa-times-circle')]"),
                    retryMigrationBtn = $x("//*[@role = 'menuitem']//*[contains(@class, 'fa-refresh')]");

    ElementsCollection idTable = $$x(""),
                    orgTable = $$x(""),
                    fromEldTable = $$x(""),
                    toEldTable = $$x(""),
                    migrationDateTable = $$x(""),
                    driversTable = $$x(""),
                    trucksTable = $$x(""),
                    trailerTable = $$x(""),
                    userTable = $$x(""),
                    responsibleTable = $$x(""),
                    commentTable = $$x(""),
                    actionsBtns = $$x("//button[text() = ' Actions ']");

    ElementsCollection eldFromList = $$x("//*[@formcontrolname = 'originalELDType']//div[@role = 'option']"),
                        eldToList = $$x("//*[@formcontrolname = 'targetELDType']//div[@role = 'option']"),
                        companyList = $$x("//*[@formcontrolname = 'orgId']//div[@role = 'option']"),
                        driverList = $$x("//*[@formcontrolname = 'driverId']//div[@role = 'option']"),
                        statusList = $$x("//*[@formcontrolname = 'status']//div[@role = 'option']"),
                        responsibleList = $$x("//*[@formcontrolname = 'responsible']//div[@role = 'option']");

    public MainPageMigration setMigrationDateFromTo(int dayFrom, String monthFrom, int yearFrom, int dayTo, String monthTo,  int yearTo) {
        migrationDateInput.click();
        chooseMonthAndYearBtn.click();
        $x("//td[@aria-label='" + yearFrom + "']").click();
        $x("//span[text()= '" + monthFrom + "']").click();
        $x("//span[text()= '" + dayFrom + "']").click();

        chooseMonthAndYearBtn.click();
        $x("//td[@aria-label='" + yearTo + "']").click();
        $x("//span[text()= '" + monthTo + "']").click();
        $x("//span[text()= '" + dayTo + "']").click();

        return this;
    }

    public MainPageMigration setFromEld(String eldFrom){
        eldFromInput.click();
        eldFromInput.setValue(eldFrom);
        eldFromList.first().click();
        return this;
    }

    public MainPageMigration setToEld(String eldTo){
        eldToInput.click();
        eldToInput.setValue(eldTo);
        eldToList.first().click();
        return this;
    }

    public MainPageMigration setCompanyName(String companyName){
        companyInput.setValue(companyName);
        btnFindCompany.click();
        companyList.first().click();
        return this;
    }

    public MainPageMigration setDriverName(String driverName, String companyName){
        companyInput.setValue(companyName);
        btnFindCompany.click();
        companyList.first().click();

        driverInput.setValue(driverName);
        driverList.first().click();
        return this;
    }

    public MainPageMigration setMigrationStatus(String status){
        statusInput.setValue(status);
        statusList.first().click();
        return this;
    }

    public MainPageMigration setResponsiblePerson(String name){
        responsibleInput.setValue(name);
        responsibleList.first().click();
        return this;
    }

    public MainPageMigration clickBtnApply(){
        applyBtn.click();
        return this;
    }

    public MainPageMigration clickBtnClearAll(){
        clearBtn.click();
        return this;
    }

    public MainPageMigration clickBtnCreateNew(){
        createNewBtn.click();
        return this;
    }

    public MainPageMigration checkTableBy(String filterBy, String value){
        int numberOfColumn = 0;

        if (filterBy.equals("migrationDate")) {
            numberOfColumn = 6;
        } else if (filterBy.equals("eldFrom")) {
            numberOfColumn = 3;
        } else if (filterBy.equals("eldTo")) {
            numberOfColumn = 4;
        } else if (filterBy.equals("company")) {
            numberOfColumn = 2;
        } else if (filterBy.equals("driver")) {
            numberOfColumn = 7;
        } else if (filterBy.equals("status")) {
            numberOfColumn = 5;
        } else if (filterBy.equals("responsible")) {
            numberOfColumn = 11;
        } else {
            System.out.println("INPUT CORRECT FILTER BY");

            Assertions.assertTrue(false);
        }


        sleep(500);
        int startSize = idTable.size();
        int finishSize = 0;
        for (int i = 1; i <= startSize; i++) {
            if(numberOfColumn != 7) {
                if ($x("//datatable-body-row[" + i + "]//datatable-body-cell[" + numberOfColumn + "]//span").getText().equals(value)) {
                    finishSize++;
                }
            } else {
                if ($x("//datatable-body-row[" + i + "]//datatable-body-cell[" + numberOfColumn + "]//span").getText().contains(value)) {
                    finishSize++;
                }
            }
        }

        Assertions.assertEquals(startSize, finishSize);


        return this;
    }

    public MainPageMigration clickCreateNewBtn(){
        createNewBtn.click();
        return this;
    }
}
