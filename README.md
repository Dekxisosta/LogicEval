# LogicCalc

A console-based logic calculator

## Table of Contents
- [Description](#description)
- [ActionHandler Sample Code](#actionhandler-sample-code)
- [ActionRegistry Sample Code](#actionregistry-sample-code)
- [Disclaimer](#disclaimer)

## Description
This is a console-based boolean logic evaluator with files separated according
to their responsibilities. You can add other console-based actions by adding an Action object in
[ActionHandler.java](https://github.com/Dekxisosta/LogicEval/blob/main/src/dev/dekxi/logic/actions/ActionHandler.java) and putting it in 
the actionMap singleton instance via [ActionRegistry.java](https://github.com/Dekxisosta/LogicEval/blob/main/src/dev/dekxi/logic/actions/ActionRegistry.java)

## Sample Console Menu Output
This is the sample actions inputted in the system. 
By following the instructions from [Description](#description), you can expand this even more
``` 
+++==========================================+++
{| DEV DEKXI'S CONSOLE-BASED LOGIC CALCULATOR |}
+++==========================================+++
[1] SHOW TRUTH VALUES OF P AND Q
[2] SET TRUTH VALUES OF P AND Q
[3] NEGATION OF P AND Q
[4] IDENTITY OF P AND Q
[5] TAUTOLOGY OF P AND Q
[6] CONTRADICTION OF P AND Q
[7] CONJUNCTION OF P AND Q
[8] DISJUNCTION OF P AND Q
[9] IMPLICATION OF P AND Q
[10] NON IMPLICATION OF P AND Q
[11] CONVERSE IMPLICATION OF P AND Q
[12] CONVERSE NON IMPLICATION OF P AND Q
[13] BICONDITIONAL OF P AND Q
[14] EXCLUSIVEOR OF P AND Q
[15] NAND OF P AND Q
[16] NOR OF P AND Q
[17] EXCLUSIVE NOR OF P AND Q
[18] SHOW UNARY TRUTH TABLE
[19] SHOW BINARY TRUTH TABLE
[20] SHOW IMPLICATION TRUTH TABLE
[21] SHOW DERIVED TRUTH TABLE
[0] TERMINATE PROGRAM
```

### ActionHandler Sample Code
See [ActionHandler.java](https://github.com/Dekxisosta/LogicEval/blob/main/src/dev/dekxi/logic/actions/ActionHandler.java) for more details
```java
/**
 * Creates and returns a new Action to be registered in the program.
 *
 * Each Action consists of:
 * - a String label, which is the name displayed in the console
 * - a Runnable, which is the code executed when the action is triggered
 *
 * @return a new Action object containing the action's name and behavior
 */
public class ActionHandler {
    void yourFunction() {
        return new Action("ActionName",
            ()-> {
                //your function's code
            }
        );
    }
}
```
### ActionRegistry Sample Code
See [ActionRegistry.java](https://github.com/Dekxisosta/LogicEval/blob/main/src/dev/dekxi/logic/actions/ActionRegistry.java) for more details
```java
/**
 * Registers available actions by retrieving them from the ActionHandler
 * and putting them into ActionMap. 
 * 
 * This ensures all actions are initialized and ready 
 * for use in the console application
 */
import dev.dekxi.logic.actions.ActionHandler;
public class ActionRegistry {
    public void registerActions() {
        //stores registed actions in an Action array for later indexing
        Action[] = {
            //other actions
            handler.yourFunction()
        }

        //sets index for each action in actions
		for(int i=0; i<actions.length;i++)
			putAction(i+1,actions[i]);

		//0 is a special placeholder for program termination
		putAction(0, handler.promptProgramTermination());
    }
}
```

You can add or change code blocks in [ConsoleUI.java](https://github.com/Dekxisosta/LogicEval/blob/main/src/dev/dekxi/logic/ui/ConsoleUI.java) to 
manipulate the formatting of console print-outs

## Disclaimer
LogicCalc is a practice project developed to experiment with software design principles.  
While functional, the codebase may not reflect best practices for a production-ready tool.

