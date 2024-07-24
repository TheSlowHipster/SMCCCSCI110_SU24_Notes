# Reading
* Chapter 06 - Methods
# The Absolute Basics About Methods
A method (or function, the distinction between the two is negligible for our case) is simply a named list of statements. We've had a good amount of practice with a very specific method so far: the `main()` method!
## Declaring a Method
The declaration of a method involves using a few specific keywords: an access modifier, and a return type. If a method's code is going to be shared across all instances of the class then we can include the `static` keyword to signify it in-between the access modifier and the return type. The last part of the declaration is the name of the method followed by its parameters inside parenthesis. Taking a look at `main()` we can see all of these!
```java
//  access modifier is static return   name(parameters)
	    public       static    void   main(String[] args){
	
}
```

`main()` does not have a `return` statement, so it effectively returns nothing which in the computer is represented as the value `null`. The `null` value in most programming languages is unique, because it represents "nothing" it technically doesn't have a type which in java means that its type is `void`.
## Returning a Value
Sometimes we have situations where a method does need to return a value. This is relatively simple to do! Instead of giving `void` as the return type, we simply include the type for the value that we will be returning. We can have any type be the return type, as long as it exists in the current code's JVM. The only restriction on the `return` statement is that we can only return one value. This value could be an array, or it could be the result of a code expression but we can only return one value.

That being said, a method *can* have multiple return points. It may be tempting to put these throughout the method whenever you'd want to make a return, but even though you *can* doesn't mean you *should*. Instead if you're returning at multiple points, make sure you are thinking about the logical flow of your code and never include more than are absolutely necessary.
## Method Parameters
Unlike how we can only return one value, we can have as many parameters in our methods as we want! These parameters will be treated like local variables in memory, storing a copy of the value passed in as an argument. Each parameter will need a type and a name separated by commas; outside of this there are no restrictions on how many^[We can even have zero.] or what type of parameter a method gets when declaring it.
## Calling a Method
### Calling a `static` Method
Calling the method is relatively simple. All we need is an instance of an object or direct reference to the method in the class to call our method! If we're inside the `main()` method for the class that contains the method we want and the method we want is also `static` then we're basically done! We can simply include the name of the method and argument values corresponding to each parameter like the following code example:
```java
public class Example{
	public static void exampleMethod(int toPrint){
		System.out.println(toPrint);
	}

	public static void main(String[] args){
		exampleMethod(100);
	}
}
```
### Calling a non-`static` Method
However, `static` methods aren't always exactly useful. For example we can't use non-static attributes so if we have variable fields we can't use them. In almost all other cases we will need a non-static instance of the class. This can be done *very* easily in the `main()` method by creating a *driver reference variable*. We can then use this driver variable to call our methods! This would look similar to the following code:
```java
public class Example{
	public double multiplyTwoNumbers(double numberOne, double numberTwo){
		return numberOne * numberTwo;
	}

	public static void main(String[] args){
		Example driver = new Example();
		System.out.println(driver.multiplyTwoNumbers(10.5,0.001));
	}
}
```

This can get relatively tedious, and what is recommended is to create a driver variable that calls a non-static `run()` method. Inside our `run()` we no longer need to specify which instance, each time we access a class property^[A variable field or method.] the keyword `this` is implicitly used.
# Writing Your own Methods
Just like we have been doing with the `main()` methods we can include loops and branches without issue. The only thing that should be considered is that any `return` statements inside these command structures may cause unreachable code!
## Unit Testing
When you are writing methods it is important to regularly test your code. Writing code in the `main()` method that calls either a `test()` method or testing each method directly. This process is known as *unit testing* and a good unit test will provide abnormal or extreme values that could be expected and should be handled properly. BE SURE TO BE THOROUGH!!! There is a relatively old joke related to unit testing that goes like:

	A programmer is testing a bartender robot. They order one beer, they order two beers, they order 1,000 beers, and they order a cocktail. Satisfied that they've covered all bases they open the bar to the public. The first customer walks in and orderes a soda; the bar burns down.

# How a Method Works
Each time we call a method new parts of memory get allocated for special structures that help the computer keep track of the variables in our method calls. A `return` statement will free up all of the allocated memory except for the value that the `return` is returning.

Any arguments passed in get copied over to the parameters. For primitive values this is relatively easy, the value gets copied and stored in the new variable. For reference variables the process involves copying the memory address instead of the values. This means that while we can change the thing being referenced, we can't change the reference itself.

# Commenting Our Methods
Each language will have different documentation requirements. For java, the requirements are outlined on the official webpage [here](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html). I won't be asking questions about this on exams, but properly commenting your code *is* a part of the coding requirements.