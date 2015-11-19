package com.sample;

/**
 * Class that represents a group of relevant genes-- for prototyping purposes
 * 
 * @author Massoud Maher
 */
public class Pathway extends DataContainer<Enum> {
	
	public Pathway(PathwayType path) {
		super(path);
	}

	/**
	 * Returns a string representation of this GeneGroup
	 */
	public String toString() {
		String output = null;
		
		switch ( (PathwayType)getData() ) {
			case ANGIOTENSIN:
			output = "angiotensin";
			break;
		}
		
		return output;
	}
	
}
