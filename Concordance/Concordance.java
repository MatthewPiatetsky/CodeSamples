/**
 * This file contains the Concordance class.
 * This class contains methods to member test and process the input text.
 * The class also contains a main method which constructs a GUI and allows the user to access the functionality of the concordance. 
 * Much of the code for the GUI is taken from sections of the handout, such as the program CheckListener3.
 * 
 * Matthew Piatetsky
 * 4/14/2012
 */

//imports the necessary packages
import java.awt.*;
import javax.swing.*;
import java.util.EventObject;

public class Concordance
{
    // Creates a blacklist which will remove words left over from the breaking apart of words like "he's", "I'll", "I'm", "We're" and "I've" 
    private static String[] blacklist = { "s", "ll", "m", "re", "ve", "", };
    // A method to process the input text by removing punctuation and splitting the words 
    private static void splitWords(String str, WordList list) {
        // Sets the characters to lower case
        str = str.toLowerCase();
        // Removes any punctuation
        str = str.replace('\'', ' ');
        str = str.replace(',', ' ');
        str = str.replace('.', ' ');
        str = str.replace('(', ' ');
        str = str.replace(')', ' ');
        str = str.replace('"', ' ');
        str = str.replace('-', ' ');
        str = str.replace('!', ' ');
        str = str.replace('?', ' ');
        str = str.replace(':', ' ');
        str = str.replace(';', ' ');
        str = str.replace('*', ' ');
        str = str.replace('$', ' ');

        String[] processed = str.split("\\s");

        // For loop that goes through the string, checks the blacklist and inserts the string into the wordlist
        for (int i = 0; i < processed.length; i++)
            if (!checkBlackList(processed[i], blacklist))
                list.insert(processed[i]);
    }

    // Check the string to see if any of the words are on the blacklist
    private static Boolean checkBlackList(String str, String[] list) {
        Boolean found = false;
        for (int i = 0; i < list.length; i++) {
            if (str.equals(list[i])) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static void main(String[] args)
    {
        // Establishes the Frame
        JFrame frame = new JFrame("Concordance"); // Creates the JFrame
        frame.setSize(1000, 750); // Sets the size of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets the window to close
        frame.setBackground(new Color(255, 240, 180)); // Sets the background color

        // Creates the necessary labels to place at the top of the GUI
        JLabel l1 = new JLabel("Concordance");
        JLabel l2 = new JLabel("Instructions: Insert text in the Input Box and press Build to see a sorted word list.");
        JLabel l3 = new JLabel("Input Box");
        JLabel l4 = new JLabel("Word List");

        // Creates the two clear buttons and the build button
        JButton b1 = new JButton("Clear");
        JButton b2 = new JButton("Build");
        JButton b3 = new JButton("Clear");

        // Sets the font and size for the labels and the buttons.
        l1.setFont(new Font("TimesRoman", 1, 45));
        l2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        l3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        l4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        b1.setFont(new Font("Arial", Font.BOLD, 12));
        b2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        b3.setFont(new Font("Arial", Font.BOLD, 12));

        // Creates the two necessary Text Areas
        JTextArea t1 = new JTextArea();
        JTextArea t2 = new JTextArea();

        // Enables line wrapping when text goes beyond the size of the box
        t1.setLineWrap(true);
        t2.setLineWrap(true);

        // Enables scrolling for both text areas
        JScrollPane left = new JScrollPane(t1);
        JScrollPane right = new JScrollPane(t2);

        // Sets the size of the left and right JBoxes
        JBox.setSize(left, 400, 500);
        JBox.setSize(right, 400, 500);

        // Uses the LaTeX vspace and hspace commands to space out the JBox
        JBox body = 
            JBox.vbox(
                .5F, new Component[] 
                { JBox.vspace(25), l1, JBox.vglue(), l2, JBox.vglue(), JBox.hbox(.5F, new Component[] 
                        { JBox.vbox(.5F, new Component[] 
                                { l3, JBox.vspace(20), left, JBox.vspace(20), b1 }), JBox.hspace(15), b2, JBox.hspace(15), 
                            JBox.vbox(.5F, new Component[] 
                                { l4, JBox.vspace(20), right, JBox.vspace(20), b3 }) }), JBox.vspace(25) });

        // Enable the body of the GUI                
        frame.add(body);
        frame.setVisible(true);

        // Creates an Event Queue
        JEventQueue events = new JEventQueue();
        // Tells the computer to listen for the following buttons
        events.listenTo(b1, "Clear1");
        events.listenTo(b2, "Build");
        events.listenTo(b3, "Clear2");
        while (true) {
            // Gives each event a string name using an event object
            EventObject event = events.waitEvent();
            String name = JEventQueue.getName(event);
            if (name.equals("Clear1")) {
                t1.setText(""); // Clears the left pane when Clear is pressed
            } else if (name.equals("Build")) {
                // Calls the wordlist when build is pressed and sets the right pane to the returned string
                String text = t1.getText();
                WordList W = new WordList();
                splitWords(text, W);
                t2.setText(W.getString());
            } else if (name.equals("Clear2")) {
                t2.setText(""); // Clears the right pane when Clear is pressed
            }
        }
    }
}