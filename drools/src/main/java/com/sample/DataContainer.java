package com.sample;

/**
 * Class that represents a data object, like a group of genes or a pathway-- for prototyping purposes
 * 
 * @author Massoud Maher
 */
public abstract class DataContainer<Enum> implements Common {

	// Type of data this object represents
	private Enum data;
	
	/*
	 * Creates a DataCointainer of a certain type
	 */
	public DataContainer(Enum data) {
		this.data = data;
	}

	/**
	 * Returns a string representation of this data container
	 * implementation should map a unique string for all possible values of data
	 */
	public abstract String toString();
	
	/**
	 * @return data of this geneGroup
	 */
	public Enum getData() {
		return data;
	}
	
}
