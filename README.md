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

### Sample code
```java
public class Action {
    public void registerActions() {
        handler.showNumbers()
    }
}
```

You can add or change code blocks in {@link dev.dekxi.logic.io.ConsoleUI} to 
manipulate the formatting the console print-outs

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, LogicCalc!");
    }
}
```

