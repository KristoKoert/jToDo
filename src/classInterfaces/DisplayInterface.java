package classInterfaces;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import dataStorage.AnEvent;
import dataStorage.Deadline;

import java.util.ArrayList;

public interface DisplayInterface {

    /**
     * This method will display a Greeting to the user
     */
    public void greetUser();

    /**
     * Brings up the main page of the UI.
     */
    public void displayMain();

    /**
     * Brings up UI for displaying all Data
     * @param data all data
     */
    public void displayAll(ArrayList[] data);

    /**
     * Brings up UI for displaying Deadlines
     * @param data all deadlines
     */
    public void displayDeadlines(ArrayList<Deadline> data);

    /**
     * Brings up UI for displaying Events
     * @param data all events
     */
    public void displayEvents(ArrayList<AnEvent> data);

}
