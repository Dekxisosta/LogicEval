package dev.dekxi.logic.ui;

/*===============================
 * CONSOLE TAG CONFIGURATION / ENUM
 *===============================*/
/** Ensures a uniform display of related messages in the console */
enum ConsoleTag {
    /* Constants used for different labels when displaying console messages */
    INFO("[INFO]"),
    SYSTEM("[SYSTEM]"),
    ERROR("[ERROR]");
	
	/** Private to ensure no outside mutation happens*/
    private final String label;
    
    /**
     * Package-private constructor to ensure fixed package-only scope <p></p>
     * @param label used to get constants of ConsoleTag class
     */
    ConsoleTag(String label) { this.label = label; }
    
    /** @return label used for formatting labelled messages */
    public String label() { return label; }
}