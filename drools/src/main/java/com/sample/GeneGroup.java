package com.sample;

import java.util.HashSet;

/**
 * Class that represents a group of relevant genes-- for prototyping purposes
 * 
 * @author Massoud Maher
 */
public class GeneGroup implements Common {

	public HashSet<GeneGroupType> relevantGenes = new HashSet<GeneGroupType>();
	
	// Type of gene group this object represents
	GeneGroupType type;
	
	/*
	 * Creates a gene Group of a certain type
	 */
	public GeneGroup(GeneGroupType type) {
		this.type = type;
	}

	/**
	 * Returns a string representation of this GeneGroup
	 */
	public String toString() {
		String output = null;
		
		switch(type) {
			case EPIDERMAL:
			output = "epidermal";
			break;

			case MYOCYTE_ENHANCER:
			output = "myocyte enhancer";
			break;

			case CALMODULIN_1:
			output = "calmodulin 1";
			break;
		}
		
		return output;
		
	}
}
