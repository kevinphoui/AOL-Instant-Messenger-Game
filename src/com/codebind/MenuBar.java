package com.codebind;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * Menu Bar Class
 * @author Kevin Phouisangiem
 */
public class MenuBar implements ActionListener, MenuListener {
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuEdit;
    private JMenu menuInsert;
    private JMenu menuPeople;
    private JMenuItem itemHelp;
    private JMenuItem itemResolution;
    private JMenuItem itemSettings;
    private JMenuItem itemFont;
    private JMenuItem itemAdd;
    AudioClip click;

    /**
     * Default constructor
     * @param frame - frame to add menu bar
     */
    public MenuBar(JFrame frame){
        menuBar = new JMenuBar(); // overall menu bar

        // File
        menuFile = new JMenu("File");
        itemHelp = new JMenuItem("Help");
        itemResolution = new JMenuItem("Change Resolution");
        itemSettings = new JMenuItem("Settings");
        menuFile.add(itemHelp); // adds JMenuItems to JMenu
        menuFile.add(itemResolution);
        menuFile.add(itemSettings);
        menuFile.addMenuListener(this); // Tracks when mouse clicks on buttons
        itemHelp.addActionListener(this);
        itemResolution.addActionListener(this);
        itemSettings.addActionListener(this);

        // Edit
        menuEdit = new JMenu("Edit");
        itemFont = new JMenuItem("Change Font");
        menuEdit.add(itemFont); // adds JMenuItems to JMenu
        menuEdit.addMenuListener(this); // Tracks when mouse clicks on buttons
        itemFont.addActionListener(this);

        // Insert
        menuInsert = new JMenu("Insert");
        menuInsert.addMenuListener(this);    // Tracks when mouse clicks on buttons

        // People
        menuPeople = new JMenu("People");
        itemAdd = new JMenuItem("Add Friends");
        menuPeople.add(itemAdd);   // adds JMenuItems to JMenu
        menuPeople.addMenuListener(this); // Tracks when mouse clicks on buttons
        itemAdd.addActionListener(this);

        // Adds JMenu to JMenuBar
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuInsert);
        menuBar.add(menuPeople);

        frame.setJMenuBar(menuBar); // Adds to Setting
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("menuItem clicked");
        URL urlClick = MenuBar.class.getResource("mouse_click_1.wav");
        click = Applet.newAudioClip(urlClick);
        click.play();
    }

    /**
     * Plays click sound when JMenu is clicked
     * @param e
     */
    @Override
    public void menuSelected(MenuEvent e) {
        System.out.println("JMenu clicked");
        URL urlClick = MenuBar.class.getResource("mouse_click_1.wav");
        click = Applet.newAudioClip(urlClick);
        click.play();
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
