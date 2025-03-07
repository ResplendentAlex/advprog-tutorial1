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


### Reflection 4
1. Explain what principles you apply to your project!
    - Single Responsibility Principle (SRP) - Previously, the car controller code is included into ProductController java class. This violates the SRP
   principle. This is because the SRP states that each package should only have one responsibility, while with the current
   code, ProductController has two. To fix this, I removed the car controller code from the ProductController file, and 
   made a new file called CarController that contains the car controller code.
   - Open/Closed Principle (OCP) - The repository files are made into interfaces that the ProductRepository and CarRepository
   can then implement. This would allow the ability to do addition into the code without changing the previous contents.
   - Interface Segregation Principle - The interfaces that are used for the repositories file are separated further into
   the Read type and the Write type with each type of file having their own responsibilities in the program.
   - Dependency Inversion Principle (DP) - The services and controller files for each of the Model are now using a 
   Repository interface file instead of using the Product and Car repositories directly. By doing this, we will be able
   to change the repository implementation without affecting any other part of the code.
   
2. Explain the advantages of applying SOLID principles to your project with examples.
   - SRP - each controller now have their respective responsibilities, namely for each of their own models. This 
   would help in separating the logical functionality needed for each controller of the Model. This also prevents a 
   single file to be extremely long and packed, providing programmers with a much more maintainable code.
   - OCP - adding new features into the program can now be easily implemented without having to be mindful of whether 
   other part of the code should also be modified. This would create a codebase environment that could easily be extended.
   - ISP - Since the interfaces are now separated, we can now implement only certain methods without having to deal with
   methods that are not needed in each of the interface. This would create a codebase that is easily maintainable.
   - DP - Changing one part of the code from the separated repository will not affect the other repositories. This also
   means that we would not need to change any part of the other repositories that does not need the method that are added
   into another repository. By doing this, the codebase would be much more maintainable and be open for extension.

3. Explain the disadvantages of not applying SOLID principles to your project with examples.
   - SRP - Since the controller are in one same file, it would be hard to make large modifications into the codebase. This
   is mainly because code that are all made in a single file would be harder to maintain, and if any bug happen to 
   appear when making modifications, it would take quite a while to debug the wrong code.
   - OCP - If the repositories are not in separate files, then everytime we need to add new repositories, we would need
   to modify the whole file. This would certainly be much less efficient when we wish to make larger modifications.
   - ISP - Creating interfaces that are in one same file, and then implementing it directly on each of the model's 
   repository files, would cause the code to be less maintainable. This is because any new implementation into the interface,
   other interfaces are forced to have implemented methods that are not needed.
   - DP - Tightly coupling with the repository if we opt to use the repository files directly without separating it. This
   would be harder to maintain as tiny modifications might force us to make modifications to the other repositories as well.


### Reflection 5
1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” 
submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, 
explain things that you need to do next time you make more tests.
   
I believe that the TDD flow is useful enough for me to start with the basics of implementing TDD in my development cycle.
This is because, with a solid and clear guideline on what I should be focusing on about, I would be able to find what
really matters in the current scope of my iteration, allowing me to see the bigger picture that includes the user. Not
only that, I think that with this flow, I can find a qualitative measurement of how much further I need to test my software
to provide me with the highest assurance that everything will work as intended by the original design. However, I think
it's also good that I find what suits my coding style best as I continue with TDD implementation. For instance, I might
find other development cycle and try to mix and match it with the current TDD flow so that I might get a better style that 
suits me. This would help me create a stronger foundation that would help me in my programming journey in software development.

2. You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle 
or not. If not, explain things that you need to do the next time you create more tests.

I think that the current unit tests implemented in the Tutorial have follow the F.I.R.S.T principles. It has followed:
- Fast - it does not take too much time to run the tests, hence allowing me to continue to the next step of my workflow
quickly. 
- Isolated - the tests are independent of each other - no return values of one test is needed for another. 
- Repeatable - no matter how many times the tests are run, results would consistently show success.
- Self-validating - all inputs and results are made sure to be correct and accurate by using assertions on each of them.
- Timely - the tests are designed before the implementation of each class is started.

It is an undeniable fact, however, that I still require more practice in TDD as I still find it counterintuitive to make 
tests on something that has yet to be implemented. It feels like creating an experiment for a hypothesis that has not been
formulated, thus my mindset.