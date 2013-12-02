package classInterfaces;

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
     * @param d display Events/Deadlines that are less than d days away
     */
    public void displayAll(ArrayList[] data, int d);

    /**
     * Brings up UI for displaying Deadlines
     * @param d display Deadlines that are less than d days away
     */
    public void displayDeadlines(ArrayList[] data, int d);

    /**
     * Brings up UI for displaying Events
     * @param d display Events that are less than d days away
     */
    public void displayEvents(ArrayList[] data, int d);

}
