package dev.dekxi.logic.actions;

/**
 *
 */
class Logic{
	/*=================
	 * UNARY PACKAGE-PRIVATE FUNCTIONS
	 * =============*/
	static boolean getContradiction(boolean p) {
		return false;
	}
	static boolean getTautology(boolean p) {
		return true;
	}
	static boolean getIdentity(boolean p) {
		return p;
	}
	static boolean getNegation(boolean p) {
		return !p;
	}
	/*=================
	 * BINARY PACKAGE-PRIVATE FUNCTIONS
	 * =============*/
	static boolean getConjunction(boolean p, boolean q) {
		return p && q;
	}
	static boolean getDisjunction(boolean p, boolean q) {
		return p || q;
	}
	
	/*=================
	 * IMPLICATIONS AND VARIANTS PACKAGE-PRIVATE FUNCTIONS
	 * =============*/
	static boolean getImplication(boolean p, boolean q) {
		return !p || q;
	}
	static boolean getNonImplication(boolean p, boolean q) {
		return p && !q;
	}
	static boolean getConverseImplication(boolean p, boolean q) {
		return !q || p;
	}
	static boolean getConverseNonImplication(boolean p, boolean q) {
		return q && !p;
	}
	
	/*=================
	 * EQUIVALENCE AND EXCLUSIVE PACKAGE-PRIVATE FUNCTIONS
	 * =============*/
	static boolean getBiconditional(boolean p, boolean q) {
		return p == q;
	}
	static boolean getExclusiveOr(boolean p, boolean q) {
		return p ^ q;
	}
	
	/*=================
	 * NAND, NOR, AND XNOR PACKAGE-PRIVATE FUNCTIONS
	 * =============*/
	static boolean getNand(boolean p, boolean q) {
		return !(p && q);
	}
	static boolean getNor(boolean p, boolean q) {
		return !(p || q);
	}
	static boolean getXNor(boolean p, boolean q) {
		return !(p ^ q);
	}
}