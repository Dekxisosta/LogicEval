package dev.dekxi.logic.data;

import dev.dekxi.logic.model.TruthValue;

/*===============================
 * DATA CLASS
 *===============================*/
/**
 * Acts as a storage of data in runtime. In this program, only TruthValues are stored
 * <p><b>DEPENDENCIES:</b></p>
 * <ul>
 *     <li>{@link TruthValue}</li>
 * </ul>
 */
public class Data{
    /** Creates an instance of data for singleton class */
	static Data INSTANCE = new Data();

    /** Creates a truth value named P as part of a project requirement  */
	private final TruthValue p = new TruthValue("P", true);

    /** Creates a truth value named Q as part of a project requirement  */
	private final TruthValue q = new TruthValue("Q", false);

    /** Private constructor for singleton instance  */
	private Data() {}

    /** Getter method of the singleton instance  */
	public static Data getInstance() {return INSTANCE;}

    /** Getter method of Truth Value P */
	public TruthValue getP() {return p;}

    /** Getter method of Truth Value Q*/
	public TruthValue getQ() {return q;}

    /** Setter method of Truth Value P */
	public void setP(boolean p) {this.p.setValue(p);}

    /** Setter method of Truth Value Q */
	public void setQ(boolean q) {this.q.setValue(q);}
}