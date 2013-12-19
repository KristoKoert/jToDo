package UI;

import classInterfaces.DisplayInterface;
import classInterfaces.EditInterface;
import dataStorage.AnEvent;
import dataStorage.Deadline;
import dataStorage.FileConnector;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TextBased implements DisplayInterface, EditInterface {
    /**
     * {@inheritDoc}
     */
    public void greetUser() {
        try {
            System.out.print("\n\n\n\n\n           Welcome to jToDo!\n          ");
            for (int i = 0; i < 19; i++) {
                Thread.sleep(50);
                System.out.print('.');
            }
        } catch (InterruptedException e) {
        }
        System.out.println("\n\n\n\n\n\n\n");
    }

    /**
     * This is essentially the screen
     */
    ArrayList<String> screen = new ArrayList<String>();

    /**
     * Gets all user input
     */
    Scanner input = new Scanner(System.in);

    /**
     * Deals with data transfer
     */
    FileConnector fileCon = new FileConnector();

    /**
     * This is the main user interface for the text based version.
     * <p>
     * The output is essentially an ArrayList of Strings printed element by element on new lines.
     * There is a certain list of commands that can be entered to choose what to do in the program.
     * A command is composed of a 'what to do' statement and a 'what to do it to'.
     * ex: -v all (View all), -r event (Remove an event)
     * </p>
     * <p>
     * There are 8 constant lines (Instructions + 1 line heading).
     * </p>
     */
    public void displayMain() {
        greetUser();
        //Entry of constant menu items begins..
        screen.add("\n               jToDo\n\n");
        screen.add("Commands   : -v : view, -a : add, -r : remove\n\n");
        screen.add("Parameters : all, deadline, event\n\n");
        screen.add("Example    : \'-v all\' to view all.\n\n");
        //And ends.
        // The Scanner.next method will supply both the command and parameter string
        String command;
        String param;
        while (true) {
            //Constant screen is printed
            for (String l : screen) {
                System.out.print(l);
            }
            System.out.print("Input: ");
            command = input.next().toLowerCase();
            param = input.next().toLowerCase();
            //If view command entered
            if (command.equals("-v")) {
                if (param.equals("all")) {
                    displayAll(fileCon.getAllData());
                }
                else if (param.equals("deadline")) {
                    displayDeadlines(fileCon.getDeadlines());
                }
                else if (param.equals("event")) {
                    displayEvents(fileCon.getEvents());
                }
                else try {
                        System.out.println("Invalid input!");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
            }
            //If add command used
            else if (command.equals("-a")) {
                if (param.equals("deadline")) {
                    fileCon.storeData(addNewDeadline());
                }
                else if (param.equals("event")) {
                    fileCon.storeData(addNewEvent());
                }
                else try {
                        System.out.println("Invalid input!");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
            }
            //If remove command used
            else if (command.equals("-r")) {
                if (param.equals("all")) {
                    fileCon.removeAll();
                }
                else if (param.equals("deadline")) {
                    removeDeadline();
                }
                else if (param.equals("event")) {
                    removeEvent();
                }
                else try {
                        System.out.println("Invalid input!");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                }
            }
            else try {
                System.out.println("Invalid input!");
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

    public void displayAll(ArrayList[] data) {
        ArrayList<Deadline> deadlines = data[0];
        ArrayList<AnEvent> events = data[1];

        System.out.println("Upcoming Events   :");
        for (Deadline occ : events) {
            System.out.println(occ);
        }

        System.out.println("Upcoming Deadlines :");
        for (Deadline occ : deadlines) {
            System.out.println(occ);
        }

        System.out.print("Enter any character to continue.. ");
        input.next();
    }

    public void displayEvents(ArrayList<AnEvent> data) {
        System.out.println("Upcoming Events: ");
        for (AnEvent ev: data) {
            System.out.println(ev);
        }
        System.out.print("Enter any character to continue.. ");
        input.next();
    }

    public void displayDeadlines(ArrayList<Deadline> data) {
        System.out.println("Upcoming Deadlines: ");
        for (Deadline dl: data) {
            System.out.println(dl);
        }
        System.out.print("Enter any character to continue.. ");
        input.next();
    }

    public Deadline addNewDeadline() {
        //ToDo Implement addNewDeadlines
        String name;
        String date;
        System.out.print("Enter a name for a deadline: ");
        name = input.next();
        System.out.print("Enter a date (ex. 12.31.13): ");
        date = input.next();
        //ToDo Figure out a failsafe
        if(date.length() != 8) {
            return addNewDeadline();
        }
        return new Deadline(name, date);
    }

    public AnEvent addNewEvent() {
        //ToDo Implement addNewEvent
        String name;
        String time;
        String date;
        System.out.print("Enter a name for the event : ");
        name = input.next();
        System.out.print("Enter a time (ex. 24:60)   : ");
        time = input.next();
        System.out.print("Enter a date (ex. 12.31.13): ");
        date = input.next();
        //ToDo Figure out a failsafe
        if(date.length() != 8 || time.length() != 5) {
            return addNewEvent();
        }
        if(date == null) {
            System.out.println("!!!!");
        }
        return new AnEvent(name, time, date);
    }

    public void removeDeadline() {
        //ToDo Implement removeDeadline
        String name;
        System.out.println("Enter the name of the deadline: ");
        name = input.next();
        fileCon.removeData(name, "deadline");
    }

    public void removeEvent() {
        //ToDo Implement removeEvent
        String name;
        System.out.println("Enter the name of the event: ");
        name = input.next();
        fileCon.removeData(name, "event");
    }
}