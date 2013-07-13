/*
 *  DrawPanel.java   
 *
 *  Description: This class simulates a paint program. It allows the user to draw various shapes using mouse control.
 *
 *  Name: Kent Chow
 *
 *  Date: March 19, 2013
 */

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class DrawPanel extends JPanel
{
    private LinkedList<MyShape> shapeObjects;
    private LinkedList<MyShape> redoShapeObjects;
    private int currentShapeType;
    private MyShape currentShapeObject;
    private Color currentShapeColor;
    private boolean currentShapeFilled;
    private JLabel statusLabel;
    private final int LINE = 0;
    private final int OVAL = 1;
    private final int RECTANGLE = 2;
    
    /*
     * Constructor accepts a label as an argument. It initiates linkedlists to store shape objects, shape color,
     * shape type, background color, mouse handlers, and status labels.
     */ 
    public DrawPanel( JLabel label )
    {
        //Initiate linkedlists to store redone shapes and shapes to draw
        shapeObjects = new LinkedList<MyShape>();
        redoShapeObjects = new LinkedList<MyShape>();

        //Initiate shape properties
        currentShapeType = LINE;
        currentShapeColor = Color.BLACK;
        setBackground( Color.WHITE );
  
        //Initiate mouse handling
        addMouseListener( new MouseClickHandler() );
        addMouseMotionListener( new MouseClickHandler() );
        
        //Initiate status label and layout
        statusLabel = label;
        statusLabel.setBackground(Color.lightGray);
        statusLabel.setOpaque(true);
        setLayout( new BorderLayout() );
        add(statusLabel, BorderLayout.SOUTH);
    }
    
    /*
     * This method goes through all stored shapes and draws them on the screen. Needs Graphics object for parameter.
     * No returns.
     */ 
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        MyShape temp; //Temporary variable to store shapes
        //Iterate through shapes to draw
        for (int i = 0; i < shapeObjects.size(); i++)
        {
            temp = shapeObjects.removeFront();
            temp.draw(g);
            shapeObjects.addEnd(temp);
        }
        //Update current object when dragging
        if (currentShapeObject != null)
            currentShapeObject.draw(g);
    }
    
    /*
     * Sets the shape type. Needs an integer value as argument. No returns.
     */ 
    public void setCurrentShapeType( int shape ) 
    {
        currentShapeType = shape;
    }
    
    /*
     * Sets the shape color. Needs an color object as argument. No returns.
     */ 
    public void setCurrentShapeColor( Color color)
    {
        currentShapeColor = color;
    }
    
    /*
     * Sets whether shape is filled or not. No arguments. No returns.
     */ 
    public void setCurrentShapeFilled()
    {
        //If filled is true, set to false. If false, set to true.
        currentShapeFilled = !currentShapeFilled;
    }
    
    /*
     * Removes one object from redoShapesObjects back into shapesObjects. No arguments. No returns.
     */ 
    public void clearLastShape()
    {
        if (shapeObjects.size() > 0)
            redoShapeObjects.addFront(shapeObjects.removeEnd());
        repaint();
    }
    
    /*
     * Removes one object from shapesObjects back into redoShapesObjects. No arguments. No returns.
     */ 
    public void redoLastShape()
    {
        if (redoShapeObjects.size() > 0)
            shapeObjects.addEnd(redoShapeObjects.removeFront());
        repaint();
    }
    
    /*
     * Removes all objects in redoShapesObjects and in shapesObjects. No arguments. No returns.
     */ 
    public void clearDrawing()
    {
        shapeObjects.makeEmpty();
        redoShapeObjects.makeEmpty();
        repaint();
    }
    
    //Inner class for handling mouse events
    private class MouseClickHandler extends MouseAdapter 
    {
        //Handle events when mouse is pressed
        public void mousePressed( MouseEvent event )
        {
          //Create new shapes based on settings and mouse position
            if (currentShapeType == LINE) {
                currentShapeObject = new MyLine(event.getX(), event.getY(), event.getX(), event.getY(), currentShapeColor);
            }
            else if (currentShapeType == OVAL) {
                currentShapeObject = new MyOval(event.getX(), event.getY(), event.getX(), event.getY(), currentShapeColor, currentShapeFilled);
            }
            else if (currentShapeType == RECTANGLE) {
                currentShapeObject = new MyRectangle(event.getX(), event.getY(), event.getX(), event.getY(), currentShapeColor, currentShapeFilled);
            }
            redoShapeObjects.makeEmpty(); //Make redo linked list empty
        }
        
        //Handle events when mouse is released
        public void mouseReleased( MouseEvent event )
        {
          //Update shape position
            currentShapeObject.setX2(event.getX());
            currentShapeObject.setY2(event.getY());
            //Add shape into linkedlist
            shapeObjects.addEnd(currentShapeObject);
            currentShapeObject = null;
            //Update screen
            repaint();
        }
        
        //Handle events when mouse is moved
        public void mouseMoved( MouseEvent event )
        {
          //Update label
            statusLabel.setText( "(" + event.getX() + "," + event.getY() + ")" );
        }
        
        //Handle events when mouse is dragged
        public void mouseDragged( MouseEvent event )
        {
            //Update shape position
            currentShapeObject.setX2(event.getX());
            currentShapeObject.setY2(event.getY());
            //Update screen 
            repaint();
            //Update label
            statusLabel.setText( "(" + event.getX() + "," + event.getY() + ")" );
        }
    }
}