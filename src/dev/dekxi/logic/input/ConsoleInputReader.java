package dev.dekxi.logic.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*===============================
 * CONSOLE INPUT READER
 *===============================*/
/**
 * Acts like a direct copy of the BufferedReader class. This class is created to separate the responsibility
 * of reading inputs. One can, however, just plug the BufferedReader + InputStreamReader object
 * in the ConsoleInput public class
 *
 * <p><b>DEPENDENCIES:</b></p>
 * <ul>
 *     <li>{@link java.io.BufferedReader} for efficiency and convenience when reading character-based input streams</li>
 *     <li>{@link java.io.InputStreamReader} for reading string inputs of the user in the console</li>
 *     <li>{@link java.io.IOException} for catching IOExceptions when using BufferedReader</li>
 * </ul>
 */
final class ConsoleInputReader {
    /*===============================
     * INSTANCE FIELDS
     *===============================*/
	/** For reading console inputs */
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /*===============================
     * PACKAGE-PRIVATE METHODS
     *===============================*/
	/** Package-private constructor to ensure fixed package-only access */
	ConsoleInputReader(){}
	
    /**
     * Reads a line of string inputs <p></p>
     * @throws IOException invalid object is found when reading the input
     */
    String readLine() throws IOException {return reader.readLine();}

    /**
     * Closes the reader and ignores {@link IOException} if fails, since
     * JVM already closes resources upon program termination
     */
	void close() {
		try {
			reader.close();
		} catch (IOException ignored) {}
	}
}
