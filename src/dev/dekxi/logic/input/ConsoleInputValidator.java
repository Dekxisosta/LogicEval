package dev.dekxi.logic.input;

final class ConsoleInputValidator{
	private DataTypeParser dataTypeParser = new DataTypeParser();
	//-->>
	ConsoleInputValidator () {}
	
	/*=================
	 * INPUT GETTER METHODS
	 * =============*/
	boolean validateBoolValue(String input) throws IllegalArgumentException{
		if("0".equals(input) || "false".equalsIgnoreCase(input)) return false;
    	if("1".equals(input) || "true".equalsIgnoreCase(input)) return true;
    	throw new IllegalArgumentException("Invalid number input. Try again");
	}
	
	//-->>
	int validateUserChoice(String input, int min, int max) throws IllegalArgumentException {
		int value = dataTypeParser.parseInt(input);
		if (value < min || value > max) {
            throw new IllegalArgumentException("Integer out of range: " + value + " (expected " + min + " to " + max + ")");
        }else {
        	return value;
        }
	}
}