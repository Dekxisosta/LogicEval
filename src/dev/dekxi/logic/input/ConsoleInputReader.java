package dev.dekxi.logic.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

final class ConsoleInputReader {
	ConsoleInputValidator validator = new ConsoleInputValidator();
	/*=================
	 * INPUT STREAM READER DECLARATION
	 * =============*/
	//-->>
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/*=================
	 * CONSOLE INPUT CONSTRUCTOR
	 * =============*/
	//-->>
	ConsoleInputReader(){}
	
	/*=================
	 * PACKAGE-PRIVATE READ LINE METHOD
	 * =============*/
	//-->>
	public String readLine() throws IOException {return reader.readLine();}
	
	void close() {
		try {
			reader.close();
		} catch (IOException ignored) {}
	}
}
