package eldTransactionPages;

import eldTransactionPages.Fragments.ELDMonitorHeaderFragment;
import eldTransactionPages.Fragments.ELDMonitorModalWindowFragment;
import eldTransactionPages.Fragments.ELDMonitorTabsFragment;


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
