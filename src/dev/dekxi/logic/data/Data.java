package dev.dekxi.logic.data;

import dev.dekxi.logic.model.TruthValue;

public class Data{
	static Data INSTANCE = new Data();
	private final TruthValue p = new TruthValue("P", true);
	private final TruthValue q = new TruthValue("Q", false);
	
	private Data() {}
	public static Data getInstance() {return INSTANCE;}
	
	public TruthValue getP() {return p;}
	public TruthValue getQ() {return q;}
	
	public void setP(boolean p) {this.p.setValue(p);}
	public void setQ(boolean q) {this.q.setValue(q);}
}