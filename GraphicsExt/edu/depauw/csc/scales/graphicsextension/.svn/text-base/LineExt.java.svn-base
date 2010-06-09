package edu.depauw.csc.scales.graphicsextension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Color;

/**
* This is meant as a better version of the Line2D class.  The improvement lies in the 
* fact that the line knows its own color, and is responsible for painting itself.
* 
* @author Cory Boatright
* @version June 12, 2007
*/
public class LineExt extends Line2D.Double implements ExtendedShape
{
	private Color color;
	
	/**
	 * Default constructor
	 * 
	 * @param x1 The value of the first point's x-coordinate
	 * @param y1 The value of the first point's y-coordinate
	 * @param x2 The value of the second point's x-coordinate
	 * @param y2 The value of the second point's y-coordinate
	 */
	public LineExt(double x1, double y1, double x2, double y2)
	{
		super(x1, y1, x2, y2);
		color = Color.BLACK;
	}
	
	/**
	 * Another non-color constructor because the Line2D has two constructors
	 * 
	 * @param p1 The first preconstructed point
	 * @param p2 The second preconstructed point
	 */
	public LineExt(Point2D p1, Point2D p2)
	{
		super(p1, p2);
		color = Color.BLACK;
	}
	
	/**
	 * The color-dependent version of the default constructor that uses coordinates
	 * 
	 * @param x1 The first point's x-coordinate
	 * @param y1 The first point's y-coordinate
	 * @param x2 The second point's x-coordinate
	 * @param y2 The second point's y-coordinate
	 * @param c The color of the line
	 */
	public LineExt(double x1, double y1, double x2, double y2, Color c)
	{
		super(x1, y1, x2, y2);
		color = c;
	}
	
	/**
	 * The color-dependent version of the constructor that uses predefined points
	 * 
	 * @param p1 The first preconstructed point
	 * @param p2 The second preconstructed point
	 * @param c The color of the line
	 */
	public LineExt(Point2D p1, Point2D p2, Color c)
	{
		super(p1, p2);
		color = c;
	}
	
	/**
	 * Allows the changing of the line's color
	 * 
	 * @param newColor The new color for the line
	 */
	public void changeColor(Color newColor)
	{
		color = newColor;
	}
	
	/**
	 * Paints the line.
	 * 
	 * @param g The graphics context
	 */
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(color);
		g2.draw(this);
	}
	
	/**
	 * Translates the line with respect to the x- and y-axis
	 * 
	 * @param x The amount and direction to move the line with respect to the x-axis
	 * @param y The amount and direction to move the line with respect to the y-axis
	 */
	public void translate(double x, double y)
	{
		super.x1 += x;
		super.x2 += x;
		super.y1 += y;
		super.y2 += y;
	}
	
	/**
	 * Scales the line according to the given ratio
	 * 
	 * @param change The double-precision result of dividing the ratio of new to old
	 */
	public void scale(double change)
	{
		super.x1 *= change;
		super.x2 *= change;
		super.y1 *= change;
		super.y2 *= change;
	}
}
