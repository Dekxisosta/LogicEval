package dev.dekxi.logic.input;

/*===============================
 * CONSOLE INPUT VALIDATOR CLASS
 *===============================*/
/**
 * Validates input if it abides to a set of custom rules
 *
 * <p><b>DEPENDENCIES:</b></p>
 *  <ul>
 *      <li>{@link dev.dekxi.logic.input.DataTypeParser} to parse integer inputs in the system</li>
 * </ul>
 */
final class ConsoleInputValidator{
    /*===============================
     * INSTANCE FIELDS
     *===============================*/
    /** For parsing integers */
	private DataTypeParser dataTypeParser = new DataTypeParser();

    /*===============================
     * PACKAGE-PRIVATE METHODS
     *===============================*/
    /** Package-private constructor to ensure fixed package-only access*/
    ConsoleInputValidator () {}

    /**
     * Checks input if its corresponds to a boolean output <p></p>
     * @param input the string value to be validated
     * @return {@code true} if the value of the input is either 1, true, or t
     *      {@code false} if the value of the input is either 0, false, or f. Case ignored
     * @throws IllegalArgumentException if invalid number input
     */
	boolean validateBoolValue(String input) throws IllegalArgumentException{
		if("0".equals(input) || "false".equalsIgnoreCase(input) || "f".equalsIgnoreCase(input)) return false;
    	if("1".equals(input) || "true".equalsIgnoreCase(input) || "t".equalsIgnoreCase(input)) return true;
    	throw new IllegalArgumentException("Invalid number or T/F input. Try again");
	}

    /**
     * Checks input if the integer value is within min and max, inclusive
     *
     * @param input the string value to be validated
     * @param min the minimum range of the integer input, inclusive
     * @param max the maximum range of the integer input, inclusive
     *
     * @return {@code value} when input is within the set range
     *
     * @throws IllegalArgumentException when input is not within the set range
     */
	int validateUserChoice(String input, int min, int max) throws IllegalArgumentException {
		int value = dataTypeParser.parseInt(input);
		if (value < min || value > max) {
            throw new IllegalArgumentException("Integer out of range: " + value + " (expected " + min + " to " + max + ")");
        }else {
        	return value;
        }
	}
}