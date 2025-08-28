package dev.dekxi.logic.app.src.dev.dekxi.logic.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiFunction;
import java.util.function.Function;

import dev.dekxi.logic.data.Config;
import dev.dekxi.logic.data.Data;
import dev.dekxi.logic.model.Action;
import dev.dekxi.logic.model.TruthValue;
import dev.dekxi.logic.ui.ConsoleUI;


class ActionHandler{
	/*=================
	 * INSTANTIATED OBJECTS
	 * =============*/
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	ConsoleUI ui = new ConsoleUI();
	Config config = Config.getInstance();
	static Data data = Data.getInstance();
	
	/*=================
	 * DATA GETTER METHODS
	 * =============*/
	private TruthValue getP() {return data.getP();}
	private TruthValue getQ() {return data.getQ();}
	
	/*=================
	 * DISPLAY CURRENT DATA ACTION
	 * =============*/
	Action showTruthValues() {
		return new Action("SHOW TRUTH VALUES OF P AND Q", 
				()-> printTruthValues()
		);
	}
	
	/*=================
	 * SETTER ACTION
	 * =============*/
	Action setTruthValues() {
		return new Action("SET TRUTH VALUES OF P AND Q", 
				()-> setTruthValue()
		);
	}
	
	/*=================
	 * UNARY OPERATOR ACTIONS
	 * =============*/
	Action showNegationResult() {
		return new Action("NEGATION OF P AND Q", 
				()-> printUnaryResult("NEGATION LOGIC", Logic::getNegation)
		);
	}
	
	Action showIdentityResult() {
		return new Action("IDENTITY OF P AND Q", 
				()-> printUnaryResult("IDENTITY LOGIC", Logic::getIdentity)
		);
	}
	
	Action showTautologyResult() {
		return new Action("TAUTOLOGY OF P AND Q", 
				()-> printUnaryResult("TAUTOLOGY LOGIC", Logic::getTautology)
		);
	}
	
	Action showContradictionResult() {
		return new Action("CONTRADICTION OF P AND Q", 
				()-> printUnaryResult("CONTRADICTION LOGIC", Logic::getContradiction)
		);
	}
	
	/*=================
	 * BINARY OPERATOR ACTIONS
	 * =============*/
	
	Action showConjunctionResult() {
		return new Action("CONJUNCTION OF P AND Q", 
				()-> printBinaryResult("CONJUNCTION LOGIC","P∧Q", Logic::getConjunction)
				);
	}
	
	Action showDisjunctionResult() {
		return new Action("DISJUNCTION OF P AND Q", 
				()-> printBinaryResult("DISJUNCTION LOGIC","P∨Q", Logic::getDisjunction)
			);
	}
	
	/*=================
	 * IMPLICATIONS AND VARIANTS OPERATOR ACTIONS
	 * =============*/
	Action showImplicationResult() {
		return new Action("IMPLICATION OF P AND Q", 
				()-> printBinaryResult("IMPLICATION LOGIC","P→Q", Logic::getImplication)
		);
	}
	
	Action showNonImplicationResult() {
		return new Action("NON IMPLICATION OF P AND Q", 
				()-> printBinaryResult("NON IMPLICATION LOGIC","P→/Q", Logic::getNonImplication)
		);
	}
	
	Action showConverseImplicationResult() {
		return new Action("CONVERSE IMPLICATION OF P AND Q", 
				()-> printBinaryResult("CONVERSE IMPLICATION LOGIC","Q→P", Logic::getConverseImplication)
		);
	}
	
	Action showConverseNonImplicationResult() {
		return new Action("CONVERSE NON IMPLICATION OF P AND Q", 
				()-> printBinaryResult("CONVERSE NON IMPLICATION LOGIC","Q→/P", Logic::getConverseNonImplication)
		);
	}
	
	/*=================
	 * EQUIVALENCE AND EXCLUSIVE OPERATOR ACTIONS
	 * =============*/
	Action showBiconditionalResult() {
		return new Action("BICONDITIONAL OF P AND Q", 
				()-> printBinaryResult("BICONDITIONAL LOGIC","P↔Q", Logic::getBiconditional)
			);
	}
	
