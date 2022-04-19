package org.code;

public record RecordExample(String name, String id) {
	
	/*
	 * Prints the name in uppercase
	 */
	public String printUpperCase() {
		return name.toUpperCase();
	}
}