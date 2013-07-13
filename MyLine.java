/*
 *  MyLine.java   
 *
 *  Description: This class is used for drawing lines on the screen.
 *
 *  Name: Kent Chow
 *
 *  Date: January 17, 2013
 */

import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape
{
    
    /*
     * Constructor used to initiate default coordinates and properties of shape. No parameters. No returns.
     */ 
    public MyLine()
    {
        super();
    }

    /*
     * Constructor used to initiate coordinates and properties of shape based on inputs. Parameters include
     * x and y coordinates, and colour. No returns.
     */
    public MyLine( int x1, int y1, int x2, int y2, Color colour )
    {
        super(x1, y1, x2, y2, colour);
    }
     
    /*
     * This method draws a line using x and y coordinates, and colour. Needs Graphics object for parameter. No returns.
     */ 
    public void draw( Graphics g )
    {
        g.setColor(getColour());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}
