package logic.widgets.Editor.Modificators;

import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class DatePickerTool extends EditorPage {
    @FindAll({
            @FindBy(className = "owl-dt-calendar-cell")

    })
    private List<WebElement> calendarDays;

    @FindAll({
            @FindBy(className = " owl-dt-timer-input")

    })
        private List<WebElement> timeInputs;
        @FindBy (xpath = "//app-add/div[2]/div[2]/div[1]/div/input")
        private WebElement eventTimeInput;
        @FindBy (xpath = "//*[@id='owl-dt-picker-1']/div[2]/owl-date-time-timer/owl-date-time-timer-box[1]/label/input")
        private WebElement hoursInputElement;
        @FindBy (xpath = "//*[@id='owl-dt-picker-1']/div[2]/owl-date-time-timer/owl-date-time-timer-box[2]/label/input")
        private WebElement minutesInputElement;
        @FindBy (xpath = "//button[@class='owl-dt-control owl-dt-control-button owl-dt-container-control-button']/span[contains(text(),'Set')]")
        private WebElement datePickerBtn;
        private static final Logger log = Logger.getLogger(DatePickerTool.class);
        private String dayDate;
        private String hoursInput;
        private String minutesInput;
        private int changeDateCoef;

        public DatePickerTool(String hoursInput, String minutesInput, int changeDateCoef) {
            super();
            this.dayDate = changeDate(changeDateCoef);
            this.hoursInput = hoursInput ;
            this.minutesInput = minutesInput;
            this.changeDateCoef = changeDateCoef;
        }

        public String getDayDate() {
            return dayDate;
        }

        public void setDayDate(int changeDateCoef) {
            this.dayDate = changeDate(changeDateCoef);

        }

        public String getHoursInput() {
            return hoursInput;
        }

        public void setHoursInput(String hoursInput) {
            this.hoursInput = hoursInput;
        }

        public String getMinutesInput() {
            return minutesInput;
        }

        public void setMinutesInput(String minutesInput) {
            this.minutesInput = minutesInput;
        }

        private String changeDate(int changeDateCoef){
            int coef = 24*changeDateCoef;
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.HOUR, coef);
            return format.format(cal.getTime());
        }

        public DatePickerTool selectDay (){
           try {
               for (WebElement day : calendarDays) {
                   if (day.getAttribute("aria-label").equals(dayDate)) {
                       try {
                           day.click();
                       } catch (Exception e) {
                           log.error(e);
                           return selectDay();
                       }
                       log.info("Select day in calendar: " + dayDate);
                       break;
                   }
               }
           } catch (StaleElementReferenceException e){
               log.error("Calendar error: "  + e);
               return selectDay();
           }
            if (driver.findElement(By.className("owl-dt-calendar-cell-active")).getAttribute("aria-label").equals(dayDate))
                return this;
            else {
                log.error("Required day not selected.");
                return selectDay();
            }
        }

        public DatePickerTool inputHoursAndMinutes(){
            hoursInputElement.clear();
            hoursInputElement.sendKeys(hoursInput);
            minutesInputElement.clear();
            minutesInputElement.sendKeys(minutesInput);
            log.info("Select time in calendar: "  + hoursInput + ":" + minutesInput);
            return this;
        }

        public CreateTool clickSetTime (){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            datePickerBtn.click();
            log.info("Click Set in calendar");
            return new CreateTool();
        }

    }

