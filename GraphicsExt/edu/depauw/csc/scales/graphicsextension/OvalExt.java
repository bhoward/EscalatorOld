package edu.depauw.csc.scales.graphicsextension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

/**
 * This is meant as a better version of the Ellipse2D class.  The improvement lies in the 
 * fact that the oval knows its own color, and is responsible for painting itself.
 * 
 * @author Cory Boatright, boatright@hiram.edu
 * @version June 12, 2007
 */
public class OvalExt extends Ellipse2D.Double implements ExtendedShape
{
	private Color extColor;
	private Color intColor;
	
	/**
	 * Default constructor
	 * 
	 * @param x The x-coordinate of the top left corner of the bounding box of the oval
	 * @param y The y-coordinate of the top left corner of the bounding box of the oval
	 * @param w The width of the oval
	 * @param h The height of the oval
	 */
	public OvalExt(double x, double y, double w, double h)
	{
		super(x, y, w, h);
		extColor = Color.BLACK;
		intColor = Color.BLACK;
	}
	
	/**
	 * Constructor which allows the square to be given a custom color during creation.
	 * 
	 * @param x The x-coordinate of the top left corner of the bounding box of the oval
	 * @param y The y-coordinate of the top left corner of the bounding box of the oval
	 * @param w The width of the oval
	 * @param h The height of the oval
	 * @param c The color of the oval
	 */
	public OvalExt(double x, double y, double w, double h, Color c)
	{
		super(x, y, w, h);
		extColor = c;
		intColor = c;
	}
	
	/**
	 * Constructor which allows the oval to be given a custom interior color and
	 * a different outline color.
	 * 
	 * @param x The x-coordinate of the top left corner of the bounding box of the oval
	 * @param y The y-coordinate of the top left corner of the bounding box of the oval
	 * @param w The width of the oval
	 * @param h The height of the oval
	 * @param ext The outline color of the oval
	 * @param inside The fill color of the oval
	 */
	public OvalExt(double x, double y, double w, double h, Color ext, Color inside)
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
	 * Paints the oval.
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
	 * Translates the oval along the x- and y-axis
	 * 
	 * @param x The amount and direction to move the oval with respect to the x-axis
	 * @param y The amount and direction to move the oval with respect to the y-axis
	 */
	public void translate(double x, double y)
	{
		super.x += x;
		super.y += y;
	}
	
	/**
	 * Scales the oval by the given ratio
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