	Action showExclusiveOrResult() {
		return new Action("EXCLUSIVEOR OF P AND Q", 
				()-> printBinaryResult("EXCLUSIVEOR LOGIC","P⊕Q", Logic::getExclusiveOr)
		);
	}
	/*=================
	 * NAND, NOR, AND XNOR OPERATOR ACTIONS
	 * =============*/
	Action showNandResult() {
		return new Action("NAND OF P AND Q", 
				()-> printBinaryResult("NAND LOGIC","P↑Q", Logic::getNand)
		);
	}
	Action showNorResult() {
		return new Action("NOR OF P AND Q", 
				()-> printBinaryResult("NOR LOGIC","P↓Q", Logic::getNor)
		);
	}
	Action showXNorResult() {
		return new Action("EXCLUSIVE NOR OF P AND Q", 
				()-> printBinaryResult("EXCLUSIVE NOR LOGIC","P≡Q", Logic::getXNor)
		);
	}
	/*=================
	 * SHOW TABLE ACTIONS
	 * =============*/
	Action showUnaryTruthTable() {
		return new Action("SHOW UNARY TRUTH TABLE",
				()->{
					for(TruthValue var: new TruthValue[] {getP(), getQ()}) {
						String valName = var.getName();
						boolean val = var.getValue();
						
						String[] labels = {
							valName,
							"¬" + valName,
							"⊤",
							"⊥"
						};
						
						boolean[] results = {
							Logic.getIdentity(val),
							Logic.getNegation(val),
							Logic.getTautology(val),
							Logic.getContradiction(val)
						};
						
						ui.printTable(labels, results);
						ui.println();
					}
				});
	}
	
	Action showBinaryTruthTable() {
		return new Action("SHOW BINARY TRUTH TABLE",
				()->{});
	}
	
	Action showImplicationTruthTable() {
		return new Action("SHOW IMPLICATION TRUTH TABLE",
				()->{});
	}
	
	Action showDerivedTruthTable() {
		return new Action("SHOW DERIVED TRUTH TABLE",
				()->{});
	}
	
	/*=================
	 * SYSTEM-RELATED ACTIONS
	 * =============*/
	Action promptProgramTermination() {
		return new Action("TERMINATE PROGRAM",
				()-> terminateProgram());
	}
	
	/*=================
	 * CALLABLE METHODS
	 * =============*/
	
	/*=================
	 * UTILITY / HELPER METHODS
	 * =============*/
	private void setTruthValue() {
		ui.showBooleanOptions();
		setTruthValue(getP());
		setTruthValue(getQ());
	}
	private void setTruthValue(TruthValue t) {
		ui.showEnterPrompt();
		t.setValue(ui.getBoolValue());
	}
	
	private void printUnaryResult(String title, Function<Boolean, Boolean> op) {
		printTruthValues();
		ui.showBanner(title);
		ui.showVar(getP().getName(), op.apply(getP().getValue()));
		ui.showVar(getQ().getName(), op.apply(getQ().getValue()));
	}
	
	private void printBinaryResult(String title, String label, BiFunction<Boolean, Boolean, Boolean> op) {
		printTruthValues();
		ui.showBanner(title);
		ui.showVar(label, op.apply(getP().getValue(), getQ().getValue()));
	}
	
	private void terminateProgram() {
		ui.showBanner("PROGRAM TERMINATION");
		ui.showBooleanOptions();
		boolean terminate = ui.getBoolValue();
		if(terminate) {
			config.setContinueProgram(false); 
			try {
				reader.close();
			} catch (IOException ignored) {}
		}
	}
	
//	private void printTabularTruthValues() {
//		printDoubleBorder(styleA, styleB, 82);
//		UI.printf("%n%s%-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s %s %-6s%s%n",
//	            outer, "P", inner, "Q", inner, "¬P", inner, "¬Q", inner, "P∧Q", inner, "P∨Q", inner, "P→Q", inner, "Q→P", inner, "P↔Q", outer);
//		
//	    for (int mask = 0; mask < 4; mask++) {
//	        boolean pVal = (mask & 0b10) != 0;
//	        boolean qVal = (mask & 0b01) != 0;
//	        
//	        boolean[] results = {
//					Logic.getNegation(pVal),
//					Logic.getNegation(qVal),
//					Logic.getConjunction(pVal, qVal),
//					Logic.getDisjunction(pVal, qVal),
//					Logic.getImplication(pVal, qVal),
//					Logic.getImplication(qVal, pVal),
//					Logic.getBiconditional(pVal, qVal)
//			};
//	        
//	        printRow(inner, results);
//	        UI.println();
//	    }
//	    printDoubleBorder(styleA, styleB, 82);
//	}
	
	
	
	
	private void printTruthValues() {
		ui.showBanner("TRUTH VALUES");
		ui.showVar(getP().getName(),getP().getValue());
		ui.showVar(getQ().getName(),getQ().getValue());
	}
}