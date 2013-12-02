package dataStorage;

import java.util.ArrayList;

/**
 * @author Kristo Koert
 * @version 1.0
 * @since 2013-11-29
 */
public class FileConnector {

    /**
     * Only one Connection item allowed at once, if true, Constructor fails
     */
    private static boolean isOpen = false;
    /**
     * Path to the text file used as Deadline objects data storage
     */
    private String deadLPath;
    /**
     * Path to the text file used as AnEvent objects data storage
     */
    private String eventPath;

    /**
     * FileConnector constructor
     * <p>
     * Finds the path to both Event and Deadline data files.
     * Raises AssertionError if an instance of this class already exists.
     * </p>
     */
    public FileConnector() {
        try {
            assert (isOpen == false);
        } catch (AssertionError a) {
            System.out.println("Only one instance of FileConnector allowed.");
        }
        isOpen = true;
        //ToDo Search for files
    }

    /**
     * Write a String to a text file specified by path.
     * <p>
     * <p/>
     * The String is a representation of either an AnEvent or Deadline object.
     * The String is in the format specified by {@link AnEvent)} and {@link Deadline} toString() methods.
     * Will be written on a new line.
     * </p>
     *
     * @param strRep the data representation
     * @param path   the path to a text file
     */
    private void writeToFile(String strRep, String path) {
        //ToDo Write a String to a text file
    }

    /**
     * Remove a String from a text file specified by path.
     * <p>
     * The String is a representation of either an AnEvent or Deadline object.
     * The String is in the format specified by {@link AnEvent)} and {@link Deadline} toString() methods.
     * </p>
     *
     * @param strRep the data representation
     * @param path   the path to a text file
     */
    private void removeFromFile(String strRep, String path) {
        //ToDo remove a String from a text file
    }

    /**
     * This method creates Event objects based on the information in
     * the text file located at {@link #eventPath}.
     *
     * @return an ArrayList of Event objects
     */
    private ArrayList<AnEvent> getEvents() {
        ArrayList<AnEvent> events = new ArrayList<AnEvent>();
        //ToDo create AnEvent objects from text file lines
        return events;
    }

    /**
     * This method creates Deadline objects based on the information in
     * the text file located at {@link #deadLPath}
     *
     * @return an ArrayList of Deadline objects
     */
    private ArrayList<Deadline> getDeadlines() {
        ArrayList<Deadline> deadlines = new ArrayList<Deadline>();
        //ToDo create Deadline objects from text file lines
        return deadlines;
    }

    /**
     * Writes a representation of a Deadline or AnEvent object to deadLPath or eventPath respectively
     * <p>
     * The format of the data reflects Deadline or AnEvent class constructor arguments separated
     * by whitespaces and arranged in order of the constructor arguments.
     * </p>
     *
     * @param someOccasion a Deadline or Event object
     */
    public void storeData(AnEvent someOccasion) {
        String path;
        String stringRep;

        if (someOccasion.getClass() == AnEvent.class) {
            stringRep = someOccasion.toString();
            path = eventPath;
        } else {
            stringRep = someOccasion.toString();
            path = deadLPath;
        }
        writeToFile(stringRep, path);
    }

    /**
     * This method gets all the Data that is represented in both {@link #deadLPath} and
     * {@link #eventPath} files.
     * <p>
     * The data in the files is used to create objects and add them
     * to an ArrayList. These lists are both returned in an array of length 2.
     * </p>
     *
     * @return an array of length 2 that contains ArrayLists, first element is Deadlines and second Events.
     */
    public ArrayList[] getData() {
        ArrayList[] data = new ArrayList[2];
        data[0] = getDeadlines();
        data[1] = getEvents();
        return data;
    }

    /**
     * This method removes an AnEvent or Deadline from data storage
     * <p>
     * If a representation of such an object is not found in data storage,
     * issues a warning and does nothing.
     * </p>
     *
     * @param someOccasion
     */
    public void removeData(AnEvent someOccasion) {
        String path;
        String stringRep;

        if (someOccasion.getClass() == AnEvent.class) {
            stringRep = someOccasion.toString();
            path = eventPath;
        } else {
            stringRep = someOccasion.toString();
            path = deadLPath;
        }
        removeFromFile(stringRep, path);
    }

    /**
     * Destructor method.
     * <p>
     * Sets {@link #isOpen} to false, thus allowing a new instance of this class to be created
     * </p>
     */
    public static void Destructor() {
        isOpen = false;
    }
}
