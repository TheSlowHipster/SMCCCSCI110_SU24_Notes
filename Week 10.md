# Reading
* Chapter 8
# File I/O
So far this semester we've been using `Scanner` variables to interact with `System.in` for getting user input and printing to `System.out`. This works somewhat, but sometimes we need to write to a file, or there is some data already stored on a computer that we need to read. This is where File I/O^[Which stands for File Input/Output.] comes in handy!

Reading a file and writing a file require different things, and Java includes objects that handle each of these operations! And we've actually been dealing with these already with `System.in` and `System.out`
## Writing to a File
If we want to print out to any other location than the "files" `System.out` or `System.err`, then we're going to need an instance of an object that allows us to print out to an arbitrary file. Before we can write to this file however we first need to access it! We can do this by creating a new reference to a `FileOutputStream` object. The constructor is relatively simple, we need to provide it with the string file location on our computer. We don't need to give the program the exact location, and you can find out more about how to format these [here](https://learn.microsoft.com/en-us/dotnet/standard/io/file-path-formats).

Once we have a reference to the `FileOutputStream` we can feed it in as an argument to a `PrintWriter`, and then from there we can call the same `print` methods we're familiar with from the builtin `System` print streams!
## Reading a File
Reading from a file is almost the same process. We need to create a reference to the file that we want to open and then we can feed that reference to a `Scanner`. Again, we can give the file location to the constructor as an argument as a string.
### Errors from Parsing a File
Sometimes our `Scanner` methods try to read something that it cant. This will cause the program to throw an error and crash if we don't handle it properly. We can handle these errors by using a `try/catch` block, where we put the call to the `Scanner` method inside a `try` block and the code that should be run if an error occurs in the `catch` block. See the code I wrote for A1 as an example of this.

## Common I/O Errors - Hardcoding a File Location
Just because we can feed a string into the `FileInputStream` constructor or the `FileOutputStream` constructor doesn't mean that we should give it a string literal. We can run Java code on any operating system and any file system too, which means that if we were to try and access a file at `"C:\Documents\input.txt"` from an apple device we wouldn't be able to find this location because MacOS does not have a `C` drive! To get around this we would instead want our code to pull file locations from the `String[]` parameter `args` from the `main` method.