package dev.dekxi.logic.app;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;

/*
 * ====================================
 * # DEV DEKXI'S CONSOLE-BASED LOGICAL CALCULATOR 
 * ====================================
 	* Github Account: Dekxisosta
 	* Date Created: 2025 / 08 / 22
 	* 
 *  PROGRAM DESCRIPTION:
	 * This program uses a modular approach. If you wish to add an action to the program,
	 * simply utilize the LogicRegistry class, follow the syntax
	 * 
	 * ==================================
	 * JAVA CLASS FILE DESCRIPTIONS
	 * ==============================
	 * APP ( Main program flow )
	 * 
	 * LOGIC REGISTRY ( Registers actions on application start ) 
	 * 
	 * CONSOLE OUTPUT ( Primarily used for already formatted console-based outputs. However, there
	 * 					are printing code blocks located in Validate and Main )
	 * 
	 * DATA ( Centralized Data Structure and where all static instantiations live, pretty much a configuration file too )
	 * 
	 * LOGIC ( I could've just registered the action immediately on LogicRegistry, but for my professor to see my algorithm, 
	 * 					I made a separate class for all the logical operators)
	 * 
	 * VALIDATE ( Validates user inputs. Can convert 1: True, 2:False )
	 * 
	 * ACTION ( Blueprint for an action, contains a name and a runnable)
	 * 
	 * TRUTH VALUE ( Blueprint for a truth value, contains a name and a boolean with accessor methods)
	 * 
 */
