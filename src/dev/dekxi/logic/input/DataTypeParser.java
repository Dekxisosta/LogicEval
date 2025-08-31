package dev.dekxi.logic.input;

/*===============================
 * DATATYPE PARSER CLASS
 *===============================*/
/**
 * Parses primitive datatypes for later use in the program. Catches exceptions
 * and turns them into IllegalArgumentExceptions with a corresponding error message
 */
final class DataTypeParser {
    /*===============================
     * PACKAGE-PRIVATE METHODS
     *===============================*/
    /** Package-private constructor to ensure fixed package-only access */
    DataTypeParser() {};

    /**
     * Low-level exception handler for when
     * the code block happens to throw a NumberFormatException
     * while parsing an integer
     *
     * @param input the string value acquired
     * @return parsed integer
     * @throws IllegalArgumentException thrown when input was invalid for Integer datatype
     */
    int parseInt(String input) throws IllegalArgumentException {
    	try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
        	throw new IllegalArgumentException("Unable to parse integer. Input a valid integer");
        }
    }
}