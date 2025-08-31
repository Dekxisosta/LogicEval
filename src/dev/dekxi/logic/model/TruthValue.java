package dev.dekxi.logic.model;

/*===============================
 * TRUTH VALUE MODEL / OBJECT
 *===============================*/
/**
 * Model intended to mimic the concept of Truth Values in mathematics. In
 * the program, name refers to the variable name, and value refers to its
 * equivalent Truth Value (true / false)
 */
public final class TruthValue{
    /*===============================
     * INSTANCE FIELDS
     *===============================*/
	/* Ensures values cannot be mutated easily when using TruthValue object */
	private String name;
	private boolean value;

    /*===============================
     * EXPOSED API / PUBLIC METHODS
     *===============================*/
    /**
     * Public constructor for reusability of TruthValue object <p></p>
     * @param name the name of the value
     * @param value the truth value of the TruthValue object
     */
	public TruthValue(String name, boolean value){
		this.name = name;
		this.value = value;
	}
	
	/** @return name of the TruthValue object */
	public String getName() {return name;}

    /** @return value of the TruthValue object */
	public boolean getValue() {return value;}

    /**
     * Sets the value of the TruthValue to user choice
     * when reading input on console <p></p>
     * @param value of the TruthValue object
     */
	public void setValue(boolean value) {this.value = value;}
}