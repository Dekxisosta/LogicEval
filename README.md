# LogicCalc

A console-based logic calculator

## Note from the Author
The purpose of this project is for me to learn about modularity, coupling,
OOP, file reading, javadoc, etc. I am aware how much of an overkill this is 
for a boolean logic evaluator of merely two variables

## Description
This is a console-based boolean logic evaluator with files separated according
to their responsibilities. You can add other console-based actions by adding an Action object in
[ActionHandler.java](https://github.com/Dekxisosta/LogicEval/blob/main/src/dev/dekxi/logic/actions/ActionHandler.java) and putting it in 
the actionMap via [ActionRegistry.java](https://github.com/Dekxisosta/LogicEval/blob/main/src/dev/dekxi/logic/actions/ActionRegistry.java)

### ActionHandler Sample Code
```java
/*
*Handles returning of code functionality for program use
*@return Action object (String s, Runnable r)
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
```java
/*
*Registers actions from handler
* @What to write here???
*/
public class ActionRegistry {
    public void registerActions() {
        handler.yourFunction()
    }
}
```

You can add or change code blocks in [ConsoleUI.java](https://github.com/Dekxisosta/LogicEval/blob/main/src/dev/dekxi/logic/ui/ConsoleUI.java) to 
manipulate the formatting of console print-outs

