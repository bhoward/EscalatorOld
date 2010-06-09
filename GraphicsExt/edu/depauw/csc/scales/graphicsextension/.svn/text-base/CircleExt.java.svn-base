package edu.depauw.csc.scales.graphicsextension;

import java.awt.geom.Ellipse2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 * This is meant as a better version of the Ellipse2D class, with even sides.  The improvement 
 * lies in the fact that the Circle knows its own color, and is responsible for painting itself.
 * 
 * @author Cory Boatright, boatrightcd@hiram.edu
 * @version June 12, 2007
 */
public class CircleExt extends Ellipse2D.Double implements ExtendedShape
{
	private Color extColor;
	private Color intColor;
	
	/**
	 * Default constructor
	 * 
	 * @param x The x-coordinate of the top left corner of the bounding box of the circle
	 * @param y The y-coordinate of the top left corner of the bounding box of the circle
	 * @param d The diameter of the circle
	 */
	public CircleExt(double x, double y, double d)
	{
		super(x, y, d, d);
		extColor = Color.BLACK;
		intColor = Color.BLACK;
	}
	
	/**
	 * Constructor which allows the circle to be given a custom color during creation.
	 * 
	 * @param x The x-coordinate of the top left corner of the bounding box of the circle
	 * @param y The y-coordinate of the top left corner of the bounding box of the circle
	 * @param d The diameter of the circle
	 * @param c The color of the circle
	 */
	public CircleExt(double x, double y, double d, Color c)
	{
		super(x, y, d, d);
		extColor = c;
		intColor = c;
	}
	
	/**
	 * Constructor which allows the circle to be given a custom interior color and
	 * a different outline color.
	 * 
	 * @param x The x-coordinate of the top left corner of the bounding box of the circle
	 * @param y The y-coordinate of the top left corner of the bounding box of the circle
	 * @param d The diameter of the circle
	 * @param ext The outline color of the circle
	 * @param inside The fill color of the circle
	 */
	public CircleExt(double x, double y, double d, Color ext, Color inside)
	{
		super(x, y, d, d);
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
	 * Paints the circle.
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
	 * Translates the circle along the x- and y-axis
	 * 
	 * @param x The amount and direction to move the circle with respect to the x-axis
	 * @param y The amount and direction to move the circle with respect to the y-axis
	 */
	public void translate(double x, double y)
	{
		super.x += x;
		super.y += y;
	}
	
	/**
	 * Scales the circle by the given ratio
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
