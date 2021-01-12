package ELDTransactionPages;

import ELDTransactionPages.Fragments.ELDMonitorHeaderFragment;
import ELDTransactionPages.Fragments.ELDMonitorModalWindowFragment;
import ELDTransactionPages.Fragments.ELDMonitorTabsFragment;


public class ELDMonitorPage {

    ELDMonitorHeaderFragment eldMonitorHeaderFragment = new ELDMonitorHeaderFragment();
    ELDMonitorModalWindowFragment eldMonitorModalWindowFragment = new ELDMonitorModalWindowFragment();
    ELDMonitorTabsFragment eldMonitorTabsFragment = new ELDMonitorTabsFragment();

    public ELDMonitorHeaderFragment getEldMonitorHeaderFragment() {
        return eldMonitorHeaderFragment;
    }

    public ELDMonitorModalWindowFragment getEldMonitorModalWindowFragment() {
        return eldMonitorModalWindowFragment;
    }


    public ELDMonitorTabsFragment getEldMonitorTabsFragment() {
        return eldMonitorTabsFragment;
    }
}
