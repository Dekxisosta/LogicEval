package dev.dekxi.logic.app;

/*
 * ==========================================
 * Project: Logic Console UI
 * File:    Main.java
 * Author:  Dekxi (github.com/Dekxisosta)
 * Created: August 28, 2025
 * ==========================================*/

import dev.dekxi.logic.model.ActionMap;
import dev.dekxi.logic.actions.ActionRegistry;
import dev.dekxi.logic.data.Config;
import dev.dekxi.logic.ui.ConsoleUI;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Entry point for the application. Initializes configuration,
 * handles user input, and launches the console UI.
 *
 * <p><b>Notes:</b></p>
 * <ul>
 *   <li>Requires Java 17+</li>
 *   <li>This file is part of the Logic project
 *       (<a href="https://github.com/Dekxisosta/LogicEval">GitHub</a>)</li>
 * </ul>
 *
 * <p><b>Dependencies:</b></p>
 * <ul>
 *   <li>{@link dev.dekxi.logic.actions.ActionRegistry} &ndash; Registry point of all actions.</li>
 *   <li>{@link dev.dekxi.logic.model.ActionMap} &ndash; Centralized datastore for actions.</li>
 *   <li>{@link dev.dekxi.logic.data.Config} &ndash; Holds PROGRAM_NAME, isContinueProgram, etc.</li>
 *   <li>{@link dev.dekxi.logic.ui.ConsoleUI} &ndash; Handles all console display & input.</li>
 * </ul>
 */
public class App{
	/*===============================
	 * ENTRY POINT OF THE APPLICATION
	 *===============================*/
    /** In runtime, only logs severe errors when running the program*/
     private static final Logger LOGGER = Logger.getLogger(App.class.getName());
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
                  new App().run();
            } catch (Exception e) {
                System.out.println();
                LOGGER.log(Level.SEVERE, "Unexpected error occurred while running App", e);
            }
      }
	/*==========================
	 * MAIN APPLICATION LOOP
	 *=========================*/
	/**
	 * Serves as the orchestrator of all public classes in all 
	 * packages under dev.dekxi.logic for the program execution
     *
     * @throws IOException invalid object detected using readLine in console input
	 */
	private void run() throws IOException{
        //instantiate dependencies for program use
        ActionMap map = new ActionMap();
        ActionRegistry actions = new ActionRegistry();
        Config config = Config.getInstance();
        ConsoleUI ui = new ConsoleUI();

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


