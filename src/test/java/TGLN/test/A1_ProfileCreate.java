package TGLN.test;

import TGLN.*;
import fleetEvents.fleet.LogOut;
import fleetEvents.fleet.resources.ConfPropertiesFleet;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class A1_ProfileCreate {

    public static WebDriver driver;
    public static OpenGPSDevices open;
    public static BasePage basePage;
    public static LogOut logOut;
    public static TabDevices mainDevices;
    public static AddGPSDevice createDevice;
    public static Actions actions;
    public static AddTruckToDevice addTruck;
    public static TabNotification mainNotification;
    public static CreateNotifications createNotification;
    public static TabProfiles main;
    public static CreateProfile create;


    @BeforeAll
    public static void setup() {
//        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfPropertiesFleet.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        driver = new ChromeDriver();
        open("http://localhost:8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new OpenGPSDevices(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        mainDevices = new TabDevices(driver);
        mainNotification = new TabNotification(driver);
        createNotification = new CreateNotifications(driver);
        actions = new Actions(driver);
        addTruck = new AddTruckToDevice(driver);
        createDevice = new AddGPSDevice(driver);
        create = new CreateProfile(driver);
        main = new TabProfiles(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        open.openGPSDevices();
    }

    @BeforeEach
    public void beforeTest(){
        mainDevices.openProfilesTab();
        main.openCreateNewProfile();
    }

    @Test
    public void testEmpty(){
        if(!(create.btnSave.isEnabled())){
            Assertions.assertTrue(true);
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testWithName(){
        int number = (int) (Math.random() * 1000000);
        create.inputName("test" + number);
        if(!(create.btnSave.isEnabled())){
            Assertions.assertTrue(true);
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testWithNameAndServer(){
        int number = (int) (Math.random() * 1000000);
        create.inputName("test" + number);
        create.inputServerTimeout("" + number);
        if(!(create.btnSave.isEnabled())){
            Assertions.assertTrue(true);
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testWithNameServerAndLTE(){
        int number = (int) (Math.random() * 1000000);
        create.inputName("test" + number);
        create.inputServerTimeout("" + number);
        create.inputLteTimeout("" + number);
        create.saveProfile();
        main.filterTable("test" + number);
        if(("test" + number).equals(main.getValueProfileName())){
            if(("" + number).equals(main.getValueServerTimeout())){
                if(("" + number).equals(main.getValueLteTimeout())){
                    Assertions.assertTrue(true);
                } else {
                    Assertions.assertTrue(false);
                }
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
        main.deleteProfile("test" + number);
        main.confirmDelete();
    }

    @Test
    public void testLockSleepSeconds(){
        create.clickAlwaysAwakeModeCheckbox();
        Assertions.assertFalse(create.sleepSecondsInput.isEnabled());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Validation Server Timeout*/
    @Test
    public void testServerInput9(){
        create.inputServerTimeout("9");
        if(basePage.isElementDisplayed(create.validationServerTimeout)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testServerInput10(){
        create.inputServerTimeout("10");
        if(!(basePage.isElementDisplayed(create.validationServerTimeout))){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testServerInputFractional(){
        create.inputServerTimeout("15.1");
        if(basePage.isElementDisplayed(create.validationServerTimeout)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Validation LTE Timeout*/
    @Test
    public void testLteInput19(){
        create.inputLteTimeout("19");
        if(basePage.isElementDisplayed(create.validationLTETimeout)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testLteInput20(){
        create.inputLteTimeout("20");
        if(!(basePage.isElementDisplayed(create.validationLTETimeout))){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testLteInputFractional(){
        create.inputLteTimeout("30.1");
        if(basePage.isElementDisplayed(create.validationLTETimeout)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Validation Sleep Timeout*/
    @Test
    public void testSleepWithNegative(){
        create.inputSleepSeconds("-19");
        if(basePage.isElementDisplayed(create.validationSleepSeconds)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Validation Read Sensors mode*/
    @Test
    public void testReadSensorsNegative(){
        create.clickAlwaysAwakeModeCheckbox();
        create.inputReadSensorsInterval("-19");
        if(basePage.isElementDisplayed(create.validationReadSensors)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testReadSensorsPositive(){
        create.clickAlwaysAwakeModeCheckbox();
        create.inputReadSensorsInterval("19");
        if(!(basePage.isElementDisplayed(create.validationReadSensors))){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testReadSensorsFractional(){
        create.clickAlwaysAwakeModeCheckbox();
        create.inputReadSensorsInterval("19.1");
        if(basePage.isElementDisplayed(create.validationReadSensors)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testReadSensorsZero(){
        create.clickAlwaysAwakeModeCheckbox();
        create.inputReadSensorsInterval("0");
        if(basePage.isElementDisplayed(create.validationReadSensors)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Validation GPS Position mode*/
    @Test
    public void testReadGPSPositionNegative(){
        create.clickAlwaysAwakeModeCheckbox();
        create.inputReadGPSPositionInterval("-19");
        if(basePage.isElementDisplayed(create.validationReadGps)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testReadGPSPositionPositive(){
        create.clickAlwaysAwakeModeCheckbox();
        create.inputReadGPSPositionInterval("19");
        if(!(basePage.isElementDisplayed(create.validationReadGps))){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testReadGPSPositionFractional(){
        create.clickAlwaysAwakeModeCheckbox();
        create.inputReadGPSPositionInterval("19.1");
        if(basePage.isElementDisplayed(create.validationReadGps)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testReadGPSPositionZero(){
        create.clickAlwaysAwakeModeCheckbox();
        create.inputReadGPSPositionInterval("0");
        if(basePage.isElementDisplayed(create.validationReadGps)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Validation Server Heartbeat*/
    @Test
    public void testServerHeartbeatNegative(){
        create.clickAlwaysAwakeModeCheckbox();
        create.inputServerHeartbeatInterval("-19");
        if(basePage.isElementDisplayed(create.validationServerHeartbeat)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testServerHeartbeatPositive(){
        create.clickAlwaysAwakeModeCheckbox();
        create.inputServerHeartbeatInterval("19");
        if(!(basePage.isElementDisplayed(create.validationServerHeartbeat))){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testServerHeartbeatFractional(){
        create.clickAlwaysAwakeModeCheckbox();
        create.inputServerHeartbeatInterval("19.1");
        if(basePage.isElementDisplayed(create.validationServerHeartbeat)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testServerHeartbeatZero(){
        create.clickAlwaysAwakeModeCheckbox();
        create.inputServerHeartbeatInterval("0");
        if(basePage.isElementDisplayed(create.validationServerHeartbeat)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Validation Threshold */
    @Test
    public void testThreshold62(){
        create.clickAccelerationCheckbox();
        create.inputThreshold("62");
        if(basePage.isElementDisplayed(create.validationThresholdLower)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testThreshold63(){
        create.clickAccelerationCheckbox();
        create.inputThreshold("63");
        if(!(basePage.isElementDisplayed(create.validationThresholdLower))){
            if(!(basePage.isElementDisplayed(create.validationThresholdUpper))) {
                if (!(basePage.isElementDisplayed(create.validationThresholdUFractional))){
                    if (!(create.btnSave.isEnabled())) {
                        Assertions.assertTrue(true);
                    } else {
                        Assertions.assertTrue(false);
                    }
                } else {
                    Assertions.assertTrue(false);
                }
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testThreshold8000(){
        create.clickAccelerationCheckbox();
        create.inputThreshold("8000");
        if(!(basePage.isElementDisplayed(create.validationThresholdLower))){
            if(!(basePage.isElementDisplayed(create.validationThresholdUpper))) {
                if (!(basePage.isElementDisplayed(create.validationThresholdUFractional))){
                    if (!(create.btnSave.isEnabled())) {
                        Assertions.assertTrue(true);
                    } else {
                        Assertions.assertTrue(false);
                    }
                } else {
                    Assertions.assertTrue(false);
                }
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testThreshold8001(){
        create.clickAccelerationCheckbox();
        create.inputThreshold("8001");
        if(basePage.isElementDisplayed(create.validationThresholdUpper)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testThresholdFractional(){
        create.clickAccelerationCheckbox();
        create.inputThreshold("400.1");
        //if(basePage.isElementDisplayed(create.validationThresholdUFractional)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
//        } else {
//            Assertions.assertTrue(false);
//        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Validation Duration */
    @Test
    public void testDuration159(){
        create.clickAccelerationCheckbox();
        create.inputDuration("159");
        if(basePage.isElementDisplayed(create.validationDurationLower)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testDuration160(){
        create.clickAccelerationCheckbox();
        create.inputDuration("160");
        if(!(basePage.isElementDisplayed(create.validationDurationLower))){
            if(!(basePage.isElementDisplayed(create.validationDurationUpper))) {
                if (!(basePage.isElementDisplayed(create.validationDurationFractional))){
                    if (!(create.btnSave.isEnabled())) {
                        Assertions.assertTrue(true);
                    } else {
                        Assertions.assertTrue(false);
                    }
                } else {
                    Assertions.assertTrue(false);
                }
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testDuration40800(){
        create.clickAccelerationCheckbox();
        create.inputDuration("40800");
        if(!(basePage.isElementDisplayed(create.validationDurationLower))){
            if(!(basePage.isElementDisplayed(create.validationDurationUpper))) {
                if (!(basePage.isElementDisplayed(create.validationDurationFractional))){
                    if (!(create.btnSave.isEnabled())) {
                        Assertions.assertTrue(true);
                    } else {
                        Assertions.assertTrue(false);
                    }
                } else {
                    Assertions.assertTrue(false);
                }
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testDuration40801(){
        create.clickAccelerationCheckbox();
        create.inputDuration("40801");
        if(basePage.isElementDisplayed(create.validationDurationUpper)){
            if(!(create.btnSave.isEnabled())){
                Assertions.assertTrue(true);
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testDurationFractional(){
        create.clickAccelerationCheckbox();
        create.inputDuration("400.1");
        //if(basePage.isElementDisplayed(create.validationDurationFractional)){
        if(!(create.btnSave.isEnabled())){
            Assertions.assertTrue(true);
        } else {
            Assertions.assertTrue(false);
        }
//        } else {
//            Assertions.assertTrue(false);
//        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Test of Fully Charged */
    @Test
    public void testChargedDefaultValueOfSleepSecond(){
        String initValue = create.getValueIfFullyCharged();
        create.inputSleepSeconds("30");
        Assertions.assertEquals(initValue, create.getValueIfFullyCharged());
    }

    @Test
    public void testChargedWithGPSSleep(){
        String initValue = create.getValueIfFullyCharged();
        create.clickGpsSleepCheckbox();
        Assertions.assertNotEquals(initValue, create.getValueIfFullyCharged());
    }

    @Test
    public void testChargedWithGPSSleepAndSleepSeconds(){
        String initValue = create.getValueIfFullyCharged();
        create.clickGpsSleepCheckbox();
        create.inputSleepSeconds("100");
        Assertions.assertNotEquals(initValue, create.getValueIfFullyCharged());
    }

    @Test
    public void testChargedWithAlwaysAwakeMode(){
        String initValue = create.getValueIfFullyCharged();
        create.clickAlwaysAwakeModeCheckbox();
        Assertions.assertNotEquals(initValue, create.getValueIfFullyCharged());
    }

    @Test
    public void testChargedWithSleepSecondsAndAlwaysAwakeMode(){
        create.inputSleepSeconds("100");
        String initValue = create.getValueIfFullyCharged();
        create.clickAlwaysAwakeModeCheckbox();
        Assertions.assertNotEquals(initValue, create.getValueIfFullyCharged());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Test Acceleration */
    @Test
    public void testAccelerationDefaultValues(){
        create.clickAccelerationCheckbox();
        basePage.sleep(500);
        String initValue = create.getEquivalentFalling();
        create.inputThreshold("200");
        create.inputDuration("300");
        Assertions.assertEquals(initValue, create.getEquivalentFalling());
    }

    @Test
    public void testAccelerationOnlyWithThreshold(){
        create.clickAccelerationCheckbox();
        basePage.sleep(500);
        String initValue = create.getEquivalentFalling();
        create.inputThreshold("250");
        Assertions.assertNotEquals(initValue, create.getEquivalentFalling());
    }

    @Test
    public void testAccelerationOnlyWithDuration(){
        create.clickAccelerationCheckbox();
        basePage.sleep(500);
        String initValue = create.getEquivalentFalling();
        create.inputDuration("1000");
        Assertions.assertNotEquals(initValue, create.getEquivalentFalling());
    }

    @Test
    public void testAccelerationWithThresholdAndDuration(){
        create.clickAccelerationCheckbox();
        basePage.sleep(500);
        String initValue = create.getEquivalentFalling();
        create.inputThreshold("2000");
        create.inputDuration("3000");
        Assertions.assertNotEquals(initValue, create.getEquivalentFalling());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Test of Save at Table*/
    @Test
    public void testWithoutAlwaysAwakeMode(){
        int number = (int) (Math.random() * 100000);
        create.inputName("test" + number);
        create.inputServerTimeout("" + number);
        create.inputLteTimeout("" + number);
        create.inputSleepSeconds("" + number);
        create.clickGpsSleepCheckbox();
        create.clickAccelerationCheckbox();
        create.inputThreshold("3000");
        create.inputDuration("4000");
        create.saveProfile();
        main.filterTable("test" + number);
        if(("test" + number).equals(main.getValueProfileName())){
            if(("" + number).equals(main.getValueServerTimeout())){
                if(("" + number).equals(main.getValueLteTimeout())){
                    if(("" + number).equals(main.getValueSleepSeconds())){
                        if(("Y").equals(main.getValueSleepGPSOn())){
                            if(("N").equals(main.getValueTempAlertEnabled())){
                                if(("Y").equals(main.getValueAccAlertEnabled())){
                                    if(("3000").equals(main.getValueAccAlertThreshold())){
                                        if(("4000").equals(main.getValueAccAlertDuration())){
                                            Assertions.assertTrue(true);
                                        } else {
                                            Assertions.assertTrue(false);
                                        }
                                    } else {
                                        Assertions.assertTrue(false);
                                    }
                                } else {
                                    Assertions.assertTrue(false);
                                }
                            } else {
                                Assertions.assertTrue(false);
                            }
                        } else {
                            Assertions.assertTrue(false);
                        }
                    } else {
                        Assertions.assertTrue(false);
                    }
                } else {
                    Assertions.assertTrue(false);
                }
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
        main.deleteProfile("test" + number);
        main.confirmDelete();
    }

    @Test
    public void testWithAlwaysAwakeMode(){
        int number = (int) (Math.random() * 100000);
        create.inputName("test" + number);
        create.inputServerTimeout("" + number);
        create.inputLteTimeout("" + number);
        create.clickAlwaysAwakeModeCheckbox();
        create.inputReadSensorsInterval("100");
        create.inputReadGPSPositionInterval("200");
        create.inputServerHeartbeatInterval("300");
        create.saveProfile();
        main.filterTable("test" + number);
        if(("test" + number).equals(main.getValueProfileName())){
            if(("").equals(main.getValueSleepSeconds())){
                if(("N").equals(main.getValueSleepGPSOn())){
                    if(("N").equals(main.getValueTempAlertEnabled())){
                        if(("N").equals(main.getValueAccAlertEnabled())){
                            if(("").equals(main.getValueAccAlertThreshold())){
                                if(("").equals(main.getValueAccAlertDuration())){
                                            Assertions.assertTrue(true);
                                        } else {
                                    Assertions.assertTrue(false);
                                }
                            } else {
                                        Assertions.assertTrue(false);
                                    }
                        } else {
                                    Assertions.assertTrue(false);
                                }
                    } else {
                                Assertions.assertTrue(false);
                            }
                } else {
                            Assertions.assertTrue(false);
                        }
            } else {
                        Assertions.assertTrue(false);
                    }
        } else {
            Assertions.assertTrue(false);
        }

        main.deleteProfile("test" + number);
        main.confirmDelete();
    }

    @Test
    public void testCreateProfileFromTabDevices(){
        create.cancelSavingProfile();
        mainDevices.openDevicesTab();
        mainDevices.openNewDeviceForm();
        createDevice.selectProfileTabManagement();

        createDevice.createNewProfile();
        int number = (int) (Math.random() * 100000);
        create.inputName("test" + number);
        create.inputServerTimeout("" + number);
        create.inputLteTimeout("" + number);
        create.clickAlwaysAwakeModeCheckbox();
        create.inputReadSensorsInterval("100");
        create.inputReadGPSPositionInterval("200");
        create.inputServerHeartbeatInterval("300");
        create.saveProfile();
        main.sleep(500);
        createDevice.cancelDevice();
        main.sleep(500);

        mainDevices.openProfilesTab();
        main.filterTable("test" + number);
        if(("test" + number).equals(main.getValueProfileName())){
            if(("0").equals(main.getValueSleepSeconds())){
                if(("N").equals(main.getValueSleepGPSOn())){
                    if(("N").equals(main.getValueTempAlertEnabled())){
                        if(("N").equals(main.getValueAccAlertEnabled())){
                            if(("").equals(main.getValueAccAlertThreshold())){
                                if(("").equals(main.getValueAccAlertDuration())){
                                    Assertions.assertTrue(true);
                                } else {
                                    Assertions.assertTrue(false);
                                }
                            } else {
                                Assertions.assertTrue(false);
                            }
                        } else {
                            Assertions.assertTrue(false);
                        }
                    } else {
                        Assertions.assertTrue(false);
                    }
                } else {
                    Assertions.assertTrue(false);
                }
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }

        main.deleteProfile("test" + number);
        main.confirmDelete();
    }

    @AfterEach
    public void afterTests(){
        driver.navigate().refresh();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
