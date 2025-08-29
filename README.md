# LogicCalc

A console-based logic calculator

## Note from the Author
The purpose of this project is for me to learn about modularity, coupling,
OOP, file reading, javadoc, etc.

I am aware how much of an overkill this is for a boolean logic evaluator
of two variables

## Description
This is a console-based boolean logic evaluator with files separated according
to their responsibilities. You can add actions by adding your own functions 
{@link dev.dekxi.logic.actions.ActionHandler} and putting it in 
{@link dev.dekxi.logic.actions.ActionRegistry}

### Example
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, LogicCalc!");
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

