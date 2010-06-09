package edu.depauw.csc.scales.graphicsextension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;

/**
 * This is meant as a better version of the Rectangle2D class.  The improvement lies in the 
 * fact that the Rectangle knows its own color, and is responsible for painting itself.
 * 
 * @author Cory Boatright, boatrightcd@hiram.edu
 * @version June 12, 2007
 */
public class RectangleExt extends Rectangle2D.Double implements ExtendedShape
{
	private Color extColor;
	private Color intColor;
	
	/**
	 * Default constructor, sets the color to black.
	 * 
	 * @param x The x-coordinate of the top left corner of the rectangle
	 * @param y The y-coordinate of the top left corner of the rectangle
	 * @param w The width of the rectangle
	 * @param h The height of the rectangle
	 */
	public RectangleExt(double x, double y, double w, double h)
	{
		super(x, y, w, h);
		extColor = Color.BLACK;
		intColor = Color.BLACK;
	}
	
	/**
	 * Constructor which allows the rectangle to be given a custom color during creation.
	 * 
	 * @param x The x-coordinate of the top left corner of the rectangle
	 * @param y The y-coordinate of the top left corner of the rectangle
	 * @param w The width of the rectangle
	 * @param h The height of the rectangle
	 * @param c The color of the square
	 */
	public RectangleExt(double x, double y, double w, double h, Color c)
	{
		super(x, y, w, h);
		extColor = c;
		intColor = c;
	}
	
	/**
	 * Constructor which allows the rectangle to be given a custom interior color and
	 * a different outline color.
	 * 
	 * @param x The x-coordinate of the top left corner of the rectangle
	 * @param y The y-coordinate of the top left corner of the rectangle
	 * @param w The width of the rectangle
	 * @param h The height of the rectangle
	 * @param ext The outline color of the rectangle
	 * @param inside The fill color of the rectangle
	 */
	public RectangleExt(double x, double y, double w, double h, Color ext, Color inside)
	{
		super(x, y, w, h);
		extColor = ext;
		intColor = inside;
	}
	
	/**
	 * Allows for the changing of the outline color.
	 * 
	 * @param newColor New outline color
	 */
	public void changeExtColor(Color newColor)
	{
		extColor = newColor;
	}
	
	/**
	 * Allows for the changing of the fill color.
	 * 
	 * @param newColor New fill color
	 */
	public void changeIntColor(Color newColor)
	{
		intColor = newColor;
	}
	
	/**
	 * Allows for the changing of both the outline and fill at the same time.
	 * 
	 * @param newIntColor New fill color
	 * @param newExtColor New outline color
	 */
	public void changeColors(Color newIntColor, Color newExtColor)
	{
		extColor = newExtColor;
		intColor = newIntColor;
	}
	
	/**
	 * Paints the rectangle.
	 * 
	 * @param g The graphics context.
	 */
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(intColor);
		g2.fill(this);
		g2.setColor(extColor);
		g2.draw(this);
	}
	
	/**
	 * Translates the rectangle along the x- and y-axis
	 * 
	 * @param x The amount and direction to move the rectangle with respect to the x-axis
	 * @param y The amount and direction to move the rectangle with respect to the y-axis
	 */
	public void translate(double x, double y)
	{
		super.x += x;
		super.y += y;
	}
	
	/**
	 * Scales the rectangle by the given ratio
	 * 
	 * @param change The double-precision result of dividing the ratio of new to old
	 */
	public void scale(double change)
	{
		super.x *= change;
		super.y *= change;
		super.height *= change;
		super.width *= change;
	}
	
}
