#ifelse #if #conditions
# Readings
* Chapter 3
# If/Else If/Else Branches
So far, we've introduced the ideas that code is a sequence of instructions that modifies data, and that variables are buckets that we can store that data in while we're executing those instructions. However, sometimes we are going to need to change what code we're executing depending on the situation. This is where `if` statements and code branches come in!

In practice `if` statements are relatively simple! The general form is:
```java
if (CONDITION) {
	// CODE
}
```
Notice that just like the code in our `main()` method is wrapped in curly braces, we also wrap the code that we want to execute if our condition is true in curly braces. There are other things that we can add into our if branches to make them robust. 
For example, what if we wanted to run some code if the condition is true and different code if it isn't true?  This is where `else` blocks come in handy! The `else` looks like this:
```java
if (CONDITION){
	// CODE TO RUN IF THE CONDITON IS TRUE
} else {
	// CODE TO RUN IF THE CONDITON IS FALSE
}
```
Because the `if` and `else` blocks count as code instructions, we can actually nest our conditions together! This is done like the following:
```java
if (CONDITION) {
	// CODE TO RUN IF THE CONDITION IS TRUE
	if (CONDITION_2){
		// CODE TO RUN IF CONDITION_2 IS TRUE
	}
} else {
	if (CONDITION_3){
		// CODE TO RUN IF CONDITON_1 IS FALSE AND CONDITION_3 IS TRUE
	}
}
```
However, programmers are relatively lazy and typing out a nested if in an else case can get harder and harder to read with the more conditions that we add. This leads us into `else if`! This looks like the following:
```java
if (CONDITION) {
	// CODE TO RUN IF CONDIITON IS TRUE
} else if (CONDITION_2){
	// CODE TO RUN IF CONDITION IS FALSE AND CONDITION_2 IS TRUE
} else {
	// CODE TO RUN IF CONDITION AND CONDITION_2 ARE FALSE
}
```
One thing that you should keep in mind, each `if` branch can only at most have one `else` as the VERY LAST case. However, we can string as many `else if` statements together as long as they follow an initial `if` statement.
# Writing Conditions
## Checking Equality
Now, I've abstracted away what is actually going on in the place of each `CONDITION` when outlining these if statements. These conditions can be boolean variables, or we can use any combination of logical operators! The first I'm going to be introducing is the set of equality operators. With our variables we have a single equals sign meaning assignment, but if we add a second equals sign like this: `==` we have a way to check if two values are exactly equal! This operator has a sibling that returns true if two things aren't exactly equal, a bang followed by an equals like this: `!=`. Because we're going to be introducing a good number of operators it can be helpful to keep this information in a table:

| Operator | English Translation     | Example (x = 5)                                       |
| -------- | ----------------------- | ----------------------------------------------------- |
| ==       | is exactly equal to     | x == 5 evaluates to true<br>x == 9 evaluates to false |
| !=       | is not exactly equal to | x != 5 evaluates to false<br>x != 9 evaluates to true |
## Checking Relation
We don't always want to check if things are exactly equal to another value. Sometimes we want to check if a value is less than or greater than another value. These operators are pretty basic: `<` is the less than operator and `>` is the greater than operator. We can also check if something is less than or equal to or greater than or equal to with `<=` for less than or equal and `>=` for greater than or equal. Updating our table we get the full set of equality and relational operators:

### Full Equivalence Table

