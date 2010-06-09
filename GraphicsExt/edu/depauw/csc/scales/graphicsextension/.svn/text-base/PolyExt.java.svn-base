package edu.depauw.csc.scales.graphicsextension;

import java.awt.Polygon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 * This is meant as a better version of the Polygon class.  The improvement lies in the 
 * fact that the shape knows its own color, and is responsible for painting itself.
 * 
 * @author Cory Boatright, boatrightcd@hiram.edu
 * @version June 12, 2007
 */
public class PolyExt extends Polygon implements ExtendedShape
{
	private Color extColor;
	private Color intColor;
	
	/**
	 * Default constructor
	 * 
	 * @param xpoints An array of integer values for the x-coordinates of the points in this polygon
	 * @param ypoints An array of integer values for the y-coordinates of the points in this polygon
	 * @param npoints The total number of points in the polygon
	 */
	public PolyExt(int[] xpoints, int[] ypoints, int npoints)
	{
		super(xpoints, ypoints, npoints);
		extColor = Color.BLACK;
		intColor = Color.BLACK;
	}
	
	/**
	 * Constructor which allows the setting of the color of the shape when constructed
	 * 
	 * @param xpoints An array of integer values for the x-coordinates of the points in this polygon
	 * @param ypoints An array of integer values for the y-coordinates of the points in this polygon
	 * @param npoints The total number of points in the polygon
	 * @param c The color of the shape
	 */
	public PolyExt(int[] xpoints, int[] ypoints, int npoints, Color c)
	{
		super(xpoints, ypoints, npoints);
		extColor = c;
		intColor = c;
	}
	
	/**
	 * Constructor which allows the setting of the color of the outline and fill of the shape
	 * separate from each other
	 * 
	 * @param xpoints An array of integer values for the x-coordinates of the points in this polygon
	 * @param ypoints An array of integer values for the y-coordinates of the points in this polygon
	 * @param npoints The total number of points in the polygon
	 * @param ext The color of the outline of the shape
	 * @param inside The color of the fill of the shape
	 */
	public PolyExt(int[] xpoints, int[] ypoints, int npoints, Color ext, Color inside)
	{
		super(xpoints, ypoints, npoints);
		extColor = ext;
		intColor = inside;
	}
	
	/**
	 * Allows for the changing of the outline color of the shape.
	 * 
	 * @param newColor The new color for the outline
	 */
	public void changeExtColor(Color newColor)
	{
		extColor = newColor;
	}
	
	/**
	 * Allows for the changing of the fill of the shape.
	 * 
	 * @param newColor The new color for the fill
	 */
	public void changeIntColor(Color newColor)
	{
		intColor = newColor;
	}
	
	/**
	 * Allows for the changing of both the fill and the outline of the shape
	 * 
	 * @param newIntColor The new color for the fill
	 * @param newExtColor The new color for the outline
	 */
	public void changeColors(Color newIntColor, Color newExtColor)
	{
		extColor = newExtColor;
		intColor = newIntColor;
	}
	
	/**
	 * Paints the polygon.
	 * 
	 * @param g The graphics context
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
	 * Translates the polygon with respect to the x- and y-axis
	 * 
	 * @param x The amount and direction to move the polygon with respect to the x-axis
	 * @param y The amount and direction to move the polygon with respect to the y-axis
	 */
	public void translate(double x, double y)
	{
		for(int current : super.xpoints)
		{
			current += x;
		}
		
		for(int current : super.ypoints)
		{
			current += y;
		}
	}
	
	/**
	 * Scales the polygon according to the given ratio
	 * 
	 * @param change The double-precision result of dividing the ratio of new to old
	 */
	public void scale(double change)
	{
		for(int current : super.xpoints)
		{
			current *= change;
		}
		
		for(int current : super.ypoints)
		{
			current *= change;
		}
	}
	
}
