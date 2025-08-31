package dev.dekxi.logic.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*===============================
 * FILE PARSER
 *===============================*/
/**
 * Parses txt files, in this program, it only parses a simple introduction txt file
 * It creates its own BufferedReader when trying to parse a file, which immediately closes
 * for better performance
 *
 * <p><b>DEPENDENCIES:</b></p>
 * <ul>
 *     <li>{@link java.io.BufferedReader} for efficiency and convenience when reading character-based input streams</li>
 *     <li>{@link java.io.FileReader} for reading txt files</li>
 *     <li>{@link java.io.IOException} for catching IOExceptions when using BufferedReader</li>
 * </ul>
 */
final class FileParser {

	private FileParser() {}

    /**
     * Parses files, in this program, it only parses a simple introduction txt file
     *
     * @param filePath the txt file to be processed
     * @return the file's text with line spaces
     * @throws IllegalArgumentException when unable to read filepath
     */
	static String parseFile(String filePath) throws IllegalArgumentException{
        // instead of manual concatenation for better readability
		StringBuilder fileTxt = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			String line;
            while ((line = reader.readLine()) != null) {
            	fileTxt.append(line).append("\n");
            }
        }catch (IOException e) {
        	throw new IllegalArgumentException("Unable to read filePath" + e);
        }
		return fileTxt.toString();
	}
}