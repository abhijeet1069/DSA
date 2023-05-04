The SOLID design principles are:

Single Responsibility Principle - Everything in class should be related to just one goal.

Open Closed Principle - A system should improve easily by adding new code instead of changing the core code.

Liskov Substitution Principle - The objects of a subclass should behave the same way as the objects of the superclass,
	such that they are replaceable.
	We can't replace Bicycle class with Vehicle class. Since, Bicycle class does not have	an engine. And replacing 		Bicycle(child) class with Vehicle(parent) class would create conflict with Car class.

Interface Segregation Principle - It is a design principle that does not recommend having methods that an interface
	would not use and require.

Dependency Inversion Principle - The abstractions should not depend on details. Instead, the details should depend 
	on abstractions.