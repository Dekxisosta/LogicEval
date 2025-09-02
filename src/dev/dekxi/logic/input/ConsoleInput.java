package dev.dekxi.logic.input;

import java.io.IOException;

/*===============================
 * CONSOLE INPUT CLASS
 *===============================*/
/**
 * Acts as a centralized entry-point for all validators, readers, and parsers
 * contained within this package. Exception-handling is handled hierarchically, hence only
 * the {@link ConsoleInputValidator} is instantiated.
 *
 * <p><b>DEPENDENCIES:</b></p>
 * <ul>
 *     <li>{@link ConsoleInputValidator}</li>
 *     <li>{@link ConsoleInputReader}</li>
 *     <li>{@link FileParser} parses files from resources folder </li>
 *     <li>{@link java.io.IOException}
 *          for catching IOExceptions thrown by lower-level exception handlers </li>
 * </ul>
 */
public final class ConsoleInput{
    /*===============================
     * INSTANCE FIELDS
     *===============================*/
    /** Instantiates a va */
	private ConsoleInputValidator validator = new ConsoleInputValidator();

    /** Reads console input with an internal close reader method*/
	private ConsoleInputReader reader = new ConsoleInputReader();

    /*===============================
     * EXPOSED API / PUBLIC FUNCTIONS
     *===============================*/
    /**
     * Gets boolean value from user input on console<p></p>
     * @throws IllegalArgumentException thrown when {@link DataTypeParser} is unable to parse the input,
     *      or when {@link ConsoleInputValidator} detects an invalid input from a supposed range of values, etc.
     * @throws IOException thrown when readLine gets an invalid object
     * @return a boolean value that corresponds to the user input. See more details at {@link ConsoleInputValidator}
     */
	public boolean getBoolValue() throws IOException, IllegalArgumentException  {
		return validator.validateBoolValue(reader.readLine());	
	}

    /**
     * Gets user choice from user input on console, must be within a set range of integer values
     * @param min the minimum range of values, inclusive
     * @param max the maximum range of values, inclusive
     * @return an integer value that is within min max
     * @throws IOException thrown when readLine gets an invalid object
     * @throws IllegalArgumentException thrown when {@link ConsoleInputValidator} detects an invalid input
     */
	public int getUserChoice(int min, int max) throws IOException, IllegalArgumentException{
		return validator.validateUserChoice(reader.readLine(), min, max);
	}

    /**
     * Gets text from a file for console output
     * @param filePath the directory of the file in String value
     * @return the files text as a String value with line breaks
     * @throws IllegalArgumentException thrown when {@link FileParser} detects an invalid file path
     */
    public String getStringFromFilePath(String filePath) throws IllegalArgumentException{
        return FileParser.parseFile(filePath);
    }
	
	public void close() {
		reader.close();
	}
}