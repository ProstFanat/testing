package ELDTransactionPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ELDViewerPage {

    SelenideElement dateRangePicker = $x("//input[@placeholder = 'Select date and time']"),
                    legendBtn = $x("//button[text() = ' Legend ']");
ElementsCollection graphsDays = $$x("//div[@class = 'day-wrapper']"),
                    legends = $$x("//li[@role='menuitem']");


    public ELDViewerPage selectDateRangeDays(int firstDay, int lastDay) {
        dateRangePicker.click();
        $x("//span[text() = '" + firstDay + "']").click();
        $x("//span[@class='owl-dt-calendar-cell-content'][text() = '" + lastDay + "']").click();
   return this;
    }

    public ElementsCollection getGraphsDays() {
        return graphsDays;
    }


    public SelenideElement getLegendBtn() {
    return legendBtn;
    }

public ELDViewerPage legendBtnClick(){
    legendBtn.click();
    return this;
}
public ElementsCollection getLegends(){
   return legends;
}

}
