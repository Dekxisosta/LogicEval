package dev.dekxi.logic.input;

import java.io.IOException;

public final class ConsoleInput{
	private ConsoleInputValidator validator = new ConsoleInputValidator();
	private ConsoleInputReader reader = new ConsoleInputReader();
	
	/*=================
	 * EXPOSED GETTER METHODS
	 * =============*/
	public boolean getBoolValue() throws IOException, IllegalArgumentException  {
		return validator.validateBoolValue(reader.readLine());	
	}
	public int getUserChoice(int min, int max) throws IOException, IllegalArgumentException{
		return validator.validateUserChoice(reader.readLine(), min, max);
	}
	
	public void close() {
		reader.close();
	}
}