package migrationDashboard.fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ManageMigrationMainInfoFragment extends BasePage {

    SelenideElement btnAddDrivers = $x("//button[text() = 'ADD DRIVERS']"),
                    btnRemoveDrivers = $x("//button[text() = 'REMOVE DRIVERS']"),
                    datePickerMigrationDate = $x(""),
                    companyNameText = $x(""),
                    typeFromText = $x(""),
                    typeToText = $x(""),
                    commentText = $x("");
                    ;

    ElementsCollection test1 = $$x("");
}
