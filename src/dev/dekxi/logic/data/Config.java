package dev.dekxi.logic.data;

/**
 * Singleton configuration holder for program constants and runtime flags,
 * such as the program name and the execution continuation state
 * <p>
 * Provides access to program constants and runtime flags
 * such as the program name and whether execution should continue.
 * </p>
 */
public final class Config {
    /** Singleton instance of this class*/
    private static final Config INSTANCE = new Config();

    /** The program's name used for console rendering */
    private final String PROGRAM_NAME = "DEV DEKXI'S CONSOLE-BASED LOGIC CALCULATOR";

    /** Flag indicating whether the program continues or terminates. */
    private boolean continueProgram = true;

    /** Private constructor to enforce singleton usage */
    private Config() {}

    /**
     * Gets the singleton instance of config
     *
     * @return {@code INSTANCE} to use config data
     */
    public static Config getInstance() {
        return INSTANCE;
    }

    /**
     * Gets program name for console ui output
     *
     * @return {@code PROGRAM_NAME} the program's name
     */
    public String getProgramName() {
        return PROGRAM_NAME;
    }

    /**
     * Checks whether the program is set to continue execution.
     *
     * @return {@code true} if the program should continue, {@code false} otherwise
     */
    public boolean isContinueProgram() {
        return continueProgram;
    }

    /**
     * Sets the program's continued execution to value passed
     *
     * @param value determines the continuation of the program
     */
    public void setContinueProgram(boolean value) {
        this.continueProgram = value;
    }
}
