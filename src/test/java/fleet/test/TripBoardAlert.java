package fleet.test;

import fleet.*;
import fleet.resources.ConfPropertiesFleet;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TripBoardAlert {
    public static WebDriver driver;
    public static OpenFleetPage open;
    public static createNewFleetEvent createTrip;
    public static mainFleet mainFleetEvents;
    public static editEvent edit;
    public static filterFleet filter;
    public static BasePage basePage;
    public static LogOut logOut;
    public static TripBoard main;

    @BeforeAll
    public static void setup() {
//        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfPropertiesFleet.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        driver = new ChromeDriver();
        open("http://localhost:8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new OpenFleetPage(driver);
        createTrip = new createNewFleetEvent(driver);
        mainFleetEvents = new mainFleet(driver);
        edit = new editEvent(driver);
        filter = new filterFleet(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        main = new TripBoard(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        open.openFleetEvents();
    }

    @BeforeEach
    public void beforeTest(){
        driver.get("http://localhost:8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");
        basePage.waitToVisibilityOf(10, createTrip.btnCreateNew);
        basePage.waitToBeClickable(10, createTrip.btnCreateNew);
        createTrip.clickBtnCreateTrip();
        basePage.waitToVisibilityOf(10, createTrip.commentField);
        basePage.waitToVisibilityOf(10, createTrip.commentField);
    }

    @Test
    public void testOnlyMandatory(){
        createTrip.createTrip("new", "Local");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("new").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testWithDriver1(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.inputPlace();
        createTrip.inputDriver1("Adrian Gherghel");
        createTrip.clickBtnSave();
        main.sleep(500);

        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("new").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                if(("Adrian Gherghel").equals(main.getDriver1())){
                    Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
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
    public void testWithDriver2(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.inputPlace();
        createTrip.inputDriver2("Adrian Gherghel");
        createTrip.clickBtnSave();

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("new").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                if(("Adrian Gherghel").equals(main.getDriver2())){
                    Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
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
    public void testWithTruck(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.inputPlace();
        createTrip.inputTruck("1210");
        createTrip.clickBtnSave();

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("new").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                if(("1210").equals(main.getTruck())){
                    Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
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
    public void testWithTrailer(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.inputPlace();
        createTrip.inputTrailer("1210T");
        createTrip.clickBtnSave();

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("new").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                if(("1210T").equals(main.getTrailer())){
                    Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
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
    public void testWithTrailerAndTruck(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.inputPlace();
        createTrip.inputTrailer("1210T");
        createTrip.inputTruck("1210");
        createTrip.clickBtnSave();

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("new").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                if(("1210T").equals(main.getTrailer())){
                    if(("1210").equals(main.getTruck())){
                        Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
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
    public void testWithDriverAndTruck(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.inputPlace();
        createTrip.inputDriver1("Adrian Gherghel");
        createTrip.inputTruck("1210");
        createTrip.clickBtnSave();

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("new").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                if(("Adrian Gherghel").equals(main.getDriver1())){
                    if(("1210").equals(main.getTruck())){
                        Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
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
    public void testWithDriverAndTrailer(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.inputPlace();
        createTrip.inputDriver1("Adrian Gherghel");
        createTrip.inputTrailer("1210T");
        createTrip.clickBtnSave();

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("new").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                if(("Adrian Gherghel").equals(main.getDriver1())){
                    if(("1210T").equals(main.getTrailer())){
                        Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
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
    public void testWithDriverTrailerAndTruck(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.inputPlace();
        createTrip.inputDriver1("Adrian Gherghel");
        createTrip.inputTrailer("1210T");
        createTrip.inputTruck("1210");
        createTrip.clickBtnSave();

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("new").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                if(("Adrian Gherghel").equals(main.getDriver1())){
                    if(("1210T").equals(main.getTrailer())){
                        if(("1210").equals(main.getTruck())){
                            //main.tableAlert.click();
                            Assertions.assertTrue(basePage.isVisible(main.tableAlert));
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
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Test With all types*/

    /***/
    @Test
    public void testStatusNewTypeHighway(){
        createTrip.createTrip("new", "Highway");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("new").equals(main.getTripStatus())){
            if(("Highway").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusDispatchedTypeHighway(){
        createTrip.createTrip("dispatched", "Highway");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("dispatched").equals(main.getTripStatus())){
            if(("Highway").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusCancelledTypeHighway(){
        createTrip.createTrip("cancelled", "Highway");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("cancelled").equals(main.getTripStatus())){
            if(("Highway").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusDoneTypeHighway(){
        createTrip.createTrip("done", "Highway");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("done").equals(main.getTripStatus())){
            if(("Highway").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusBookedTypeHighway(){
        createTrip.createTrip("booked", "Highway");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("booked").equals(main.getTripStatus())){
            if(("Highway").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    /***/
    @Test
    public void testStatusNewTypeHighwayLocal(){
        createTrip.createTrip("new", "Highway/Local");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("new").equals(main.getTripStatus())){
            if(("Highway/Local").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusDispatchedTypeHighwayLocal(){
        createTrip.createTrip("dispatched", "Highway/Local");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("dispatched").equals(main.getTripStatus())){
            if(("Highway/Local").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusCancelledTypeHighwayLocal(){
        createTrip.createTrip("cancelled", "Highway/Local");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("cancelled").equals(main.getTripStatus())){
            if(("Highway/Local").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusDoneTypeHighwayLocal(){
        createTrip.createTrip("done", "Highway/Local");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("done").equals(main.getTripStatus())){
            if(("Highway/Local").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusBookedTypeHighwayLocal(){
        createTrip.createTrip("booked", "Highway/Local");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();;
        if(("booked").equals(main.getTripStatus())){
            if(("Highway/Local").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    /***/
    @Test
    public void testStatusNewTypeLocal(){
        createTrip.createTrip("new", "Local");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("new").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusDispatchedTypeLocal(){
        createTrip.createTrip("dispatched", "Local");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("dispatched").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusCancelledTypeLocal(){
        createTrip.createTrip("cancelled", "Local");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("cancelled").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusDoneTypeLocal(){
        createTrip.createTrip("done", "Local");
        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("done").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusBookedTypeLocal(){
        createTrip.createTrip("booked", "Local");

        main.sleep(500);
        String trip = mainFleetEvents.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/app/trip-board/#/trip-list");
        basePage.sleep(1000);
        main.clickAdvancedSearch();
        main.inputTripNumber(trip);
        main.applyFilters();
        if(("booked").equals(main.getTripStatus())){
            if(("Local").equals(main.getTripType())){
                Assertions.assertTrue(basePage.isElementDisplayed(main.tableAlert));
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
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
