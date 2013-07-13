/*
 *  MyShape.java   
 *
 *  Description: This class contains methods and variables that can be inherited for drawing any shapes on the screen.
 *
 *  Name: Kent Chow
 *
 *  Date: January 17, 2013
 */

import java.awt.Color;
import java.awt.Graphics;

abstract class MyShape
{
    private int x1; // x coordinate of first endpoint
    private int y1; // y coordinate of first endpoint
    private int x2; // x coordinate of second endpoint
    private int y2; // y coordinate of second endpoint
    private Color colour; // color of this shape
    
    /*
     * Constructor used to initiate coordinates to 0 and colour to Black. No parameters. No returns.
     */ 
    public MyShape()
    {
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        colour = Color.BLACK;
    }
    
    /*
     * Constructor used to initiate coordinates and colour based on inputs. No returns.
     */ 
    public MyShape(int x1, int y1, int x2, int y2, Color colour)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.colour = colour;
    }
    
    /*
     * Sets the first x coordinate for shape. Needs an integer value to represent coordinate as parameter. No returns.
     */ 
    public void setX1(int x1)
    {
        this.x1 = x1;
    }
    
    /*
     * Sets the second x coordinate for shape. Needs an integer value to represent coordinate as parameter. No returns.
     */ 
    public void setX2(int x2)
    {
        this.x2 = x2;
    }
    
    /*
     * Sets the first y coordinate for shape. Needs an integer value to represent coordinate as parameter. No returns.
     */ 
    public void setY1(int y1)
    {
        this.y1 = y1;
    }
    
    /*
     * Sets the second y coordinate for shape. Needs an integer value to represent coordinate as parameter. No returns.
     */ 
    public void setY2(int y2)
    {
        this.y2 = y2;
    }
    
    /*
     * Sets the colour property for shape. Needs a Colour value as parameter. No returns.
     */ 
    public void setColour(Color colour)
    {
        this.colour = colour;
    }
    
    /*
     * Returns the first x coordinate. No parameters.
     */ 
    public int getX1()
    {
        return x1;
    }
    
    /*
     * Returns the second x coordinate. No parameters.
     */ 
    public int getX2()
    {
        return x2;
    }
    
    /*
     * Returns the first y coordinate. No parameters.
     */ 
    public int getY1()
    {
        return y1;
    }
    
    /*
     * Returns the second y coordinate. No parameters.
     */ 
    public int getY2()
    {
        return y2;
    }
    
    /*
     * Returns the Colour value of shape. No parameters.
     */ 
    public Color getColour()
    {
        return colour;
    }
   
    /*
     * Inheriting classes requires an overriding draw method that is used for drawing its specific shape.
     */
    public abstract void draw(Graphics g);    
}