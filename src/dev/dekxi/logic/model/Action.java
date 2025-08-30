package dev.dekxi.logic.model;

public final class Action{
	/*=================
	 * INSTANCE FIELDS
	 * =============*/
    /** Name displayed on console*/
	private String name;

    /** Operation performed by an Action*/
	private Runnable operation;
	
	/*=================
	 * CONSTRUCTOR
	 * =============*/
    /** Public constructor for later instantiation*/
	public Action(String name, Runnable operation){
		this.name = name;
		this.operation = operation;
	}
	
	/*=================
	 * ACCESSORS AND MUTATORS
	 * =============*/
    /**
     * Getter method for action name
     *
     * @return  {@link name} for console rendering
     */
	public String getName() {return name;}
	
	/*=================
	 * RUN
	 * =============*/
	public void run() {operation.run();};
}