package dev.dekxi.logic.input;

final class DataTypeParser {
	//-->>
	DataTypeParser() {};
	
	/*=================
	 * DATATYPE PARSER METHODS
	 * =============*/
	
	//-->>
    int parseInt(String input) throws IllegalArgumentException {
    	try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
        	throw new IllegalArgumentException("Unable to parse integer. Input a valid integer");
        }
    }
}