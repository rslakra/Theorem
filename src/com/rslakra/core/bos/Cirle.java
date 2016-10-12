package com.rslakra.core.bos;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 10/12/2016 04:55:40 PM
 *
 */
public class Cirle {
	// Horizontal position of center
	int xValue;
	// Vertical position of center
	int yValue;
	
	float radius;
	// True means circle filled
	boolean solid;
	
	public Cirle() {
		
	}
	
	/**
	 * @return the xValue
	 */
	public int getxValue() {
		return xValue;
	}
	
	/**
	 * @param xValue the xValue to set
	 */
	public void setxValue(int xValue) {
		this.xValue = xValue;
	}
	
	/**
	 * @return the yValue
	 */
	public int getyValue() {
		return yValue;
	}
	
	/**
	 * @param yValue the yValue to set
	 */
	public void setyValue(int yValue) {
		this.yValue = yValue;
	}
	
	/**
	 * @return the radius
	 */
	public float getRadius() {
		return radius;
	}
	
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}
	
	/**
	 * @return the solid
	 */
	public boolean isSolid() {
		return solid;
	}
	
	/**
	 * @param solid the solid to set
	 */
	public void setSolid(boolean solid) {
		this.solid = solid;
	}
}