public class App{
	/*=================
	 * ENTRY POINT
	 * =============*/
	public static void main(String[] args) {
		try {
			app(args);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*==========================
	 * MAIN APPLICATION LOOP
	 *=========================*/
	private static void app(String[] args) throws IOException{
		ConsoleOutput.printIntroduction();
		LogicRegistry.initialize();
		
		while(Data.continueProgram) {
			ConsoleOutput.printBanner(Data.PROGRAM_NAME);
			ConsoleOutput.printOptions(Data.getActionNames());
			
			int choice = Validate.getUserChoice(0, Data.actionMap.size());
			performAction(choice);
			if (choice==0) 
				Data.continueProgram = false;
		}
	}
	private static void performAction(int choice) {
		Data.actionMap.get(choice).run();
	}
}
class LogicRegistry{
	static void initialize() {
		/*=================
		 * REGISTERING OF ACTIONS
		 * =============*/
		//>> GETS TRUTH VALUES FOR LATER USE IN THE PROGRAM
		Data.actionMap.put(1, new Action("GET TRUTH VALUES", () -> {
			ConsoleOutput.printTruthValuePrompt();
			Data.p.setValue(Validate.getValue(Data.p.getName()));
			Data.q.setValue(Validate.getValue(Data.q.getName()));
		}));
		
		//>> CALCULATES AND PRINTS NEGATION RESULTS FOR BOTH P AND Q
		Data.actionMap.put(2, new Action("PRINT NEGATION RESULT", () -> {
			printTruthValues();
			ConsoleOutput.printResult("NEGATION OF P", 
					Logic.getNegation(Data.p.getValue()));
			ConsoleOutput.printResult("NEGATION OF Q", 
					Logic.getNegation(Data.q.getValue()));
		}));
		
		//>> CALCULATES CONJUNCTION (LOGICAL AND) OF P AND Q AND PRINTS IT OUT
		Data.actionMap.put(3, new Action("PRINT CONJUNCTION RESULT", () -> {
			printTruthValues();
			ConsoleOutput.printResult("CONJUNCTION P∧Q", 
					Logic.getConjunction(Data.p.getValue(), Data.q.getValue()));
		}));
		
		//>> CALCULATES DISJUNCTION (LOGICAL OR) OF P AND Q AND PRINTS IT OUT
		Data.actionMap.put(4, new Action("PRINT DISJUNCTION RESULT", () -> {
			printTruthValues();
			ConsoleOutput.printResult("DISJUNCTION P∨Q", 
					Logic.getDisjunction(Data.p.getValue(), Data.q.getValue()));
		}));
		
		//>> CALCULATES AND PRINTS IMPLICATION (LOGICAL IF) FOR BOTH IF P THEN Q AND IF Q THEN P
		Data.actionMap.put(5, new Action("PRINT IMPLICATION RESULT", () -> {
			printTruthValues();
			ConsoleOutput.printResult("IMPLICATION P→Q", 
					Logic.getImplication(Data.p.getValue(), Data.q.getValue()));
			ConsoleOutput.printResult("IMPLICATION Q→P", 
					Logic.getImplication(Data.q.getValue(), Data.p.getValue()));
		}));
		
		//>> CALCULATES BICONDITIONAL (LOGICAL IF AND ONLY IF) OF P AND Q AND PRINTS IT OUT
		Data.actionMap.put(6, new Action("PRINT BICONDITIONAL RESULT", () -> {
			printTruthValues();
			ConsoleOutput.printResult("BICONDITIONAL P↔Q", 
					Logic.getBiconditional(Data.p.getValue(), Data.q.getValue()));
		}));
		
		//>> PRINTS ALL POSSIBLE VALUES FOR ALL POSSIBLE TRUTH VALUE COMBINATIONS OF P AND Q
		Data.actionMap.put(7, new Action("PRINT ALL POSSIBLE VALUES", () -> {
			String inner = "|";
			String outer = "||";
			System.out.printf("%s%n%s", "=".repeat(82), "-".repeat(82));
			System.out.printf("%n%s%-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s%s%n",
		            outer, "P", inner, "Q", inner, "¬P", inner, "¬Q", inner, "P∧Q", inner, "P∨Q", inner, "P→Q", inner, "Q→P", inner, "P↔Q", outer);

		    for (int mask = 0; mask < 4; mask++) {
		        boolean pVal = (mask & 0b10) != 0;
		        boolean qVal = (mask & 0b01) != 0;

		        System.out.printf("%s%-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s%s%n",
		                outer, pVal, inner, qVal, inner,
		                Logic.getNegation(pVal),
		                inner,
		                Logic.getNegation(qVal),
		                inner,
		                Logic.getConjunction(pVal, qVal),
		                inner,
		                Logic.getDisjunction(pVal, qVal),
		                inner,
		                Logic.getImplication(pVal, qVal),
		                inner,
		                Logic.getImplication(qVal, pVal),
		                inner,
		                Logic.getBiconditional(pVal, qVal),
		                outer);
		    }
		    System.out.printf("%s%n%s", "-".repeat(82), "=".repeat(82));
		}));
		
		//>> TERMINATES PROGRAM WITHOUT PROMPT because I am lazy...
		Data.actionMap.put(0, new Action("PROGRAM TERMINATION", () -> {
			System.out.print("\nThank you for using the program!\n-dekxi");
			try {
				Data.reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}));
	}
	
	/*=================
	 * UTILITY METHODS
	 * =============*/
	private static void printTruthValues() {
		System.out.print("\nTRUTH VALUES");
		ConsoleOutput.printTruthValue(Data.p.getName(), Data.p.getValue());
		ConsoleOutput.printTruthValue(Data.q.getName(), Data.q.getValue());
		System.out.println();
	}
}

//-->>
class ConsoleOutput{
	/*=================
	 * PACKAGE-PRIVATE FUNCTIONS
	 * =============*/
	static void printIntroduction() {
		System.out.print("⠀⠀⠀⣀⣤⣿⣿⠟⣀⠀⠀⠀⠀⠀⣿⢃⣿⠇⢿⣯⣿⣿⣇⣿⠁⠀⠀⠀⣾⡇⢸⣿⠃⠉⠁⠸⣿⣼⡇⢻⡇⠀⠀⠀⢿⣷⣶⣬⣭⣿⣿⣿⠇\r\n"
				+ "⣾⣿⣿⣿⣿⣻⣥⣾⡇⠀⠀⠀⠀⠀⣿⣿⠇⠀⠘⠿⠋⠻⠿⠿⠶⠶⠾⠿⠿⠍⢛⣧⣰⠶⢀⣀⣼⣿⣴⡸⣿⠀⠀⠀⠸⣿⣿⣿⠉⠛⠉⠀⠀\r\n"
				+ "⠘⠛⠿⠿⢿⣿⠉⣿⠁⠀⠀⠀⠀⢀⣿⡿⣶⣶⣶⣤⣤⣤⣀⣀⠀⠀⠀⠀⠀⠀⢀⣭⣶⣿⡿⠟⠋⠉⠀⠀⣿⠀⡀⡀⠀⣿⣿⣿⡆⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⣼⣿⠀⣿⠀⠀⠸⠀⠀⠸⣿⠇⠀⠀⣈⣩⣭⣿⡿⠟⠃⠀⠀⠀⠀⠀⠙⠛⠛⠛⠛⠻⠿⠷⠆⠀⣯⠀⠇⡇⠀⣿⡏⣿⣧⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⢿⣿⡀⣿⡆⠀⠀⠀⠀⠀⣿⠰⠿⠿⠛⠋⠉⠀⠀⢀⣴⣶⣶⣶⣶⣶⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣧⠀⠀⠀⣿⡇⣿⣿⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⢸⣿⡇⢻⣇⠀⠘⣰⡀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⢸⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⠀⠀⠀⣿⣧⣿⡿⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠈⣿⣧⢸⣿⡀⠀⡿⣧⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⣿⡄⠀⠀⠀⣼⡇⠀⠀⠀⠀⠀⠀⢀⣤⣾⡟⢡⣶⠀⢠⣿⣿⣿⠃⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠹⣿⣿⣿⣷⠀⠇⢹⣷⡸⣿⣶⣦⣄⣀⡀⠀⠀⠀⣿⡇⠀⠀⢠⣿⠁⣀⣀⣠⣤⣶⣾⡿⢿⣿⡇⣼⣿⢀⣿⣿⠿⠏⠀⠀⠀⠀⠀\r\n"
				+ "================================================\n"
				+ "\nDATE CREATED: 2025/08/22 "
				+"\nCREATED BY: Dekxi (Dekxisosta)\n"
				+ "\n==PROGRAM DESCRIPTION============================\n"
				+ ""
				+ "\nIn this program, I made an effort to make it "
				+ "\nas modular and loosely coupled as possible."
				+ "\nThere are predetermined truth values, which aligns"
				+ "\nwith Task no. 1 on the paper\n"
				+ "\nAlso, obligatory Emu Otori ASCII art. WONDAHOY !!!\n\n"
				+ "================================================\n");
	}
	static void printTruthValuePrompt() {
		System.out.print("\nNOTE: Enter truth values for P and Q");
	}
	
	static void printTruthValue(String varName, boolean var) {
		System.out.printf("%n%s: %s", varName, var);
	}
	
	static void printOptions(String[] options) {
		int size = options.length;
		for(int i=1;i<size;i++)
			System.out.printf("%n[%s] %s", i, options[i]);
		
		System.out.printf("%n[%s] %s", 0, options[0]);
	}
	
	static void printResult(String logicName, boolean result) {
		System.out.printf("%n%s: %s%n", logicName, result);
	}
	
	static void printBanner(String name) {
		printBorder(name.length());
		System.out.printf("%n%s",
				"{| " + name + " |}");
		printBorder(name.length());
	}
	
	/*=================
	 * UTILITY METHODS
	 * =============*/
	private static void printBorder(int length) {
		System.out.printf("%n%s%s%s",
				"+++",
				"=".repeat(length),
				"+++"
				);
	}
}

//-->>
class Data{
	/*=================
	 * PROGRAM DETAILS
	 * =============*/
	static final String PROGRAM_NAME = "DEV DEKXI'S CONSOLE-BASED LOGIC CALCULATOR";
	static boolean continueProgram = true;
	static final String ERROR_PREFIX = "[ERROR]";
	
	/*=================
	 * TRUTH VALUES
	 * =============*/
	static TruthValue p = new TruthValue("p", true);
	static TruthValue q = new TruthValue("q", false);
	
	/*=================
	 * MAPPED ACTIONS
	 * =============*/
	static Map<Integer, Action> actionMap = new HashMap<>();
	
	/*=================
	 * PACKAGE-PRIVATE FUNCTIONS
	 * =============*/
	static String[] getActionNames() {
		int size = actionMap.size();
		String[] names = new String[size];
		
		for(int i=0; i<size;i++)
			names[i] = actionMap.get(i).getName();
		
		return names;
	}
	/*=================
	 * CONSOLE INPUT READER
	 * =============*/
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
}

//-->>
class Logic{
	/*=================
	 * PACKAGE-PRIVATE FUNCTIONS
	 * =============*/
	static boolean getNegation(boolean p) {
		return !p;
	}
	static boolean getConjunction(boolean p, boolean q) {
		return p && q;
	}
	static boolean getDisjunction(boolean p, boolean q) {
		return p || q;
	}
	static boolean getImplication(boolean p, boolean q) {
		return !p || q;
	}
	static boolean getBiconditional(boolean p, boolean q) {
		return p == q;
	}
}

//-->>
class Validate{
	/*=================
	 * PACKAGE-PRIVATE FUNCTIONS
	 * =============*/
	static boolean getValue(String name) {
		System.out.printf("%nFOR VARIABLE %s", name);
		System.out.print("\n[1] TRUE"
				+ "\n[0] FALSE"
				+ "\nEnter: ");
		return getValidBool();
	}
	
	static int getUserChoice(int min, int max) {
		System.out.print("\nEnter option: ");
		return getValidChoice(min, max);
	}
	/*=================
	 * UTILITY METHODS
	 * =============*/
	private static int getValidChoice(int min, int max) {
		int input;
		System.out.print("");
		while(true) {
			try {
				input = Integer.parseInt(Data.reader.readLine());
				if (input>=min&&input<=max) {
					break;
				}else {
					invalidInputFallback();
				}
			}catch(Exception e) {
				invalidInputFallback();
			}
		}
		
		return input;
	}
	
	
	private static boolean getValidBool() {
		int input;
		while(true) {
			try {
				input = Integer.parseInt(Data.reader.readLine());
				if (input==1||input==0) {
					break;
				}else {
					invalidInputFallback();
				}
			}catch(IOException e) {
				invalidInputFallback();
			}
		}
		
		//the try-catch block will only fetch either 0 or 1
		if (input==1) {
			return true;
		}else{
			return false;
		}
	}
	
	private static void invalidInputFallback() {
		System.out.printf("%n%s Invalid input. Please try again", Data.ERROR_PREFIX);
		System.out.print("\nEnter: ");
	}
}

/*========================================
 * CONSTRUCTOR CLASSES
 =====================================*/

//-->>
class Action{
	private String name;
	private Runnable operation;
	
	Action(String name, Runnable operation){
		this.name = name;
		this.operation = operation;
	}
	
	String getName() {return name;}
	
	void run() {operation.run();};
}

//-->>
class TruthValue{
	/*=================
	 * INSTANCE FIELDS
	 * =============*/
	private String name;
	private boolean value;
	
	/*=================
	 * CONSTRUCTOR
	 * =============*/
	TruthValue(String name, boolean value){
		this.name = name;
		this.value = value;
	}
	
	/*=================
	 * ACCESSORS AND MUTATORS
	 * =============*/
	String getName() {return name;}
	boolean getValue() {return value;}
	
	void setValue(boolean value) {this.value = value;}
}
