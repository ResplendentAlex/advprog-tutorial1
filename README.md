# E-Shop by Alexander William Lim
A project made for the advanced programming module of the 2024/2025 academic year

## Reflections
Below are listed the evaluations I have made in accordance to clean code principles and coding standards.

### Reflection 1
**Clean Code**
1. **Meaningful Names** - the usage of meaningful names is implemented when naming variables, functions, as well as pages. This aims to provide a clear purpose of each component used in the source code, preventing ambiguity to hinder anyone that wish to read the source code.
2. **Functions** - each method are separated effectively, with each of them only working towards one single purpose. This would increase the modularity of the source code, providing the opportunity to create a possibly reusable code.
3. **Comments** - comments are occasionally used to provide clarifications on certain parts of the code. This is mainly to explain the decisions made when choosing certain implementations over the other.
4. **Objects and Data Structures** - the attributes of the model Product all have the _private_ modifier. This would increase the security of the Product implementation, as well as increasing abstraction to prevent others from easily accessing the server's data.

**Secure Coding**
1. **Input data validation** - this is one of the vulnerable part of the source code. If taken a look at carefully, there is no input or data validation implemented when users create products. This means that it would be possible for users with malicious intents to enter "evil inputs" that might break or even lead to security risks.

### Reflection 2
1. After writing the unit test, I realize just how useful they are. While it may seem to look useless at first, 
I find that it became increasingly more useful when I actually ran it completely. This is because unit tests have 
allowed me to quickly detect which part of the code is problematic and causing the error or bug. 
This saves me a lot of debugging time, which I might be spending on trying to find the problematic part of the code otherwise.
However, I also realize that there are still limitations to unit testing. While we may be able to completely do testing
over the whole source code, it only tests for each function separately. This means that it will not be able to ensure that there will be
no errors or bugs when they work functionally together, even if we have a 100% coverage unit tests. Of course, with a 100%
coverage we can at least ensure that we minimize the risk of a single part of the code failing by its own, and to achieve this 100%, it is best
that we have at least two positive and one negative scenario of each unit test. We can also make sure that our unit tests are 
enough to verify our program is simply by making sure that all possible scenario is covered by our unit tests. This would
be good enough to minimize the chances of problems occurring in most scenario.


2. If we have a different functional test but with the same setup procedures and instantiation variables, I think that it would be
much more effective if we opt to add the functional test into the same CreateProductFunctionalTest.java file. This prevents the possible
arise of confusion due to duplicates which actually violate clean code principles. For this reason, I think it would be better if we
include that functional test into the same test suite, with comments for clarification on the decision of why we included it in the same
test suite. This way, we could prevent duplicates, as well as provide a clearer explanation for other programmers that might need to use
the test suite.


### Reflection 3
1. There's only one fix that is made to the codebase for code quality. The issue previously was due to the inconsistent
naming convention on the HomeController Java class. The HomeController class contains a method that is named with first letters
in upper case, while other methods are using camel case. This inconsistency in the code needs to be fixed to improve readibility.


2. I believe the current implementation has already met the definition of CI/CD. There is continuous integration
in which is achieved through the code analysis  for every push and pull requests that is made to the main branch as well
as other branches. There is also continuous delivery which builds in the Koyeb host every time a new push is made into the main branch.