package dev.dekxi.logic.app.src.dev.dekxi.logic.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class FileParser {
	/*=================
	 * PREVENT INSTANTIATION
	 * =============*/
	private FileParser() {}
	
	/*=================
	 * FILE PARSER
	 * =============*/
	//-->>
	public static String parseFile(String filePath) throws IllegalArgumentException{
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