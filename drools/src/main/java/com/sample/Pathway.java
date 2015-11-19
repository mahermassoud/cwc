package com.sample;

import com.sample.Common.PathwayType;
import java.util.HashSet;

/**
 * Class that represents a group of relevant genes-- for prototyping purposes
 * 
 * @author Massoud Maher
 */
public class Pathway {

	public HashSet<PathwayType> relevantPathways = new HashSet<PathwayType>();
	
	// Type of gene group this object represents
	public PathwayType type;
	
	/*
	 * Creates a gene Group of a certain type
	 */
	public Pathway(PathwayType type) {
		this.type = type;
	}

	/**
	 * Returns a string representation of this GeneGroup
	 */
	public String toString() {
		String output = null;
		
		switch (type) {
			case ANGIOTENSIN:
			output = "angiotensin";
			break;
		}
		
		return output;
	}
	
	/**
	 * 
	 * @return type of this geneGroup
	 */
	public PathwayType getType() {
		return type;
	}
}
