package logic.exceptions;

import logic.BasePage;
import org.apache.log4j.Logger;

public class TrackEnsureException extends Exception {
    protected static final Logger log = Logger.getLogger(TrackEnsureException.class);

    public TrackEnsureException(String s) {
        super(s);
        log.error(s);
    }
}
