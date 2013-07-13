/*
 *  DrawFrame.java   
 *
 *  Description: This class provides a GUI for the user in the paint program. It provides buttons and dropbox menus.
 *  It initiates a draw panel to provide a drawing space for the user. Buttons allow user to change settings.
 *
 *  Name: Kent Chow
 *
 *  Date: March 19, 2013
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class DrawFrame extends JFrame
{
    private JButton undoButton;
    private JButton redoButton;
    private JButton clearButton;
    private JComboBox colorsJComboBox;
    private JComboBox shapesJComboBox;
    private JCheckBox filledJCheckBox;
    private DrawPanel panel;
    private JPanel buttonJPanel;
    private final int AMOUNTOFBUTTONS = 6;
    private String colorNames[] = { "Black",  "Blue", "Cyan", "Gray", "Green", "Magenta",
      "Orange", "Pink", "Red", "Yellow", "Dark Gray", "Light Gray", "White" };
    private Color colors[] = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN,
      Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.WHITE };
    private String shapeNames[] = { "Line",  "Oval", "Rectangle" };
    
    /*
     * Constructor initiates buttons, comboboxes, checkboxes, and draw panel. Also sets screen properties No arguments. 
     */ 
    public DrawFrame() 
    {
        //Initiate title and layout of frame
        super( "SuperPaint Application!" );
        setLayout( new BorderLayout() );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize( 600, 600 );
 
        //Initiate draw panel and add it to the center
        panel = new DrawPanel( new JLabel("Use mouse to draw.") );
        add( panel, BorderLayout.CENTER );
        
        //Initiate a panel to store buttons
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout( new GridLayout( 1, AMOUNTOFBUTTONS, 20, 0 ));
        
        //Initiate JButtons and add to panel
        undoButton = new JButton("Undo");
        buttonJPanel.add(undoButton);
        redoButton = new JButton("Redo");
        buttonJPanel.add(redoButton);
        clearButton = new JButton("Clear");
        buttonJPanel.add(clearButton);
        
        //Iniiate ComboBoxes and add to panel
        colorsJComboBox = new JComboBox( colorNames );
        colorsJComboBox.setMaximumRowCount(13);
        buttonJPanel.add(colorsJComboBox);
        shapesJComboBox = new JComboBox( shapeNames );
        shapesJComboBox.setMaximumRowCount(3);
        buttonJPanel.add(shapesJComboBox);
        
        //Initiate CheckBoxes and add to panel
        filledJCheckBox = new JCheckBox( "Filled" );
        buttonJPanel.add(filledJCheckBox);

        //Add button panel into draw panel
        add(buttonJPanel, BorderLayout.NORTH);
        
        //BUTTON HANDLING
        //Assign JButtons to handler
        ButtonHandler buttonHandler = new ButtonHandler();
        undoButton.addActionListener( buttonHandler );
        redoButton.addActionListener( buttonHandler );
        clearButton.addActionListener( buttonHandler );
        
        //Assign CheckBoxes to handler
        CheckBoxHandler checkBoxHandler = new CheckBoxHandler();
        filledJCheckBox.addItemListener( checkBoxHandler );
        
        //Assign Comboxes to handler 
        ComboBoxHandler comboBoxHandler = new ComboBoxHandler();
        colorsJComboBox.addItemListener( comboBoxHandler );
        shapesJComboBox.addItemListener( comboBoxHandler );
            
        //Make frame visible
        setVisible( true );
    }
    
    //Inner class for button event handling
    private class ButtonHandler implements ActionListener 
    {
        public void actionPerformed( ActionEvent event )
        {
            if ( event.getSource() == undoButton ) {
                panel.clearLastShape();
            }
            else if ( event.getSource() == redoButton ) {
                panel.redoLastShape();
            }
            else if ( event.getSource() == clearButton ) {
                panel.clearDrawing();
            }
        }
    }
    
    //Inner class for checkbox event handling
    private class CheckBoxHandler implements ItemListener 
    {
        public void itemStateChanged( ItemEvent event )
        {
            if ( event.getSource() == filledJCheckBox ) {
                panel.setCurrentShapeFilled();
            }
        }
    }
    
    //Inner class for combobox event handling
    private class ComboBoxHandler implements ItemListener 
    {
        public void itemStateChanged( ItemEvent event )
        {
            if ( event.getSource() == colorsJComboBox ) {
                panel.setCurrentShapeColor(colors[colorsJComboBox.getSelectedIndex()]); //Change the shape color
            }
            else if ( event.getSource() == shapesJComboBox ) {
                panel.setCurrentShapeType(shapesJComboBox.getSelectedIndex()); //Change the shape type
            }      
        }
    }
    
}