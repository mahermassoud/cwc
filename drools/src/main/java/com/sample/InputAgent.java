package com.sample;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * This class is for providing input to the DroolsTest class. 
 * It is a placeholder for interfacing with the natural language group.
 * 
 * @author Massoud Maher
 * @version 0.1
 */
public class InputAgent {
	
	BufferedReader reader = null;
	
	/**
	 * Creates an InputAgent for reading in a text file.
	 * 
	 * @param filePath Filepath of file wanted to be read in
	 */
	public InputAgent(String filePath) {
		try {
			reader = new BufferedReader( new FileReader(filePath) );
		}
		catch (FileNotFoundException fileException) {
			// TODO add log statement
			System.err.println("File " + filePath + "not found!");
		}
	}
	
	/**
	 * Reads a line from the file this Agent is handling
	 * 
	 * @return line that was just read
	 */
	public String readLine() {
		try {
			return reader.readLine();
		}
		catch(IOException iOException) {
			// TODO add log statement
			System.err.print(iOException.getMessage());
			return null;
		}
	}
}
