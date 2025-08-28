package dev.dekxi.logic.app.src.dev.dekxi.logic.app;

/*
 * ==========================================
 * Project: Logic Console UI
 * File:    Main.java
 * Author:  Dekxi (github.com/Dekxisosta)
 * Created: August 28, 2025
 * ==========================================*/
/**
 *
 * Description:
 *   Entry point for the application. Initializes configuration,
 *   handles user input, and launches the console UI.
 *
 * Notes:
 *   - Requires Java 17+
 *   - This file is part of the Logic project (github.com/Dekxisosta/SimpleLogicCalculator)
 *
 * Dependencies:
 *   - {@link dev.dekxi.logic.app.src.dev.dekxi.logic.actions.ActionRegistry} : Registry point of all actions.
 *   - {@link dev.dekxi.logic.app.src.dev.dekxi.logic.actions.ActionMap} : Centralized datastore for actions.
 *   - {@link dev.dekxi.logic.app.src.dev.dekxi.logic.data.Config} : Holds PROGRAM_NAME, isContinueProgram, etc.
 *   - {@link dev.dekxi.logic.ui.ConsoleUI} : Handles all console display & input.
 */
import dev.dekxi.logic.app.src.dev.dekxi.logic.actions.ActionMap;
import dev.dekxi.logic.app.src.dev.dekxi.logic.actions.ActionRegistry;
import dev.dekxi.logic.app.src.dev.dekxi.logic.data.Config;
import dev.dekxi.logic.ui.ConsoleUI;

import java.io.IOException;

public class App{
	/*=================
	 * IMPORT INSTANCES
	 * =============*/
	private final ActionMap map = ActionMap.getInstance();
	private final ActionRegistry actions = new ActionRegistry();
	private final Config config = Config.getInstance();
	private final ConsoleUI ui = new ConsoleUI();
	
	/*===============================
	 * ENTRY POINT OF THE APPLICATION
	 *===============================*/
	/**
	 *
	 * Initializes the {@link App} class and ensures
	 * that any unforeseen runtime exceptions are caught and logged
	 * instead of crashing the program.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		try {
			new App();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*==========================
	 * MAIN APPLICATION LOOP
	 *=========================*/
	/**
	 * Serves as the orchestrator of all public classes in all 
	 * packages for the program execution
	 */
	private App() throws IOException{
		
		//initializes ActionMap instance
		actions.registerActions();
		
		ui.showIntroduction();
		
		//gets action names for later use in the program
		String[] actionNames = map.getActionNames();
		
		//caches size for program efficiency while loop structure runs
		int numActions = actionNames.length;
		
		while(config.isContinueProgram()) {
			ui.showBanner(config.getProgramName());
			ui.showOptions(actionNames);
			ui.showEnterPrompt();
			
			//gets user choice from min-max values
			map.perform(ui.getUserChoice(0, numActions-1));
		}
		
		//closes resources on program termination
		ui.close();
	}
}


