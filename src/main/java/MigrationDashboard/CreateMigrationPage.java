package MigrationDashboard;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import loadDashboardPages.fragments.LoadSettingsFragment;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CreateMigrationPage {
    SelenideElement companyInput = $x(""),
            commentInput = $x(""),
            datePicker = $x (""),
            descriptionInput = $x(""),
            saveBtn = $x (""),
            backBtn = $x("");

    ElementsCollection nameInput = $$x (""),
            companyList = $$x(""),
            positionList = $$x (""),
            typeFromList = $$x(""),
            typeToList = $$x(""),
            driverList = $$x(""),
            truckList = $$x(""),
            trailersList = $$x(""),
            userList = $$x("");

    public void selectCompany(String companyName) {

    }
}

