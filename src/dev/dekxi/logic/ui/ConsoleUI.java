package dev.dekxi.logic.ui;

import java.io.IOException;

import dev.dekxi.logic.input.ConsoleInput;
import dev.dekxi.logic.input.FileParser;

public class ConsoleUI{
	ConsoleInput input = new ConsoleInput();

	/*=================
	 * CONSTRUCTOR
	 * =============*/
	//-->>
	public ConsoleUI() {}
	
	/*=================
	 * EXPOSED CONSOLE UI FORMATTERS
	 * =============*/
	//-->>
	public void showIntroduction() {
		System.out.print(FileParser.parseFile("resources/Introduction.txt"));
	}
	
	//-->>
	public void show() {
		System.out.print(FileParser.parseFile("resources/Introduction.txt"));
	}
	
	//-->>
	public void showBanner(String name) {
		showBannerBorder('=', name.length());
		printf("%n%s",
				"{| " + name + " |}");
		showBannerBorder('=', name.length());
	}
	
	//-->>
	public void showVar(String varName, boolean var) {
		printf("%n%s: %s", varName, var);
	}
	
	//-->>
	public void showOptions(String[] options) {
		int size = options.length;
		for(int i=1;i<size;i++)
			printf("%n[%s] %s", i, options[i]);
		printf("%n[%s] %s", 0, options[0]);
	}
	
	//-->>
	public void showBooleanOptions() {
		showOptions(new String[]{"FALSE","TRUE"});
	}
	
	//-->>
	public void showYNOptions() {
		showOptions(new String[] {"NO", "YES"});
	}
	
	//-->>
	public void showEnterPrompt() {
		printf("%n%s", "ENTER: ");
	}
		
	//-->>
	public void printf(String format, Object... args) {System.out.printf(format, args);}
		
	//-->>
	public void println() {println("");}
		
	//-->>
	public void println(String s) {System.out.println(s);}
	
	/*=================
	 * EXPOSED TABULAR CONSOLE UI FORMATTERS
	 * =============*/
	
	//-->>
	public void printTable(String[]labels, boolean[] results) throws IllegalArgumentException{
		//throw error
		if (labels.length != results.length)
			throw new IllegalArgumentException(ConsoleTag.ERROR.label() + " Labels and results must have the same length");
		
		//size = array length, tableSize = console format size length
		int tableSize = labels.length * 7 +3;
		int size = labels.length;
		
		//print top border
		printDoubleBorder(FormatConfig.HORIZONTAL_OUTER, FormatConfig.HORIZONTAL_INNER, tableSize);
		
		//print header
		printRow(labels);
		
		//convert an array of booleans to strings 
		String[] resultStrings = new String[results.length];
		for (int i=0;i<size;i++)
			resultStrings[i] = String.valueOf(results[i]);
		
		//print converted results of equations performed
		printRow(resultStrings);
		
		//print bottom border
		printDoubleBorder(FormatConfig.HORIZONTAL_INNER, FormatConfig.HORIZONTAL_OUTER, tableSize);
	}
	//-->>
	public void printRow(String[] values) {
		println();
		
		printf("%s%-6s", FormatConfig.VERTICAL_OUTER.label(), values[0]);
		
		for(int i=1; i<values.length;i++)
			 printf("%s%-6s", FormatConfig.VERTICAL_INNER.label(), values[i]);
		
		printf("%s", FormatConfig.VERTICAL_OUTER.label());
	}
	
	//-->>
//	public void printBinaryTable(boolean pVal, boolean qVal, String[] equations,  boolean [] results) {
//		char styleA = '=';
//		char styleB = '-';
//		char inner = '|';
//		char outer = '*';
//		printDoubleBorder(styleA, styleB, 82);
//		printf("%s%-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s%s%n",
//	            outer, "P", inner, "Q", inner, "¬P", inner, "¬Q", inner, "P∧Q", inner, "P∨Q", inner, "P→Q", inner, "Q→P", inner, "P↔Q", outer);
//	        
//	        
//	    printRow(inner, results);
//	    println();
//	    printDoubleBorder(styleA, styleB, 82);
//	}
	
	//-->>
	public void printOutsideBorder(char border) {
		printf("%s", String.valueOf(border));
	}
	
	//-->>
	public void printRow(char border, boolean[] results) {
		
	}
		
	/*=================
	 * EXPOSED GETTER METHODS
	 * =============*/
	public boolean getBoolValue() {
		while(true) {
			try {
				return input.getBoolValue();
			}catch(IOException | IllegalArgumentException e) {
				promptForInvalidInput(e.getMessage());
			}
		}
	}
	
	public int getUserChoice(int min, int max) {
		while(true) {
			try {
				return input.getUserChoice(min, max);
			}catch(IOException | IllegalArgumentException e) {
				promptForInvalidInput(e.getMessage());
			}
		}
	}
	/*=================
	 * EXPOSED CLOSE METHOD
	 * =============*/
	public void close() {
		input.close();
	}
	
	/*=================
	 * UTILITY METHODS
	 * =============*/
	
	//-->>
	private void showMessage(ConsoleTag tag, String message) {
        printf("%n%s %s", tag.label(), message);
    }
	
	//-->>
	private void showBannerBorder(char s, int length) {
		printf("%n%s%s%s",
				"+++",
				String.valueOf(s).repeat(length),
				"+++"
				);
	}
	
	//-->>
	private void printDoubleBorder(FormatConfig styleA, FormatConfig styleB, int length) {
		printf("%n%s%n%s", styleA.label().repeat(length), styleB.label().repeat(length));
	}
	
	//-->>
	private void promptForInvalidInput(String e) {
		showMessage(ConsoleTag.ERROR, e);
		showEnterPrompt();
	}
}