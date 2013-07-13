/*
 *  MyBoundedShapes.java   
 *
 *  Description: This class contains methods and variables that can be inherited by rectangle and ovals.
 *
 *  Name: Kent Chow
 *
 *  Date: January 17, 2013
 */

import java.awt.Color;
import java.awt.Graphics;

abstract class MyBoundedShape extends MyShape
{
    private boolean filled;
     
    /*
     * Constructor used to initiate default coordinates and properties of shape. No parameters. No returns.
     */ 
    public MyBoundedShape()
    {
        super();
        filled = false;
    }
    
    /*
     * Constructor used to initiate coordinates and properties of shape based on inputs. Parameters include
     * x and y coordinates, colour, and whether shape is filled. No returns.
     */
    public MyBoundedShape(int x1, int y1, int x2, int y2, Color colour, boolean filled)
    {
        super(x1, y1, x2, y2, colour);
        this.filled = filled;
    } 
    
    /*
     * Returns the minimum x coordinate of shape. No parameters.
     */ 
    public int getUpperLeftX()
    {
        return Math.min(getX1(), getX2());      
    }
    
    /*
     * Returns the minimum y coordinate of shape. No parameters.
     */ 
    public int getUpperLeftY()        
    {
        return Math.min(getY1(), getY2());
    }
    
    /*
     * Returns the absolute difference between both x coordinates of shape. 
     * This value represents shape's width. No parameters.
     */ 
    public int getWidth()
    {
        return Math.abs(getX1() - getX2());
    }
    
    /*
     * Returns the absolute difference between both y coordinates of shape. 
     * This value represents shape's height. No parameters.
     */ 
    public int getHeight()
    {
        return Math.abs(getY1() - getY2());
    }
    
    /*
     * Returns whether shape is filled or not. No parameters.
     */ 
    public boolean getFilled()
    {
        return filled;
    }
    
    /*
     * Sets whether shape is filled or not. Needs a boolean value as parameter. No returns.
     */ 
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }
    
    /*
     * Inheriting classes requires an overriding draw method that is used for drawing its specific shape.
     */ 
    public abstract void draw(Graphics g);  
}