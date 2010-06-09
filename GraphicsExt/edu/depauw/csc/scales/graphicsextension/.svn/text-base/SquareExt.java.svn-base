package edu.depauw.csc.scales.graphicsextension;

import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 * This is meant as a better version of the Rectangle2D class, with equal sides.  The
 * improvement lies in the fact that the Square knows its own color, and is responsible
 * for painting itself.
 * 
 * @author Cory Boatright, boatrightcd@hiram.edu
 * @version June 12, 2007
 */
public class SquareExt extends Rectangle2D.Double implements ExtendedShape
{
	private Color extColor;
	private Color intColor;
	
	/**
	 * Default constructor
	 * 
	 * @param x The x-coordinate of the top left corner of the square.
	 * @param y The y-coordinate of the top left corner of the square.
	 * @param l The length of any given side of the square.
	 */
	public SquareExt(double x, double y, double l)
	{
		super(x, y, l, l);
		extColor = Color.BLACK;
		intColor = Color.BLACK;
	}
	
	/**
	 * Constructor which allows the square to be given a custom color during creation.
	 * 
	 * @param x The x-coordinate of the top left corner of the square.
	 * @param y The y-coordinate of the top left corner of the square.
	 * @param l The length of any given side of the square.
	 * @param c The color of the square
	 */
	public SquareExt(double x, double y, double l, Color c)
	{
		super(x, y, l, l);
		extColor = c;
		intColor = c;
	}
	
	/**
	 * Constructor which allows the square to be given a custom interior color and
	 * a different outline color.
	 * 
	 * @param x The x-coordinate of the top left corner of the square.
	 * @param y The y-coordinate of the top left corner of the square.
	 * @param l The length of any given side of the square.
	 * @param ext The outline color of the square.
	 * @param inside The fill color of the square.
	 */
	public SquareExt(double x, double y, double l, Color ext, Color inside)
	{
		super(x, y, l, l);
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
	 * Paints the square.
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
	 * Translates the square along the x- and y-axis
	 * 
	 * @param x The amount and direction to move the square with respect to the x-axis
	 * @param y The amount and direction to move the square with respect to the y-axis
	 */
	public void translate(double x, double y)
	{
		super.x += x;
		super.y += y;
	}
	
	/**
	 * Scales the square by the given ratio
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
