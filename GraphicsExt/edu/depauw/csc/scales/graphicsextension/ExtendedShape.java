package edu.depauw.csc.scales.graphicsextension;

import java.awt.Graphics;

/**
 * Interface for a Scales extended shape.
 * 
 * @author Cory Boatright, boatrightcd@hiram.edu
 * @version June 13, 2007
 */
public interface ExtendedShape
{
	public void paint(Graphics g);
	public void translate(double x, double y);
	public void scale(double change);
}
