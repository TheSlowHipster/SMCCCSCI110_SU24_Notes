#intro #comments #errors #gettingStarted #variables 
# GO OVER THE SYLLABUS
Key points:
* Office Hours
* Late policy for handout labs and assignments
# Assignment 1 -- Outfit Picker
READ THE RUBRIC
# Tools
Walk through VS Code
Show off Obsidian
# Readings
Chapter 1 -- Intro
# Programming Basics
Today, computers are *everywhere* from phones and laptops to giant server farms that allow us to watch movies on demand from wherever we are. There is one thing that each of these different types of computer have in common: they're all running programs written by people.

Generally a computer program consists of a series of instructions, executing one at a time. We can break these instructions up into three different groups
* *Input* - The program gets data from a file and stores the data
* *Process* - The program performs computations on data it has stored. 
* *Output* - The program puts that data somewhere. This could be a file, or sending information to another device to draw a picture on a screen.

Notice, in order to do any of this, we need to store data! Data is stored in things like buckets called *variables*. In theory we should be able to put whatever we want into a bucket, but not all programming languages let us do this. The language that we're using this semester is one such language. Because of this, we need to include additional information about the *type* of data. We'll be getting more into this next week.
## A Tour of a Program
Whenever we want to run a program we need somewhere to start. In Java this is the `main()` method, it executes the code instructions between the curly braces (`{}`) one at a time one after the other.

Each of these statements ends with a semicolon `;` the same way that english sentences end in a period. This helps the computer understand when one instruction ends and another begins.
## Comments and Whitespace
Sometimes we need to add context to our code that isn't an instruction. This is where comments come in! A comment is text that we as programmers include as explanations, reminders, and other helpful notes that doesn't get run as code. Generally, there are two types of comments, single line and multi line comments. A single line comment starts with two slashes (`//`) and all of the following text on the line is treated as a comment. Multiline comments start with a slash and a star (`/*`) and ends with the two characters reversed (`*/`) where all the text between each of these sets of characters is treated as the comment^[Multi line comments are also known as block comments].

Anything that isn't an instruction or a comment is known as whitespace, and gets similarly ignored by the compiler when we're turning the code we wrote into machine instructions.
## Errors and Warnings
We can sort errors into two types that we can get from code. Either there is a problem with the grammar of our code and we have a *syntax error* or if the program compiled we have a *logic error*.
### Syntax Errors
If we have a syntax error, then we're slightly in luck! The compiler will do its best to tell us where it thinks the error is. However, because it only knows were it wasn't expecting something the message doesn't always tell us exactly what went wrong. We are in luck though! The message that we get tells us at the very least that the error was in code that tried to compile both near and before where the compiler failed and gave the message. 
### Logic Errors
However, if our program compiles just fine but still isn't working correctly, we have a logic error. These are more difficult to diagnose because we usually don't get a message telling us where the error occurred. These errors are also known as *bugs*^[This partially due to a common story that the first logic error was actually a moth stuck in the computer.] and usually occur when the program is already running. Sometimes they can be as simple as mixing an operator with another operator, and sometimes they can have deeper roots.

To avoid these worse errors it is important to compile and test your programs very frequently. It is much easier to search through ten lines for a logic error than it is hundreds.
### Warnings
Sometimes, when you compile your code there will be messages printed that aren't errors. By default most compilers don't print out every possible warning, and instead this is an optional flag you can give when compiling your code, `-Xlint`.