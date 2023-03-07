<h1>Best Route Problem</h1>
This program implements an object-oriented model of the "Best Route Problem", which consists of locations and roads. The goal of the program is to determine the best route from one location to another based on the given roads.

<h2>Classes</h2>
<h3>Location</h3>
<li>name: the name of the location</li>
<li>type: the type of the location (implemented as an enum)</li>
<li>x: the x coordinate of the location</li>
<li>y: the y coordinate of the location</li>
<h3>Road</h3>
<li>type: the type of the road (implemented as an enum)</li>
<li>length: the length of the road</li>
<li>speedLimit: the speed limit of the road</li>
<h3>City</h3>
<li>name: the name of the city</li>
<li>country: the country the city is in</li>
<li>population: the population of the city</li>
<h3>Airport</h3>
<li>airportCode: the code of the airport</li>
<li>country: the country the airport is in</li>
<li>numberofTerminals: the number of terminals at the airport</li>
<h3>GasStation</h3>
<li>name: the name of the gas station</li>
<li>country: the country the gas station is in</li>
<li>price: the price per liter of diesel at the gas station</li>



ProblemInstance
This class describes an instance of the problem and has the following properties:

locations: a list of all the locations in the problem
roads: a list of all the roads in the problem
It also has methods for determining if the problem instance is valid and for checking if it is possible to go from one location to another using the given roads.

Usage
To use this program, create instances of Location, Road, and ProblemInstance and add them to the appropriate lists. Then, call the methods of the ProblemInstance class to determine if the instance is valid and to find the best route.