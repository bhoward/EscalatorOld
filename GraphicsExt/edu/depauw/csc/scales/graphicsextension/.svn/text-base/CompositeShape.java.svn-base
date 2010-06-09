package edu.depauw.csc.scales.graphicsextension;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Basic class for composite shapes.
 * 
 * @author Cory Boatright, boatrightcd@hiram.edu
 * @version June 13, 2007
 */
public class CompositeShape implements ExtendedShape 
{
	private LinkedList<ExtendedShape> contents;

	/**
	 * Default and only constructor.
	 */
	public CompositeShape()
	{
		contents = new LinkedList<ExtendedShape>();
	}
	
	/**
	 * Adds the given shape to the composite image.  The image will be drawn from oldest to newest
	 * shape, so new shapes cannot be blocked by old shapes.
	 * 
	 * @param shape The new shape to be added to the composite
	 */
	public void add(ExtendedShape shape)
	{
		contents.add(shape);
	}
	
	/**
	 * Paints the composite image.
	 * 
	 * @param g The graphics context
	 */
	public void paint(Graphics g) 
	{
		for(ExtendedShape current : contents)
		{
			current.paint(g);
		}
	}

	/**
	 * Resizes the composite shape according to a provided ratio.
	 *
	 * @param change The result of dividing the ratio of new to old
	 */
	public void scale(double change) 
	{
		for(ExtendedShape current : contents)
		{
			current.scale(change);
		}
	}

	/**
	 * Translates the composite shape along the x- and y-axis.
	 * 
	 * @param x The amount and direction to move with respect to the x-axis
	 * @param y The amount and direction to move with respect to the y-axis
	 */
	public void translate(double x, double y) 
	{
		for(ExtendedShape current : contents)
		{
			current.translate(x, y);
		}
	}

}
