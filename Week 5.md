#loops #nestedLoops #enums
# Reading
* chapter 4 part 2
# Loops: Nesting
Just like we could with `if` statements, we can nest loops together. This can be useful for a variety of applications, the book uses two-letter websites with a "`.com`" domain.

# Variable Scope
So far when we've been developing code, we haven't needed to worry about the concept of "scope" all of our code (for the most part) has variables defined outside of `if` blocks and loops. However, we can declare variables inside of these control structures with little to no issues. The problem then comes later if we try to use a variable after the structure where we declared it.

This is because when a variable is created, the compiler will give an instruction to add a new variable onto a place in memory called the stack. Once we exit the control structure the stack's size changes and any new data that was added onto the stack becomes unreachable and thrown out.

This becomes particularly annoying when we are developing more complicated programs with multiple methods. Any variables defined inside a method will only ever exist inside that method. We can get around this by giving a variable class-scope by declaring it outside of a method as a class field like so:

```java
public class Fields{
	int maxCharacters = 9;

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String input = scnr.nextLine();
		if (!input.length() > maxCharacters){
			System.out.println(input);
		}
	}
}
```

Here we've declared a variable maxCharacters and given it an initial value of 9. If we were to expect this variable to never change we could give it the keyword `final`, if we want *all* running instances of this class in the JVM to share the same value for this variable name we would attach the keyword `static`.

# Enumerators
Sometimes, we only need to store a small set of named values. For example, if we are developing a video game and we want our player to be able to select from one of a few difficulty options that slightly modify our game logic, we can have an enumerator that stores these named difficulty options.

```java
public enum Difficulty {EASY, BALANCED, HARD, UNFAIR};
```

This declaration should look very similar to declaring a variable^[In this example it's named `Difficulty`] with instead of an assignment operator and an expression, it instead gets a set of possible values. Another important difference is the name should follow the naming conventions for classes^[It should capitalize the first letter of each distinct "word" in the name]. One last important piece of declaring an enum is its declaration location. If we don't declare it in the same place that we would other class fields, then the enum will only have the scope of where it was declared.

Putting all of this together we could end up with some code that looks like the following that sets a player's health depending on which value was selected.

```java
public class Game{
	public enum Difficulty {EASY, BALANCED, HARD, UNFAIR};
	public static void main(String[] args){
		Difficulty choice = getUserDifficultyChoice();
		switch (choice):
			case EASY:
				setPlayerHealth(200);
				break;
			case BALANCED:
				setPlayerHealth(100);
				break;
			case HARD:
				setPlayerHealth(50);
				break;
			case UNFAIR:
				setPlayerHealth(25);
				break;
	}
}
```