| Operator | English Translation         | Example (x = 5)                                                                   |
| -------- | --------------------------- | --------------------------------------------------------------------------------- |
| ==       | is exactly equal to         | x == 5 evaluates to true<br>x == 9 evaluates to false                             |
| !=       | is not exactly equal to     | x != 5 evaluates to false<br>x != 9 evaluates to true                             |
| <        | is less than                | x < 6 evaluates to true<br>x < 4 evaluates to false                               |
| >        | is greater than             | x > 6 evaluates to false<br>x > 4 evaluates to true                               |
| <=       | is less than or equal to    | x <= 5 evaluates to true<br>x <= 6 evaluates to true<br>x <= 4 evaluates to false |
| >=       | is greater than or equal to | x >= 5 evaluates to true<br>x >= 6 evaluates to false<br>x >= 4 evaluates to true |
## Logical Operators
All of this together allows us to check inequality expressions like $x \leq 9$ or $x > 2$ and we *could* in theory combine these by nesting loops to check the combined inequality $2 < x \leq 9$ with:
```java
if (x > 2){
	if (x <= 9){
		// x is greater than 2 and less than or equal to 9
	}
}
```
However, this is a lot of extra characters, and remember programmers are lazy. We can combine distinct conditions using the AND operator (`&&`) if we want our full condition to be true if both sides are true and the OR operator (`||`) if we want our full condition to be true if at least one side is true. The following tables can be a useful guide to remembering  how these operators work. The left side operand is the row and the right side operand is the column.

| &&    | TRUE  | FALSE |
| ----- | ----- | ----- |
| TRUE  | TRUE  | FALSE |
| FALSE | FALSE | FALSE |

| \|\|  | True | FALSE |
| ----- | ---- | ----- |
| TRUE  | TRUE | TRUE  |
| FALSE | TRUE | FALSE |
With all of this together we can combine our conditions! Our previous example $2 < x \leq 9$ becomes the following code:
```java
if ((x > 2) && (x <= 9)){
	// x is greater than two and less than or equal to 9
}
```
We can also evaluate disjoint inequalities too now! $x < 3 \text{ or } x\geq 12$ becomes the combined condition:
```java
if ((x < 3) || (x >= 12)){
	// x is less than three or greater than or equal to 12
}
```

This is not the end of our logical operators! There is one more: the NOT operator `!`. This will flip the value of the condition, so if it was true before it will then be false and vice versa. This table looks like:

|       | ! VALUE |
| ----- | ------- |
| True  | False   |
| False | True    |

## Order of Operations
Now, just like math has a specific order of operations (PEMDAS), conditions also have an order of operations. Also just like math, parentheses get evaluated first from the inner most parenthesis moving outwards. The next operator is logical not, followed by the arithmetic operators. Our relational operators are then evaluated followed by the equality operators. The last operators that get evaluated is the logical and followed by the logical or.
# Boolean Variables
I mentioned [[Week 2|last week]] about a variable type called a `boolean`. These store either a true or a false value. We can assign this value directly by using the keywords `true` and `false`, but we can also use conditional expressions and operators to assign a value dynamically depending on if the condition evaluates to either true or false.
# String Comparisons and Floating Point Comparisons
One thing that you should take note of is that the "is equal to" operator (`==`) will only evaluate as true if the thing on the left is ***EXACTLY*** the thing on the right. Because of this, we usually want to modify slightly our conditions to mimic our expected behaviour.
Because of this, the String class has a few methods. `String.compareTo()` and `String.compareToIgnoreCase()` compares two strings and returns a number: zero if the strings are equal, less than zero if the second string is before the first in alphabetical order, and greater than zero if the second string comes after the first in alphabetical order. The other way that we can check string equality is using `String.equals()` or `String.equalsIgnoreCase()` which will return a boolean value of true if the strings are equivalent strings and false if they are not. Some examples of how we could use these methods are as follows:
```java
String firstString = "Jemma";
String secondString = "Computer Science";
if (firstString.equals(secondString)) {
	// This code will not run, the strings are not equal
}
if (firstString.compareTo(secondString) > 0){
	// This code will run because "Computer Science" comes after "Jemma" in alphabetic order
}
```
If we want to check if a float is equal to another float value we it is best practice to take the absolute value of the difference between our current value and the value we're checking equality against. We can then see if this difference is less than some arbitrary tolerance to determine if the values are close enough to equal that they can be treated as such. This would look like the following in code:
```java
final double tolerance = .01
double float1 = 0.0299
// Check to see if float1 is approximately equal to our desired value
if (Math.abs(float1 - 0.02) <= tolerance){
	// This code will run because 0.0099 is within the tolerance of 0.01
}
```