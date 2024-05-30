#variables #debugging 
# Readings
* Chapter 2
# Variables
I talked [[Week 1#Programming Basics|very briefly at the "beginning"]] of last week's lecture and mentioned *variables* special buckets that we can store information in. I didn't do much to explain them outside of describing what they do and including that it requires a *type*. This week let's dive deeper into what each of these actually mean.
## Storing Values
Whenever we want to save a value inside one of our variables, we can use our bucket metaphor to think about what we need to do. If we had a bunch of buckets on a shelf^[These represent variables in memory] we need to be able to determine which bucket is holding what things. One way that we can do this is by giving our variables names like `numStudents` as a variable that counts the number of students in a class, or `isBlue` if we want to know if something is blue or not.

The process of filling the bucket is known as assignment, and is done with a single equals sign `=`. If you encounter code that reads:
```java
numStudents = 13;
```
The plain english translation would be "numStudents is assigned a value of 13" or, a shorter version: "numStudents gets 13." Sometimes people will refer to the assignment operation as a gets operation, these two things are interchangeable. One thing that we must remember though is the variable that we're assigning things to is ***ALWAYS*** on the left side of the assignment operator.

This doesn't mean that we can't assign variables values from other variables. Lets say I wanted to add 3 to `numStudents`. I could do the following line of code:
```java
numStudents = numStudents + 3;
```
In this case, the plain english would be "numStudents gets numStudents plus 3."
### Naming a Variable
Giving a variable a name has almost no requirements. You aren't able to name your variables reserved words^[For example if I were to name a variable `for` the compiler would throw a Syntax error.], but outside of that it is on *you* to pick a name that describes what the variable does. We can think of naming our variables analogous to taking a sharpie or pen and writing on the front of the bucket.
## Types
Not all values were created equally. For example if I were to try and store some number I would need to reserve enough space for a number variable which depending on the kind of number could be anywhere from 1 to 8 bytes in memory. On the other hand, there are far fewer letters or characters to represent, and that will only ever need 2 bytes in memory.

This is why it is important to give our variables *types*. In our bucket metaphor this is similar to colour coding our buckets. If we only put one type of thing in blue buckets, we know what to expect without looking inside. And, just like there are two types of colours^[Depending on who you ask.]: primary and secondary, we have two types of types!
### Primitive Types
The first type of type, the primitive, is the 
"simpler" of the two. These get stored more-or-less directly as binary in the computer. This is because each of our primitive types can be represented directly as a binary number.
#### Aside: Binary
Binary numbers work the same as our "regular" base ten number system. The main difference, is instead of each digit counting how many groups of tens there are, the digits of binary count the groups of two. This means that just like $1337$ is equivalent to $1 \times 10^{3} + 3 \times 1-^{2} + 3 \times 10^{1} + 7 \times 10^{0}$, in binary the number $1010$ is equal to $1\times 2^{3} + 0 \times 2^{2} + 1\times 2^{1} + 0\times 2^{0}$. By doing everything in binary, computers are able to store information as electrical pulses, where a high pulse is assigned a 1 and a low pulse is a zero.
#### The Primitive Types
There aren't that many primitive types, so I can relatively easily include all of them here:
* `int` - Stores a whole number. There's variants on `int`s called `byte`, `short`, and `long` for smaller and larger numbers. A `byte` or a `short` allows for us to store smaller numbers in less memory space, and a `long` is twice as big as an int so we can store bigger whole numbers.
* `double` - Stores fractional numbers. If we have a number that needs to be represented as a decimal, then we want to use something in the `double` family. There are varying degrees of precision depending on your use case, but in java the only other primitive type in this family is the `float`^[Fun fact, the `float` is the original member of this family, `double`s are twice as precise as a `float` and use more memory. We don't need to worry about this as much as we used to, so we'll be using `double`s almost exclusively in this class].
* `boolean` - This is the smallest of the primitives, it stores either a `true` or `false` value!
* `char` - These store a single character of text. However, it doesn't actually store the text itself but rather an integer representation of the number according to the character's ASCII code.
### Non-Primitive Types
We can actually define our own types as programmers by defining objects and classes in our code. These usually come with extra bonus things like methods that we can run and/or multiple fields that we can store things in. We aren't going to be dealing with a lot of them right away, but the biggest one you should be aware of is the `String`. You can think of a `String` as a sequence of `char`s (because that's what they are, in essence). 
## Declaring Variables
With all of that out of our way^[I know it was a lot.], we can start declaring our own variables! A variable declaration is an instruction expression that includes the variables name and type. Going back to our bucket metaphor, this is the process of selecting a bucket and writing the name we want to refer it as and handing that bucket to the compiler to put on the shelf.

We don't have to immediately assign our variables values after they've been declared^[In some cases we might not want to do assign values immediately.]. In code this would look like:
```java
int numStudents;
```
Simple, right? This allocates enough space in memory to hold an `int` primitive and then allows us to later assign it a value in the ways we already covered in [[#Storing Values]]. However, sometimes we want to do our declaration and assignment in one fell swoop! Doing this would look like:
```java
int numStudents = 13;
```
## Using Variables
Just like in math, we have coding expressions made up of one or more variables, operators, parentheses, or literals that would normally appear in code. Generally these expressions are what get evaluated on the right side of an assignment and stored in the variable on the left.
## Constant Variables vs. Literals
Sometimes, we want to reuse a value multiple times over and over again. For example, let's say we are trying to write a program that can calculate how long it would take to travel from one planet to another at light speed. We could write a program like:
```java
class LightspeedCalculator{
	public static void main(String[] args){
		System.out.println("How many miles is it to the planet?");
		// Open the terminal input as a scanner
		Scanner scnr = new Scanner(System.in);
		double distance = scnr.nextDouble();
		System.out.println("Your planet would take " + distance / 671000000.0 + " hours");
	}
}
```
This *works*, but without a comment we wouldn't know that `671000000` is the speed of light in miles per hour. One way that we can fix this is to use a constant variable.

To use a constant variable we attach the keyword `final` to it. We can then change our code to instead be:
```java
class LightspeedCalculator{
	public static void main(String[] args){
		final double LIGHT_SPEED_MPH = 671000000.0
		System.out.println("How many miles is it to the planet?");
		// Open the terminal input as a scanner
		Scanner scnr = new Scanner(System.in);
		double distance = scnr.nextDouble();
		System.out.println("Your planet would take " + distance / LIGHT_SPEED_MPH + " hours");
	}
}
```
This also comes with an added perk! We can refer to this constant variable *anytime* we want the speed of light in miles per hour. Unlike a normal variable that is usually named in *camel case* with the first word lowercase and the first letter of every successive word uppercase, constants are usually written in an all caps *snake case* with underscores separating each of the 