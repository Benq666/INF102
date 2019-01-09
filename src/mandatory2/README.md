# Mandatory 2
For the course [INF102 Fall 2018](https://mitt.uib.no/courses/12780)

Deadline: Wednesday November 7, 2018 at 23:59

## Organizational notes

This assignment is an individual task, however you are encouraged to
to collaborate and discuss solutions *as long as you do not share code*
(see our policy on
[Collaboration and Cheating](https://mitt.uib.no/courses/12780/pages/collaboration-and-cheating)).
Similarily, for tasks which are not answered with code,
you may freely discuss your answers with your peers; but clearly,
blindly transcribing answers from others is not
allowed.

The assignment is graded on a scale from 0 to 100,
and accounts for 10% of your final grade.


#### Forbidden libraries

You may not use any *external* libraries or classes in
your answers that you did not write yourself.
The only exception to this is Kattio.java
and/or another method for fast input/output in Java; in
these cases, you should clearly mark and attribute
the code correctly. And you are still expected to be able
to explain every single line of what the code does.

You may use the Java standard library freely.



## [0]&nbsp;&nbsp;Organizational instructions (30 points)

Getting the organizational instructions right can be astonishingly difficult.
Therefore, we award a whopping 30 points to everyone who manage to follow all of them!

The number of points drop rapidly, though; for every mistake in following the handin
instructions, your points for this category is *cut in half*. Thus, if you make a single
mistake, you lose 15 points! If you make two mistakes, you lose 15 + 7.5 = 22.5 points!
So follow these instructions carefully.

#### Getting started

 * To start working with the mandatory assignment, clone or download this repository to
 your local machine. The project is in the maven format, so it should be easy to import
 to popular IDE's such as Eclipse and Intellij.
 
 (Intellij note: Go to Preferences/Settings -> Build, Execution and Deployment -> Build Tools -> Maven -> Importing and select "Import Maven projects automatically")
 * All code you write should reside in the package no.uib.ii.inf102.f18.mandatory2 (do *not* use any subpackages)
 * All code should have correct class names as according to the task specification
 
#### Register for the course at Kattis

You should already be done with this section from mandatory 0 and 1, but it still applies:

 * You need to register an account at Kattis *whose username is your UiB SEBRA ID*.
 For instance, if your UiB id is *abc123*, you should create a user whose username
 is also *abc123*. If you already have a Kattis user, you can change your username
 by going to settings and change it there (you can change it back after the course
 has concluded and you have received your final grade in the course).
 * At https://uib.kattis.com/courses/INF102/fall18 you should click on 
 *I am a student taking this course and I want to register for it on Kattis*, and 
 enter the keyphrase *inf102kattis*.

#### Non-code answers

 * The answer to non-code questions should be contained in a single pdf named `String.format("%s.pdf", yourid)`
 where *yourid* is your UiB SEBRA account id handle (for example, if your UiB id is *abc123*,
 you should name the file `abc123.pdf`). The file should reside in the ~~main~~ top level folder of your maven project
 (that's the same folder as this README.md).

#### Code answers

All code you write for the mandatory assignment should be added to this maven project.
If a task require you to solve a problem at Kattis, you must
submit your code to Kattis in addition to providing the code in
the project you hand in.
  *  All classes should reside in the package no.uib.ii.inf102.f18.mandatory2
  *  You will be graded on both correctness and style. See the appendix for style
  guidelines.
  *  Be careful to name the classes correctly according to task specifications,
  or else it will count as violating the organizational instructions.

#### Submission

  * After solving the programming assignments and crafting the pdf with textual solutions,
  make a .zip file containing the ~~main~~ top level directory of your maven project.
  
    * The top level directory of the zip file should be named identically to your UiB SEBRA
    account id (for example, if your UiB ID is *abc123*, then your top level folder should
    also be named *abc123*). That folder should itself be the top level folder of the maven
    project; e.g. README.md and should reside in `abc123/README.md` not `abc123/somefolder/README.md`
  
    * The name of your zip file should be `String.format("%s.zip", yourid)`
 where *yourid* is your UiB SEBRA account id handle (for example, if your UiB id is *abc123*,
 you should name the file `abc123.zip`). (If mitt.uib changes this to something similar but different, that's ok)
 
    * To accomplish the two points above, it is easiest to copy the contents of your
    main directory to a new folder named *abc123*, and then zip that folder.
    
  * Submit the .zip file at the assignment on mitt.uib before the deadline
  
  * Late assignments will be accepted for 24 hours, with a 20 point penalty.


## [1]&nbsp;&nbsp; Hash maps (20 points)
In this task, we examine hash maps. Subtasks (a), and (b) and should be answered in the pdf, whereas subtaks (c) and (d) should be answered in code.

**a)** Insert the keys `F B T Z R V U J P O` into an initially empty table of `m = 5` lists, using separate chaining. Use the hash function `h(k) = (13 * k) % m` to transform the `k`'th letter of the alphabet into a table entry (for instance `h('A') = (13 * 1) % 5 = 3`). Find a suitable way to illustrate what the ChainingHashTable looks like.

**b)** Insert the keys `F B T Z R V U J P O` into an intially empty array of size `m = 16` using linear probing. Use the hash function `h(k) = (13 * k) % m` to transform the `k`'th letter of the alphabet into a table entry (for instance `h('B') = (13 * 2) % 16 = 10`). In the pdf, show the contents of the array on a single line.

**c)** In the class [CalendarTest](src/test/java/no/uib/ii/inf102/f18/mandatory2/CalendarTest.java) there is a sanity test for the [Calendar](src/main/java/no/uib/ii/inf102/f18/mandatory2/Calendar.java) class which organize important [Event](src/main/java/no/uib/ii/inf102/f18/mandatory2/Event.java) objects. Like any meaningful calendar, it organizes events by [Date](src/main/java/no/uib/ii/inf102/f18/mandatory2/Date.java). However, the sanity test is not passing, and we don't know why. You have been tasked to fix the problem; however, you may NOT change the `Calendar` class in any way, shape or form (it was written by our boss, who is extremely fond his implementation), nor the sanity test (which is specified by our client).

**d)** Write a class `PerfectHash` which solves the Kattis problem [uib.perfecthash](https://uib.kattis.com/problems/uib.perfecthash)


## [2]&nbsp;&nbsp; Graphs (40 points)

There are [hints](hints) available for all these problems, but you should definitely try to solve them without looking first. For problems (b) and (c) there also exists more elegant solutions than what the hints describe, so you should try to find those if you can. 

**a)** Write a class `WheresMyInternet` that solves the Kattis problem [wheresmyinternet](https://uib.kattis.com/problems/wheresmyinternet)

**b)** Write a class `Grid` that solves the Kattis problem [grid](https://uib.kattis.com/problems/grid) using a breath-first search

**c)** Write a class `Bumped` that solves the Kattis problem [bumped](https://uib.kattis.com/problems/bumped) using Dijkstra's algorithm.

**d)** Write a class `BuildDeps` that solves the Kattis problem [builddeps](https://uib.kattis.com/problems/builddeps)


## [3]&nbsp;&nbsp; Big-O Quiz part II (10 points)

Time has come for part II of the big quiz on runtime analysis! Since it is part II, it is only reasonable that the runtime of each function now should be a function of *two* variables. The formal definition of big-O needs to be adapted; however, the intutition should be quite easy to understand.

##### Definition of Big-O for functions of two variables
A function `f(n, m)` is in `O(g(n, m))` if there exists constants `K` and `C` such that
`C * g(n, m) > f(n, m)` for every choice of `n` and `m` where both `n > K` and `m > K`.

For instance, if `f(n, m) = 5n^2 + 3nm + 6m + 8n + 10`, then `f` is in `O(n^2 + nm)`.


In the file [BigOpartII.java](src/main/java/no/uib/ii/inf102/f18/mandatory2/BigOpartII.java) there are 16 functions, named from `a` to `p`. In the pdf for the assignment, create a table

Function |   f  |  O
 :---: | --- | ----
 `a`  |  2n + m | O(n+m)
 `b`  |   ...  |  ...
 ... | ... | ...
 `p` | ... | ...

and fill in the blanks. The column for big-O is worth twice as much as the exact function. Note that our cost model is the number of *steps* (i.e. number of calls to the `step` function).

#### *Update (Oct 24)* 
A bug was discovered in function `l`. The worst-case runtime of the function will not change due to this fix.


##### Good luck! 
 
### Appendix: Style Guide
 
These rules applies to all source code that is handed in. These guidelines are loosely based on [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html), though with some minor differences.

##### Most important
  * Make your code easy to read.
    * Comment tricky parts of the code.
    * Use descriptive and logical variable names and function names.
    * Break the code into appropriate functions for readablity and code reuse; no function should ideally be more than 30 lines of code (with the exception of extremely monotone code, such as sanity tests).
    * Write javadoc comments for functions that are not self-explanatory
  * All files should use UTF-8 character encoding.
  
##### Also important
  * The only whitespace characters allowed are spaces and newlines (tabs are not allowed).
    * Each indention level increase by 4 spaces.
  * No line may exceed 120 characters - lines exceeding this limit must be line-wrapped.
    * Some exceptions, e.g. very long URL's that don't fit on one line.
  * File name should be the same as the name of the class, written in UpperCamelCase.
  * Function names, parameter names and variable names should be written in lowerCamelCase.
  * Constants should be written in ALL_CAPS.
  * No line breaks before open braces (`{`).
  * Blank lines should be used sparingly, but can be used to separate logic blocks and increase readability
  
