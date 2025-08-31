package dev.dekxi.logic.model;


/*===============================
 * ACTION MODEL / OBJECT
 *===============================*/
/**
 * Object that has a corresponding name to its runnable function.
 * This is later mapped using the {@link ActionMap} object inside
 * the {@link dev.dekxi.logic.actions} package
 */
public final class Action{
	/*=================
	 * INSTANCE FIELDS
	 * =============*/
    /** Name displayed on console*/
	private String name;

    /** Operation performed by an Action*/
	private Runnable operation;
	
	/*=================
	 * EXPOSED API / PUBLIC METHODS
	 * =============*/
    /**
     * Public constructor for later instantiation
     * @param name the name of the action
     * @param operation the operation performed by the runnable
     *      associated with the action object
     */
	public Action(String name, Runnable operation){
		this.name = name;
		this.operation = operation;
	}

    /** @return name for console rendering*/
	public String getName() {return name;}
	
    /** Runs the runnable associated with the action object */
	public void run() {operation.run();};
}