# Graphical User Interfaces (JavaFX)

Consider a [positional game](https://en.wikipedia.org/wiki/Positional_game) played on board containing a number of dots placed on a circle. Some dots are connected to other dots using lines. Initially, the existing lines are gray (not colored).
Two players take turns coloring any uncolored lines. One player colors in one color (red), and the other colors in another color (blue).

Two players take turns coloring any uncolored lines. One player colors in one color (red), and the other colors in another color (blue).
 - Variant 1: Each player tries to create a triangle made solely of his color. The player who succeeds, wins the game.
 - Variant 2: Each player tries to avoid the creation of a triangle made solely of his color. The player who cannot avoid creating such a triangle, loses the game.

In order to create a graphical user interface for the game, I will be using JavaFX.

Example of a game board:

![Game board](https://gcdnb.pbrd.co/images/05ZuK2yeUnMf.png?o=1)

The main specifications of the application are:

## Compulsory 
Create the following components:
 - The main frame of the application.
 - A configuration panel for introducing parameters regarding the number of dots and lines and a button for creating a new game. The panel must be placed at the top part of the frame. The panel must contain at least one label and one input component.
 - A canvas (drawing panel) for drawing the board. Draw the dots and the lines according to the values specified in the config panel. This panel must be placed in the center part of the frame.
 - A control panel for managing the game. This panel will contain the buttons: Load, Save, Exit ,etc. and it will be placed at the bottom part of the frame.

## Homework
 - Create the object oriented model of the game. Consider implementing a retained mode for drawing the game board.
 - Implement the logic of the game. Use a mouse listener in order to select the line which must be colored, either by selecting the dots or the line itself. Validate the moves, according to the game rules. Determine the winner of the game.
 - Export the current image of the game board into a PNG file.
 - Use object serialization in order to save and restore the current status of the game.

## Bonus

 - Implement a non-trivial AI for the game.
 - Using Graph4J API, implement an efficient algorithm for counting all the triangles in a graph; see [GraphMetrics.getNumberOfTriangles](https://github.com/jgrapht/jgrapht/blob/master/jgrapht-core/src/main/java/org/jgrapht/GraphMetrics.java) in JGraphT.
