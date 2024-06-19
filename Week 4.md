#loops #for #while 
# Reading
* Chapter 4 sections 1-6
# Loops
[[Week 3|If/else]] blocks aren't our only options for program flow! We can also repeat code blocks multiple times depending on a condition! There are a few types of loops, but the ones we'll be focusing on in this class are the standard `while` loop and the `for` loop. 
## while Loops
Generally, loops will execute whatever code is inside the block that is attached to the statement until some condition is false. In a `while` loop this is fairly obvious. A while, just like the standalone `if` consists of a declaration with the keyword `while` and some condition in parenthesis with the code block in curly braces after the condition like the following code snippet:
```java
while (CONDITION) {
	// code goes here
}
```
This will have our code check our condition before running the code inside the loop, and before every subsequent time through the loop (called an iteration). So long as our condition evaluates to `true` the loop's body executes. We as programmers should build our conditions carefully, because if we have a loop condition that is never `false` the code after our loop will never execute and be unreachable.
Just like our `if` statement we can use any of the relational or logical operators from last week in our condition to build more complex conditions. However, it is important to remember that the condition we're including is what should be true while we are iterating over the code.
### Special Considerations for while Loops
#### Getting User Input
Take a look at the project 1 code. Inside each of the functions I have provided is a while loop that loops until an input of the expected type is provided. One of the important things about how this code is set up is the fact that I polled the scanner being used for information *BEFORE* the loop. We'll talk some more about it later, but this is partially due to something called variable *scope*. Inside the loop there's some code that we haven't talked about yet, the `try/catch` statement, which isn't part of this course's standard curriculum but I'll explain briefly in the following [[#Aside the try/catch|aside]].
For clarity's sake I'll pull the loop to process a user's input as a double:
```java
public double getDoubleFromUser() {
	// get a new scanner that reads from the terminal
	Scanner scnr = new Scanner(System.in);
	// get the user's next input
	String userInput = scnr.next();
	// assume the user's input isn't a double
	boolean isDbl = false;
	// give the return value a default value
	double retVal = Double.MIN_VALUE;
	// while the user's input isn't a double
	while (!isDbl) {
		try {
			// Try to parse the input as a double
			retVal = Double.parseDouble(userInput);
			// If it was successful we then execute this line
			isDbl = true;
		// If the parsing as a double doesn't work, the second line is skipped and the catch runs instead.
		} catch (NumberFormatException e) {
			// Prompt for a new user input
			System.out.printf("I don't recognize your input \'%s\' as a double. Please try again.\n", userInput);
			// Get a new user input
			userInput = scnr.next();
		}
	}
	return retVal;
}
```
If we were to simplify this into its parts the pseudocode would look more like:
```pseudocode
double getDoubleFromUser():
	Create a scanner to read input
	read one token of input
	while the input isn't valid:
		if the input is valid:
			return the double value
		else:
			reprompt the user for different input
			read one token of input
```
If we ever want to have a loop that validates user input this will almost always be the structure of the loop you will want to use.
##### Aside: the try/catch
If we are going to run code that could provide an error, sometimes we want to handle that as a part of expected behaviour; this is where the `try/catch` comes in! It runs the code as normal inside the `try` block, and will catch an error in an associated variable declared in a `catch`'s parenthesis and then execute the code in that specific `catch` blocks code.
## for Loops
Compared to a `while` loop, at a glance `for` loops seem more complicated than their counterpart. However, this appearance dissolves almost immediately upon further inspection. Unlike the `while` loop which only has the loops depending on the condition inside the parentheses, `for` loops have three parts inside the parenthesis. The first section defines the variable that the loop will use to keep track of iterations (called the iterator variable), the second section is the loop's condition, and the last section defines how the iterator should change upon each loops conclusion. Each section is separated by a semicolon (`;`) and this leads `for` loops to look like the following:
```pseudocode
for (iteratorVariableExpression; iteratorCondition; iteratorUpdateExpression){
	// code goes here
}
```
Notice that the first and last sections are labeled as expressions! This means that we theoretically could use any expression. For example, if we wanted to have some variable that started at an arbitrary integer value (for our case lets use 3) we could declare our variable either inside or outside this expression and assign it a value inside this section.
For the iterator update expression, we can include any code expression that modifies our iterator variable! This could be something like `iterator = iterator + 5` or, if we're only going to change our value by positive or minus one we can use the [[#Aside Increment and Decrement Operators|increment or decrement operators]] respectively.
With all of this we have the knowledge that we need in order to start building `for` loops. For example, we could have a loop that iterates from zero to 10 with the following code:
```java
int i;
for (i = 0; i < 11; i++){
	System.out.print(i + " ");
}
```
This would give us the following output:
```
0 1 2 3 4 5 6 7 8 9 10
```
Or, we could create an identical loop with the same output!
```java
for (int i = 0; i < 11; i = i + 1){
	System.out.print(i + " ");
}
```
### Aside: Increment and Decrement Operators
The increment operator `++` will increase by one and evaluate whatever `int` variable it is attached to. Similarly and inversely the decrement operator `--` will decrease by one and evaluate whatever `int` variable it is attached to. These are some of the few operators that can be used by themselves without assignment, because they are a shorthand way to reassign a value either one more or less (depending on the operator you used). Where the operator is placed is important! If it is before the variable like `++myInt` it is called a pre-increment (or pre-decrement if using the decrement operator) and if it is after the variable like `myInt++` it is a post-increment (or post-decrement when using the decrement operator). The difference extends beyond the name itself, the pre-variants of the operator increase the variable first and then uses the new value. The post-variants of the operators conversely use the current value in the expression and then increment.
## Loop Variants
Because we have some time I'm going to be including some loop options that have alternate use cases from the standard `while` and `for` loop.
### The do-while loop
The `do-while` loop functions similarly to the `while` loop with the main notable exception being the loop's code and condition are inverted! Instead of checking the condition before the loop executes, the `do-while` loop will execute the code once before checking the condition. If we were to use this as input validation it could look something like the following code:
```java
Scanner scnr = new Scanner(System.in);
String input
do {
	System.out.println("Type 'jem' to continue");
	input = scnr.next();
} while (!input.equals("jem"));
```
These loops are particularly helpful if we know that we will need to execute the code inside the loop at least once no matter what the initial condition would evaluate to.
### The Enhanced for Loop
We haven't yet encountered a use-case for this kind of loop before, but some variables that represent multiple values (also known as a "set") can be iterated over using the variables' iterator. Usually these variables will be a reference type, meaning we can't use primitive types, but sometimes we can use an array^[A special type of data that holds multiple values that we'll talk about after the midterm]. This loop works by declaring a variable that we want to use to hold the current iteration's entry in the set and the set that we're iterating over. In practice this would look like:
```java
// declaring an array that we can iterate over and assining it the first 6 values of the Fibonacci sequence
int[] numbers = {1, 1, 2, 3, 5, 8};
for (int i : numbers){
	System.out.print(i+ " ");
}
```