# Reading
* Chapter 5 - Arrays
# Arrays
Occasionally, we will need to store more than one value in a variable. One way that we can do this is by creating an array! An array is a special kind of reference variable that holds the reference to where the data is being stored.

One special thing about arrays is that unlike other reference variables that can hold sets, an array stores the data (individual entries are called elements) in a specific order **AND** are stored sequentially in memory. This guarantee is not true for other sets, or other ordered sets. Because the data is stored consecutively in memory, accessing any specific element of our array is effectively as free as any other reference variable.

One drawback from all of this is arrays' size are set when we create them. 
# How Do We Use an Array?
## Initialization
Declaring an array is relatively simple! It's like creating any other variable where the declaration needs a variable type, but instead of only having the type we'll also include some square braces immediately following the type declaration, and then the variable name like the following code:

```java
int[] myArray;
```

We can then assign values to our array a few different ways. If we don't know the values, but do know the size we can create a new instance of an "empty" array with a default value like so:

```java
myArray = new int[10]
```

Would create an array that looked like the following:

| index | value |
| ----- | ----- |
| 0     | 0     |
| 1     | 0     |
| 2     | 0     |
| 3     | 0     |
| 4     | 0     |
| 5     | 0     |
| 6     | 0     |
| 7     | 0     |
| 8     | 0     |
| 9     | 0     |
NOTICE! The index doesn't start counting at 1! It is more memory efficient to start at zero, and generally all computer languages will start their arrays this way.

If we know the values of the array, we can also assign them all at once! This method only works if the array hasn't been assigned values yet, but it would look like^[The whitespaces are there for readability purposes, you could seperate each number with a comma and a newline if you want.]:

```java
myArray = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
```

This gives us an array that looks like this in memory:

| index | value |
| ----- | ----- |
| 0     | 10     |
| 1     | 9     |
| 2     | 8     |
| 3     | 7     |
| 4     | 6     |
| 5     | 5     |
| 6     | 4     |
| 7     | 3     |
| 8     | 2     |
| 9     | 1     |
## Accessing an Array's Elements
The indexes of the array will always be whole numbers^[Except in some weird cases for non-java languages] and because of this only `int` variables or values can be used to access a given index. Also, like previously mentioned, the index count starts at zero and goes until one less than the length of the array^[This is because we get zero for free in binary as the "first" number without needing extra digits.]
## Iterating Over the Array
We can iterate over arrays relatively easily! A standard `for` loop is excellent for this job if we use the iterator variable as our indexer like the following example:

```java
String[] myArray = {"Hello,", "world!"};
for (int i = 0; i < myArray.length; i++){
	System.out.print(myArray[i] + " ");
}
System.out.print("\n");
```

In this example, we're using a special attribute of the reference variable `myArray`, called a property. `length` is a property of *all* arrays, and can be accessed by calling `arrayName.length`. There is no element at `length`, this will always be out of bounds, because the size starts counting at 1 and the index does not. The last element of the array will always be `length-1`. If we try to access an index that does not exist in the array, we will error out and our code will crash.

One way that we can avoid going out of bounds while looping over our array is the enhanced `for` loop^[also called a for-each loop] that gives a variable that will be assigned each value in the array exactly once. This is slightly faster to read and type, but only allows for the value to be accessed, not assigned. In code the following two examples are functionally the same:

```java
// Example 1
String[] names = new String[45];
for (String name : names){
	System.out.println(name);
}

// Example 2
String[] names = new String[45];
for (int i = 0; i < names.length; i++){
	String name = names[i];
	System.out.println(name);
}
```

This should help make it more clear why modifying the iterator variable in the for-each loop does not affect the values in the array.
## Modifying and Copying Arrays
### Modification
We can modify our array's elements by accessing them and performing an assignment on an array's given index. This is done by using `arrayName[index]` on the left side of the assignment operator and the value or expression to be assigned gets placed on the right, the same way we would for any other variable assignment. The code to do this looks like the following:

```java
int[] myArray = new int[5];
myArray[4] = 3;
```

Represented as a table this code would give us:

| index | value |
| ----- | ----- |
| 0     | 0     |
| 1     | 0     |
| 2     | 0     |
| 3     | 0     |
| 4     | 3     |
### Array Copy
If we want to copy an array, the naive approach is usually to do the following:

```java
int[] myArray = new int[10];
int[] copyArray = myArray;
```

But there is a problem with this, we aren't actually copying the array. Because arrays are reference variables, we're only copying the reference to the array in memory and any changes we make to `copyArray` will also be made to `myArray`. To get around this we can do one of two things, we could do a manual deep copy where we create a new instance of an array of the same size and copy each element like so:

```java
int[] myArray = {1, 2, 3, 4, 10};
int[] copyArray = new int[5];
for (int i = 0; (i < myArray.length) && (i < copyArray.length); i++){
	copyArray[i] = myArray[i];
}
```

Or we could use the builtin `Arrays` method `Arrays.copyOf()` which takes in our original array and the desired length of our new copy. This would look like the following in code:

```java
int[] myArray = {1, 1, 2, 3, 5};
int[] copyArray = Arrays.copyOf(myArray, 5);
```

The only caveat being that we would need to import the `Arrays` code from `java.util` at the top of our `.java` file in order to use the second method.

# Arrays Storing Arrays
Like a regular variable, we can put whatever we want inside an array so long as it matches the type. This includes other arrays! Because each array is simply a reference to a chunk of memory where everything is stored sequentially, we can store array references inside our outer arrays. This is how we get multi-dimensional arrays! To declare a multi-dimensional array we need to know how many dimensions the array will have, and this is indicated by how many sets of square braces exist in the declaration and initialization of an array.

If we wanted to represent a matrix that holds 5x4 cells we would only need to do the following to initialize the memory:

```java
int[][] myMatrix = new int[5][4];
```

This will initialize our memory to represent the following table:

| col idx > | row idx v | 0   | 1   | 2   | 3   |
| --------- | --------- | --- | --- | --- | --- |
| ---       | **0**     | 0   | 0   | 0   | 0   |
| ---       | **1**     | 0   | 0   | 0   | 0   |
| ---       | **2**     | 0   | 0   | 0   | 0   |
| ---       | **3**     | 0   | 0   | 0   | 0   |
| ---       | **4**     | 0   | 0   | 0   | 0   |
We can then access an element in this matrix by using the row and column indexes like so:

```java
myMatrix[1][3] = 40;
```

Which would leave our table looking like:

| col idx > | row idx v | 0   | 1   | 2   | 3   |
| --------- | --------- | --- | --- | --- | --- |
| ---       | **0**     | 0   | 0   | 0   | 0   |
| ---       | **1**     | 0   | 0   | 0   | 40  |
| ---       | **2**     | 0   | 0   | 0   | 0   |
| ---       | **3**     | 0   | 0   | 0   | 0   |
| ---       | **4**     | 0   | 0   | 0   | 0   |
We aren't limited to only two dimensions. If we needed three dimensions (say we wanted to represent an image of red, green, and blue pixels with an (x,y) position) we can use a 3 dimensional array like:

```java
double image[][][];
```

