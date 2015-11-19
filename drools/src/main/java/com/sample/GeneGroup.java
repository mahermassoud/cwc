package com.sample;

/**
 * Class that represents a group of relevant genes-- for prototyping purposes
 * 
 * @author Massoud Maher
 */
public class GeneGroup<GeneGroupType> extends DataContainer<Enum> implements Common {

	/*
	 * Creates a gene Group of a certain type
	 */
	public GeneGroup(GeneGroupType type) {
		super(type);
	}

	/**
	 * Returns a string representation of this GeneGroup
	 */
	public String toString() {
		String output = null;
		
		switch((GeneGroupType)getData()) {
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
