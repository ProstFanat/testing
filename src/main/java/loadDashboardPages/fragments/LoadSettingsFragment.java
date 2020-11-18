package loadDashboardPages.fragments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class LoadSettingsFragment {

    SelenideElement pickupDatePickerField = $x("//input[@id='pickupDate']");
    SelenideElement chooseMonthAndYearBtn = $x("//button[@aria-label='Choose month and year']");


public void setPickupDate(int day, String month, int year){
    pickupDatePickerField.click();
    chooseMonthAndYearBtn.click();
    $x("//td[@aria-label='"+year+"']").click();
    sleep(500);
    $x("//td[@aria-label='"+month+"']").click();
    $x("//span[text()= '" +day+"']").click();
}




}
