package UI;

import classInterfaces.DisplayInterface;
import classInterfaces.InputInterface;
import dataStorage.AnEvent;
import dataStorage.Deadline;
import dataStorage.FileConnector;

import java.util.ArrayList;
import java.util.Scanner;

public class TextBased implements DisplayInterface, InputInterface {
    /**
     * {@inheritDoc}
     */
    public void greetUser() {
        try {
            System.out.print("\n\n\n\n\n           Welcome to jToDo!\n          ");
            for (int i = 0; i < 19; i++) {
                Thread.sleep(150);
                System.out.print('.');
            }
        } catch (InterruptedException e) {
        }
        System.out.println("\n\n\n\n\n\n\n");
    }

    /**
     * Gets all user input
     */
    Scanner input = new Scanner(System.in);

    /**
     * This is the main user interface for the text based version.
     * <p>
     * The output is essentially an ArrayList of Strings printed element by element on new lines.
     * There is a certain list of commands that can be entered to choose what to do in the program.
     * A command is composed of a 'what to do' statement and a 'what to do it to'.
     * ex: -v all (View all), -r event (Remove an event)
     * </p>
     */
    public void displayMain() {
        greetUser();
        ArrayList<String> screen = new ArrayList<String>();
        screen.add("\n               jToDo\n");
        screen.add("-v : view       ");
        screen.add("-a : add        ");
        screen.add("-r : remove     ");
        screen.add(" all            ");
        screen.add(" deadline       ");
        screen.add(" event          ");
        FileConnector fileCon = new FileConnector();
        String choice;
        while (true) {
            for (String l : screen) {
                System.out.println(l);
            }
            choice = input.next().toLowerCase();

            if (choice.substring(0, 2).equals("-v")) {
                if (choice.substring(3).equals(" all")) {

                }
                else if (choice.substring(3).equals(" deadline")) {

                }
                else if (choice.substring(3).equals(" event")) {

                }
            }
        }
    }

    public void displayAll(ArrayList[] data, int i) {
        ArrayList<AnEvent> events = data[1];
        System.out.println("Events:");
        for (Deadline occ : events) {
            System.out.println(occ);
        }
        ArrayList<Deadline> deadlines = data[0];
        System.out.println("Deadlines:");
        for (Deadline occ : deadlines) {
            System.out.println(occ);
        }
        System.out.println("Press enter to continue..");
        input.next();
    }

    public void displayEvents(ArrayList[] data, int i) {
        //ToDo Implement displayEvents
    }

    public void displayDeadlines(ArrayList[] data, int i) {
        //ToDo Implement displayDeadlines
    }

    public Deadline addNewDeadline() {
        //ToDo Implement addNewDeadlines
        return new Deadline("", "");
    }

    public AnEvent addNewEvent() {
        //ToDo Implement addNewEvent
        return new AnEvent("", "", "");
    }

    public void removeDeadline() {
        //ToDo Implement removeDeadline
    }

    public void removeEvent() {
        //ToDo Implement removeEvent
    }

}
