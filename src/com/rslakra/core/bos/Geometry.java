package com.rslakra.core.bos;

public interface Geometry {
	public static final float PI = 3.14F;
	
	/**
	 * Returns the perimeter of the object.
	 * 
	 * @return
	 */
	public abstract float perimeter();
	
	/**
	 * Returns the area of the object.
	 * 
	 * @return
	 */
	public abstract float area();
	
	/**
	 * Returns weight of the object.
	 * 
	 * @param scale
	 * @return
	 */
	public abstract int weight(int scale);
}
