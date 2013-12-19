package classInterfaces;

import dataStorage.AnEvent;
import dataStorage.Deadline;

/**
 * @author Kristo Koert
 * @version 1.0
 * @since 2013-11-30
 */
public interface EditInterface {

    /**
     * Brings up the UI with witch a new Deadline instance can be created
     * @return a Deadline instance
     */
    public Deadline addNewDeadline();

    /**
     * Brings up the UI with witch a new AnEvent instance can be created
     * @return a AnEvent instance
     */
    public AnEvent addNewEvent();

    /**
     * Bring up the UI with witch an existing Deadline instance can be removed
     */
    public void removeDeadline();

    /**
     * Brings up the UI with witch an existing AnEvent instance can be removed
     */
    public void removeEvent();
}
