package dev.dekxi.logic.ui;

enum FormatConfig {
	//must be one character strings to avoid weird formatting issues
	VERTICAL_OUTER("||"),
	VERTICAL_INNER("|"),
	HORIZONTAL_OUTER("="),
	HORIZONTAL_INNER("-");

	//INSTANCE FIELD
    private final String label;
    
    //CONSTRUCTOR
	FormatConfig(String label) { this.label = label; }
    
    //GETTER
    public String label() { return label; }
}
