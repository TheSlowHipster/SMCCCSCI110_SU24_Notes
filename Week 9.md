# Reading
* Chapter 7
# User-Defined Classes
Sometimes the classes provided by java or other programmers isn't sufficient for our purposes! This is where user defined classes come in handy. We can use these classes as reference values in our code as if they came from java itself! When we do this, the class in memory (and the ideas that it represents and/or abstracts) is known as an *object*.

Objects are helpful in computer programming because they allow us to abstract away the intricacies of interacting with the actual code. Take for example the `String` class. We've talked before how `String`s are a sequence of `char`s stored in a reference variable^[Which is true to an extent.] but not only are they an array of `char`s, because they are objects the reference also includes pointers to methods that are unique to `String`s. If `String` wasn't an object, and instead was just a `char[]` we would have to manually implement things like `.isEmpty()` or `.strip()`.

## Using User-Defined Objects
When we write our own classes we are defining an object that other programmers and users can interact with. Any class property^[Methods and fields.] marked `public` will be able to be interacted with directly by other programmers and users.

However in order to do this we need to create a new instance of the object. We can do this the same way we would any reference variable. Declaring a new variable with a type that matches the class we want an object instance of, and call its initialization code with the keyword `new` with the object's constructor. An example of this could look like the following:

```java
// The Class we want an instance of in the file Student.java
public class Student{
	public int studentID;
	public String[] classNames;
}

// A seperate file called ClassList.java
public class ClassList{
	public Student[] students;
}
```

### The Constructor
Now with the example above we ***could*** create a new instance, but we haven't explicitly told the `Student` class what to do when we create a `new` instance. In order to do this we need to define a special kind of method, the *constructor*! This method is slightly different from the other methods we can define, it returns an instance of the class and can only be called by using the `new` keyword. To reflect this, it doesn't have a return type and must always be public. To modify our `Student` class to randomly assign a student ID whenever we have a new instance we can modify the above code to include a constructor!

```java
// The Class we want an instance of in the file Student.java
import java.util.*;
public class Student{
	public int studentID;
	public String[] classNames;

	public Student(){
		Random rnd = new Random();
		studentID = rnd.nextInt();
	}
}

// A seperate file called ClassList.java
public class ClassList{
	public Student[] students;
}
```

We now have a constructor for `Student` that takes in no arguments (no parameters were given in the constructor's declaration) and creates a new student with a random integer ID. We can give `ClassList` a constructor that takes in an array of `Student`s to end up with the following code:

```java
// The Class we want an instance of in the file Student.java
public class Student{
	public int studentID;
	public String[] classNames;

	public Student(){
		Random rnd = new Random();
		studentID = rnd.nextInt();
	}
}

// A seperate file called ClassList.java
public class ClassList{
	public Student[] students;

	public ClassList(Student[] studentList){
		students = Arrays.copyOf(studentList, studentList.length);
	}
}
```

This isn't the only way that we can give fields an initial value, we could assign a default value by performing variable assignment, but this is generally restricted to assignment of specific values and not code expressions.
## Aside: Access Modifiers
We've touched them briefly, but access modifiers change where a property of an object can be used. If a property is `public` it can be accessed by any code in the current context regardless if the code is in the same class or package. If a property is `protected` it can only be used in the package the class is defined in. Finally, if a property is `private` it cannot be accessed outside of the class without additional help.

## Accessors and Mutators
Accessors and mutators^[Also known as setters and getters.] are the main way to interact with private variable fields. They are each methods created by the user, and are mostly abstract concepts without any hard-and-fast rules. A mutator is any method that changes a private field, this could be adding or subtracting from a numerical value or simply doing an assignment of a new value. An accessor will access the private field and return a value, but not change it.

### Aside: Helper Methods
Like accessors and mutators, there isn't any hard-and-fast rules as to what a helper method *has* to be. Generally a helper method is a method that isn't used outside of the code in the class^[Meaning it should be marked either `private` or `protected`.] and "helps" methods that are public.

## Using the `main()` Method
Just like we have been all semester for our projects and labs; we can include a `main()` method in user defined classes! These main methods function exactly the same as our previous main methods and provide an entry point for our code if a class is being run on its own and not as an instance of an object in memory.

Because the main method only runs when the class it is in is the code being run by the JVM, this is a great place to include any unit tests we would want to run while still keeping things simple.
