package dev.dekxi.logic.app.src.dev.dekxi.logic.ui;

enum ConsoleTag {
    INFO("[INFO]"),
    SYSTEM("[SYSTEM]"),
    ERROR("[ERROR]");
	
	//INSTANCE FIELD
    private final String label;
    
    //CONSTRUCTOR
    ConsoleTag(String label) { this.label = label; }
    
    //GETTER
    public String label() { return label; }
}