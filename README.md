# GameOfLife
## Project Description
This project is a modified version of Conway's Game-Of-Life game written in Java.
The purpose of this project is to practice implementing the four Object-Oriented Programming principles into the code.
The four OOP principles - Abstraction, Polymorphism, Inheritance, and Encapsulation - have been implemented within the code.
## Game Setup and Rules
Since the project is not a classic Game-Of-Life game, there are some modifications in the game.
### Game Setup
We are going to have 4 different entities:
1. Plant
2. Herbivore
3. Carnivore
4. Omnivore
### Game Rules
#### Entity-specific Rules
Plant:
– It doesn’t eat anything.
– It reproduces when there are at least 2 adjacent plants and at least 3 empty cells.

Herbivore:
– It eats only Plants.
– It reproduces when there is at least 1 adjacent Herbivore, at least 2 empty cells, and at least 2 adjacent Plants.
– It must eat within 5 turns. Otherwise, it dies.

Carnivore:
– It eats Herbivore and Omnivore.
– It reproduces when there is at least 1 adjacent Carnivore, at least 3 empty cells, and at least 2 adjacent Herbivores or Omnivores.
– It must eat within 5 turns. Otherwise, it dies.

Omnivore:
– It eats Herbivore, Carnivore, and Plant.
– It reproduces when there is at least 1 adjacent Omnivore, at least 3 empty cells, and at least 1 adjacent Herbivore or Carnivore, or Plant.
– It must eat within 5 turns. Otherwise, it dies.
#### General Rules
– Entity waits until the previous entity finishes their actions (move, die, or give birth).
– Entity moves first and gives birth.
– Entity dies when it gets eaten.

## How To Tnstall And Run The Project
Prerequisites: Java 19
1. Pull the project
2. Install the modules that are required
3. Run the program

## How To Use The Project
Read through the code to understand the four OOP principles.
The explanation on the four OOP principles is posted on https://danielim.blog/2023/03/25/an-easy-guide-to-four-oop-principles/.

## Limitations
1. The actions of each cell cannot happen simultaneously. The actions need to happen in order.
e.g.
Cells
(1) (3)
(2) (4)
Action performed by the cell 1 -> action performed by the cell 2 -> ...
2. No testing implemented
