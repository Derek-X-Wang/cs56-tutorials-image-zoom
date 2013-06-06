package edu.ucsb.cs56.projects.misc.map_gui;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Dimension;
/**
 * TheGUI class creates the interface using swing for image GUI. 
 * @author Aki Stankoski and Dennis Huynh
 */


public class TheGUI{
    //declare the panels and buttons to be accessed from multiple methods  

    JFrame frame            =      new JFrame("UCSB Campus Map");//main frame
    JPanel thePanel         =      new JPanel();//Back homescreen panel
    JPanel newPanel         =      new JPanel();// New panel when button is clicked
    JPanel leftPanel        =      new JPanel();//Left homescreen panel
    JPanel rightPanel       =      new JPanel();//Right homescreen panel
    JPanel bottomPanel      =      new JPanel();//Bottom subpanels
    JPanel topPanel         =      new JPanel();//Top subpanels
    JPanel infoPanel        =      new JPanel();//info panel on subpanels
    JButton T387            =      new JButton("387");//button for Trailer 387
    JButton cancel          =      new JButton("Cancel");//cancel button for subscreens
    JButton ZoomIn          =      new JButton("Zoom +");
    JButton ZoomOut         =      new JButton("Zoom -");
    JButton ZoomInT387      =      new JButton("Zoom +");
    JButton ZoomOutT387     =      new JButton("Zoom -");

    JLabel T387Label    =      new JLabel("387 - Trailer 387");
 
    
    //building information
    String T387Info =//directions to get to trailer 387 from storke tower
	"1 Start by making your way towards the University Center.\n"
	+"\n"        
	+"2 Once you get to the University Center make a left.\n"                           
	+"\n" 
	+"3 Coninue walking straight until you get to the bike path. "
	+"Cross the bike path and cross the parking lot.\n"
	+"\n" 
	+"4 Trailer 387 will be the building parallel to the parking"
	+ "lot on the right side of the parking lot.";
    
