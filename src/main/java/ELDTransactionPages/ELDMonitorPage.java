package ELDTransactionPages;

import ELDTransactionPages.Fragments.ELDMonitorHeaderFragment;
import ELDTransactionPages.Fragments.ELDMonitorModalWindowFragment;
import ELDTransactionPages.Fragments.MainEldFilterFragment;

public class ELDMonitorPage {

    ELDMonitorHeaderFragment eldMonitorHeaderFragment = new ELDMonitorHeaderFragment();
ELDMonitorModalWindowFragment eldMonitorModalWindowFragment = new ELDMonitorModalWindowFragment();



    public ELDMonitorHeaderFragment getEldMonitorHeaderFragment() {
        return eldMonitorHeaderFragment;
    }

    public ELDMonitorModalWindowFragment getEldMonitorModalWindowFragment() {
        return eldMonitorModalWindowFragment;
    }

}
