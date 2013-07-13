/*
 *  MyRectangle.java   
 *
 *  Description: This class is used for drawing rectangles on the screen.
 *
 *  Name: Kent Chow
 *
 *  Date: January 17, 2013
 */

import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyBoundedShape
{
    
    /*
     * Constructor used to initiate default coordinates and properties of shape. No parameters. No returns.
     */ 
    public MyRectangle()
    {
        super();
    }
    
    /*
     * Constructor used to initiate coordinates and properties of shape based on inputs. Parameters include
     * x and y coordinates, colour, and whether shape is filled or not. No returns.
     */
    public MyRectangle( int x1, int y1, int x2, int y2, Color colour, boolean filled )
    {
        super(x1, y1, x2, y2, colour, filled);
    } 
    
    /*
     * This method draws a rectangle using x and y coordinates, colour, and whether shape is filled or not. 
     * Needs Graphics object for parameter. No returns.
     */ 
    public void draw( Graphics g )
    {
        g.setColor(getColour());
        if (getFilled())
            g.fillRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
        else
            g.drawRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
    }
}