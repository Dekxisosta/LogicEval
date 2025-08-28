package dev.dekxi.logic.app.src.dev.dekxi.logic.model;

public class Action{
	/*=================
	 * INSTANCE FIELDS
	 * =============*/
	private String name;
	private Runnable operation;
	
	/*=================
	 * CONSTRUCTOR
	 * =============*/
	public Action(String name, Runnable operation){
		this.name = name;
		this.operation = operation;
	}
	
	/*=================
	 * ACCESSORS AND MUTATORS
	 * =============*/
	public String getName() {return name;}
	
	/*=================
	 * RUN
	 * =============*/
	public void run() {operation.run();};
}