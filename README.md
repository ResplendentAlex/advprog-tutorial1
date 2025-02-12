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