    //function to set up the homescreen
    public void setUpHomeScreen() throws IOException{
	guiRemoveAll();//starts by clearing all GUIs
	newPanel.setBackground(Color.WHITE);//creates new panel for the directions to Trailer 387
	newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));//sets the new panel to a BoxLayout
	newPanel.setSize(800,625);//sets the size of new panel

	JTextArea T387TA = new JTextArea(T387Info);//creates a new space for text for directions
	T387TA.setEditable(false);//makes the new text area NOT editable
	T387TA.setLineWrap(true);//allows the lines to go to the next line if the current on is full
	T387TA.setWrapStyleWord(true);//allows long words to break off and continue in the proceeding line
	JScrollPane T387Scroll = new JScrollPane(T387TA);//creates a new scrollable widget
	T387Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//allows for scrolling on that widget
	T387TA.setPreferredSize(new Dimension(200,600));//sets the size of the text area
	infoPanel.add(T387Scroll);//adds the scrollin
	bottomPanel.add(Box.createRigidArea(new Dimension(200,50)));
	bottomPanel.add(cancel);//adds a cancel button on the panel located at the bottom of the frame
	newPanel.add(bottomPanel);//adds the bottom panel onto the new panel that has the directions to Trailer 387
	topPanel.add(T387Label);//adds the label to the top panel
	cancel.addActionListener(new CancelActionListener());//adds a new ActionListener to the Cancel button
	java.net.URL T387_URL = getClass().getResource("/387.jpg");//getClass().getResource loads the 387.jpg image, which has a line that directs from storke to the location
	ImageIcon icon = new ImageIcon(T387_URL);
	JLabel T387label = new JLabel(icon);//Creates a new label for the loaded image
	
	ZoomInT387.setPreferredSize(new Dimension(100,50));
	bottomPanel.add(Box.createRigidArea(new Dimension(200,50)));
	bottomPanel.add(ZoomInT387);
	ZoomInT387.addActionListener(new ZoomInT387ActionListener());
	

	//String Path = "387.jpg";
	//File File = new File(Path);
	//BufferedImage Image = ImageIO.read(File);
	//JLabel label = new JLabel(new ImageIcon(Image));


	newPanel.setMaximumSize(new Dimension(200,200));
	
	newPanel.add(T387label);//adds the image label onto the new panel
	frame.getContentPane().add(BorderLayout.EAST, infoPanel);//puts the panel with the direction text to the right side of the frame
	frame.getContentPane().add(BorderLayout.NORTH, topPanel);//adds the top panel including the label to the top of the frame
	frame.getContentPane().add(BorderLayout.CENTER,newPanel);//adds the new panel on the center of the frame
	frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);//adds the bottom panel, or the pannel with the cancel button, to the bottom of the frame
	frame.setSize(1000,625);//sets the size of the frame 
	


	frame.setBackground(Color.WHITE);//sets the background color of the frame to white
	frame.setVisible(true);//enables us to see the frame
    }//end setUpHomeScreen
    
    //function to clear the main frame
    /**
     * Removes all components of the frame, useful before switching panels
     */
    public void guiRemoveAll() {
    	////this wipes the frame clean, use before switching panels
	leftPanel.removeAll();
	rightPanel.removeAll();
	bottomPanel.removeAll();
	topPanel.removeAll();
	infoPanel.removeAll();
	thePanel.removeAll();
	newPanel.removeAll();
	frame.getContentPane().removeAll();
	frame.getContentPane().remove(thePanel);
	frame.getContentPane().remove(newPanel);
	frame.validate();
	frame.repaint();
    }//end guiRemoveAll
    

    class ZoomInT387ActionListener implements ActionListener{
	public void actionPerformed(ActionEvent event){

	    guiRemoveAll();//deletes current panels on the frame and creates a new one
	    newPanel.setLayout(null); //added 8:51am
	    newPanel.setBackground(Color.WHITE);//creates new panel for the directions to Trailer 387
	    //newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));//sets the new panel to a BoxLayout
	    newPanel.setSize(1000,625);//sets the size of new panel
	    
	    JTextArea T387TA = new JTextArea(T387Info);//creates a new space for text for directions
	    T387TA.setEditable(false);//makes the new text area NOT editable
	    T387TA.setLineWrap(true);//allows the lines to go to the next line if the current on is full
	    T387TA.setWrapStyleWord(true);//allows long words to break off and continue in the proceeding line
	    JScrollPane T387Scroll = new JScrollPane(T387TA);//creates a new scrollable widget
	    T387Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//allows for scrolling on that widget
	    T387TA.setPreferredSize(new Dimension(200,600));//sets the size of the text area
	    infoPanel.add(T387Scroll);//adds the scrollin
	    bottomPanel.add(Box.createRigidArea(new Dimension(200,50)));
	    bottomPanel.add(cancel);//adds a cancel button on the panel located at the bottom of the frame
	    newPanel.add(bottomPanel);//adds the bottom panel onto the new panel that has the directions to Trailer 387
	    topPanel.add(T387Label);//adds the label to the top panel
	    cancel.addActionListener(new CancelActionListener());//adds a new ActionListener to the Cancel button
	    java.net.URL T387_URL = getClass().getResource("/387.jpg");//getClass().getResource loads the 387.jpg image, which has a line that directs from storke to the location
	    
	    ImageIcon icon = new ImageIcon(T387_URL);
	    Image image = icon.getImage();
	    Image ZoomedIn = image.getScaledInstance(2000, 1200, Image.SCALE_SMOOTH);
	    ImageIcon finalIcon = new ImageIcon(ZoomedIn);
	    JLabel T387label = new JLabel(finalIcon);//Creates a new label for the loaded image
	  
	    ZoomOutT387.setPreferredSize(new Dimension(100,50));
	    bottomPanel.add(Box.createRigidArea(new Dimension(200,50)));
	    bottomPanel.add(ZoomOutT387);
	    ZoomOutT387.addActionListener(new ZoomOutT387ActionListener());
	    
	    //String Path = "387.jpg";
	    //File File = new File(Path);
	    //BufferedImage Image = ImageIO.read(File);
	    //JLabel label = new JLabel(new ImageIcon(Image));
     
	    T387label.setLocation(-550,-900);	//sets location of resized label	    
	    T387label.setSize(new Dimension(2000,2000));//sets size of resized label
	    //T387Label.setVisible(false);
	    // newPanel.setMaximumSize(new Dimension(200,200));//added 12:35 edited from 20/20 to 200/200
	    //newPanel.setVisible(false);
	      //    T387label.setLocation(-50,-200);

	    newPanel.add(T387label);//adds the image label onto the new panel
		    
	    frame.getContentPane().add(BorderLayout.EAST, infoPanel);//puts the panel with the direction text to the right side of the frame
	    frame.getContentPane().add(BorderLayout.NORTH, topPanel);//adds the top panel including the label to the top of the frame
	    frame.getContentPane().add(BorderLayout.CENTER,newPanel);//adds the new panel on the center of the frame
	    frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);//adds the bottom panel, or the pannel with the cancel button, to the bottom of the frame
	    frame.setSize(1000,625);//sets the size of the frame
	    frame.setBackground(Color.WHITE);//sets the background color of the frame to white
	    frame.setVisible(true);//enables us to see the frame
	}
    }

   class ZoomOutT387ActionListener implements ActionListener{
      	 public void actionPerformed(ActionEvent event){
	    guiRemoveAll();//deletes current panels on the frame and creates a new one
	    newPanel.setBackground(Color.WHITE);//creates new panel for the directions to Trailer 387
	    newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));//sets the new panel to a BoxLayout
	    newPanel.setSize(800,625);//sets the size of new panel
	    
	    JTextArea T387TA = new JTextArea(T387Info);//creates a new space for text for directions
	    T387TA.setEditable(false);//makes the new text area NOT editable
	    T387TA.setLineWrap(true);//allows the lines to go to the next line if the current on is full
	    T387TA.setWrapStyleWord(true);//allows long words to break off and continue in the proceeding line
	    JScrollPane T387Scroll = new JScrollPane(T387TA);//creates a new scrollable widget
	    T387Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//allows for scrolling on that widget
	    T387TA.setPreferredSize(new Dimension(200,600));//sets the size of the text area
	    infoPanel.add(T387Scroll);//adds the scrollin
	    bottomPanel.add(Box.createRigidArea(new Dimension(200,50)));
	    bottomPanel.add(cancel);//adds a cancel button on the panel located at the bottom of the frame
	    newPanel.add(bottomPanel);//adds the bottom panel onto the new panel that has the directions to Trailer 387
	    topPanel.add(T387Label);//adds the label to the top panel
	    cancel.addActionListener(new CancelActionListener());//adds a new ActionListener to the Cancel button
	    java.net.URL T387_URL = getClass().getResource("/387.jpg");//getClass().getResource loads the 387.jpg image, which has a line that directs from storke to the location
	    ImageIcon icon = new ImageIcon(T387_URL);
	    JLabel T387label = new JLabel(icon);//Creates a new label for the loaded image
	    
	    
	    ZoomInT387.setPreferredSize(new Dimension(100,50));
	    bottomPanel.add(Box.createRigidArea(new Dimension(200,50)));
	    bottomPanel.add(ZoomInT387);
	    ZoomInT387.addActionListener(new ZoomInT387ActionListener());

	    //String Path = "387.jpg";
	    //File File = new File(Path);
	    //BufferedImage Image = ImageIO.read(File);
	    //JLabel label = new JLabel(new ImageIcon(Image));
	    newPanel.add(T387label);//adds the image label onto the new panel
	    frame.getContentPane().add(BorderLayout.EAST, infoPanel);//puts the panel with the direction text to the right side of the frame
	    frame.getContentPane().add(BorderLayout.NORTH, topPanel);//adds the top panel including the label to the top of the frame
	    frame.getContentPane().add(BorderLayout.CENTER,newPanel);//adds the new panel on the center of the frame
	    frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);//adds the bottom panel, or the pannel with the cancel button, to the bottom of the frame
	    frame.setSize(1000,625);//sets the size of the frame
	    frame.setBackground(Color.WHITE);//sets the background color of the frame to white
	    frame.setVisible(true);//enables us to see the frame
       
	    }
    }




    //action listener class for the cancel button
    class CancelActionListener implements ActionListener{//the action listener when the cancel button is pressed
	public void actionPerformed(ActionEvent event){//the action that is performed after pressing cancel on one of the direction guis
	    System.exit(0);
	    
	}
    }//end CancelActionListener


    
    
} //end class

