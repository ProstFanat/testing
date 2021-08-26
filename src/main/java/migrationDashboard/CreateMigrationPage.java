package migrationDashboard;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CreateMigrationPage {

    /** Инпуты по созданию миграции */
    SelenideElement
            companyInput = $x("//*[@formcontrolname = 'orgId']//input"),
            typeFromInput = $x("//*[@formcontrolname = 'originalELDType']//input"),
            typeToInput = $x("//*[@formcontrolname = 'targetELDType']//input"),
            commentInput = $x("//*[@formcontrolname = 'comment']"),
            datePicker = $x("//*[@formcontrolname = 'migrationScheduleDate']"),
            positionInput = $x("//*[@formcontrolname = 'userType']//input"),
            nameInput = $x("//*[@formcontrolname = 'name']//input"),
            emailInput = $x("//*[@formcontrolname = 'contactPhone']"),
            descriptionInput = $x("//*[@formcontrolname = 'description']");
    ElementsCollection
            nameList = $$x ("//*[@formcontrolname = 'name']//*[@role = 'option']"),
            companyList = $$x("//*[@formcontrolname = 'orgId']//*[@role = 'option']"),
            positionList = $$x ("//*[@formcontrolname = 'userType']//*[@role = 'option']"),
            typeFromList = $$x("//*[@formcontrolname = 'originalELDType']//*[@role = 'option']"),
            typeToList = $$x("//*[@formcontrolname = 'targetELDType']//*[@role = 'option']");

    /** Фильтры по таблице */
    SelenideElement
            driverNameFilter = $x("//*[text() = ' Driver Name ']/..//input"),
            closestResetDateFilter = $x("//*[text() = ' Closest Reset ']/..//input"),
            paidByFilter = $x("//*[text() = ' Paid By ']/..//input"),
            clearAllBtn = $x("//*[text() = ' Clear All ']"),
            calculateHOSData = $x("//*[text() = ' Calculate HOS data ']");
    ElementsCollection
            paidByList = $$x("//*[text() = ' Paid By ']//..//*[@role = 'option']");

    /** Кнопки по работе с миграцией */
    SelenideElement
            saveBtn = $x ("//button[text() = 'Save ']"),
            backBtn = $x("//button[text() = 'Back']");


    public void selectCompany(String companyName) {

    }
}

