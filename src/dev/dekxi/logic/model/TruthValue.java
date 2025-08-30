package dev.dekxi.logic.model;

public class TruthValue{
	/*=================
	 * INSTANCE FIELDS
	 * =============*/
	private String name;
	private boolean value;
	
	/*=================
	 * CONSTRUCTOR
	 * =============*/
	public TruthValue(String name, boolean value){
		this.name = name;
		this.value = value;
	}
	
	/*=================
	 * ACCESSORS AND MUTATORS
	 * =============*/
	public String getName() {return name;}
	public boolean getValue() {return value;}
	
	public void setValue(boolean value) {this.value = value;}
}