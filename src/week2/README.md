# Best Route Problem

An instance of the "Best Route Problem" consists of locations and roads. Locations may be cities, airports, gas stations, etc.
Two locations may be connected by a road, or not. Roads may be highways, express, country, etc.

- Each location has a name, type and x, y coordinates (assume that the locations are placed in a cartesian coordinate system).
- Each road has a type, length and a speed limit. The length of a road should not be less than the euclidian distance between the location coordinates.

We consider the problem of determining the "best" route from one location to another.

The main specifications of the application are:

## Compulsory
 - Create an object-oriented model of the problem. You should have (at least) the following classes: Location, Road.
The location and road types will be implemented as enums.
 - Each class should have appropriate constructors, getters and setters.
 - Use the IDE features for code generation, such as generating getters and setters.
 - The toString method form the Object class must be properly overridden for all the classes.
Use the IDE features for code generation, for example (in NetBeans) press Alt+Ins or invoke the context menu, select "Insert Code" and then "toString()" (or simply start typing "toString" and then press Ctrl+Space).
 - Create and print on the screen various objects of the two classes.

## Homework
 - Create a class that describes an instance of the problem.
 - Override the Object.equals method for the Location and Road classes. The problem should not allow adding the same location or road twice.
 - Instead of using an enum, create dedicated classes either for locations: cities, air ports, gas stations etc. or roads: highway, express, country, etc. Each concrete location class may have additional specific propertes (population, number of terminals, gas price, etc.)
 - Implement a method that determines if a problem's instance is valid.
 - Implement an algorithm for determining if it is possible to go from one location to another using the given roads.
 - Write doc comments in your source code and generate the class documentation using javadoc.

## Bonus
 - Create a class to describe the solution.
 - Implement an algorithm to find the best route from a location to another, either as the shortest route, or the fastest route.
 - Generate large random instances of the problem and analyze the performance of your algorithm (running times, memory consumption).

### References
 - [Lab website](https://profs.info.uaic.ro/~acf/java/labs/lab_02.html)