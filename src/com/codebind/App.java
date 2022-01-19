package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * GUI
 * AOL Instant Messenger Mimicker
 * @author Kevin Phouisangiem
 */
public class App extends JPanel {
    static App app;
    private JFrame frame;
    private JPanel panelMain;
    private JTextArea chatLogs;
    private JButton sendButton;
    private JTextArea userInput;
    private JTextField textField1;
    private Dimension dimension;
    private int width;
    private int height;

    /**
     * Default Constructor
     */
    public App(){
        width = 800;
        height = 600;
        this.dimension = new Dimension(width, height);
    }

    /**
     *  Constructor with new resolution size
     */
    public App(int width, int height){
        this.width = width;
        this.height = height;
        this.dimension = new Dimension(this.width ,this.height);
    }

    /**
     * Sets up and loads the GUI
     */
    public void setup(){
        frame = new JFrame("Instant Message");   // Frame of App & Title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Closes app when X is pressed
        setIcon(frame); // Sets AOL icon
        MenuBar menuBar = new MenuBar(frame); // creates menu bar
        sendButton.addActionListener(menuBar);  // adds menuBar's sound effects when clicked

        frame.setContentPane(panelMain);
        // sizes the GUI
        frame.setPreferredSize(dimension);
        frame.setMinimumSize(dimension);
        frame.setMaximumSize(dimension);
        frame.setSize(dimension);
        frame.setResizable(false); // disables resize
        frame.pack();   // packs
        //frame.setVisible(true); // makes frame appear
    }

    /**
     * Sets Icon for Application
     * @param frame - the frame to set icon
     */
    private static void setIcon(JFrame frame) {
        // Loads Image
        ImageIcon img = null;
        img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(App.class.getResource("icon.png")));
        if (img != null){
            frame.setIconImage(img.getImage());
        } else {
            System.out.println("Can't find icon.png");
        }
    }

    /**
     * Main Function
     * Runs Application
     * @param args
     */
    public static void main(String[] args) {
        app = new App();
        app.setup();
        app.userInput.setText("Press 1 2 or 3 to send a message.\n" +
                "1. hey!\n" +
                "2. howdy\n" +
                "3. sup dawg\n");
        app.userInput.setFont(app.getFont().deriveFont(24.0f));
        app.chatLogs.setFont(app.getFont().deriveFont(24.0f ));

        app.frame.setVisible(true);
        app.userInput.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyChar()){
                    case '1':
                        System.out.println("1 pressed");
                        System.out.println("hey!");
                        app.userInput.setText("Press any keys to start typing.\n" +
                        "hey!");
                        // waits for enter or button press
                        app.chatLogs.append("Mike: hey!\n");
                        break;
                    case '2':
                        System.out.println("2 pressed");
                        System.out.println("howdy!");
                        app.userInput.setText("Press any keys to start typing.\n" +
                                "howdy!");
                        // waits for enter or button press
                        app.chatLogs.append("Mike: howdy!\n");
                        break;
                    case '3':
                        System.out.println("3 pressed");
                        System.out.println("sup dawg!");
                        app.userInput.setText("Press any keys to start typing.\n" +
                                "sup dawg!");
                        // waits for enter or button press
                        app.chatLogs.append("Mike: sup dawg!\n");
                        break;
                }

                // clear userInputs
                // if it is a important dialogue choice, remember that
                // start typing
                //  while loop - (while not end of sentence) - increments up by 1 for each key press
                //  append char in the userInput    (typing sound fx)
                // can press enter or press the send button (click/typing sound fx)
                // uploads message to chatLogs
                // then the other user will start typing...
                // their message will appear    (msg sound fx)
                //
            }
        });
    }
}
