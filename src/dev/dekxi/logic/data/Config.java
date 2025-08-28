package dev.dekxi.logic.app.src.dev.dekxi.logic.data;

public final class Config {
    private static final Config INSTANCE = new Config();

    private final String PROGRAM_NAME = "DEV DEKXI'S CONSOLE-BASED LOGIC CALCULATOR";
    private boolean continueProgram = true;

    private Config() {}

    public static Config getInstance() {
        return INSTANCE;
    }

    public String getProgramName() {
        return PROGRAM_NAME;
    }

    public boolean isContinueProgram() {
        return continueProgram;
    }

    public void setContinueProgram(boolean value) {
        this.continueProgram = value;
    }
}
