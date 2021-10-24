---
writer: Belda7
coder: jazogue
---
# Material Stone

Finally you have some way to create buildings and objects. Materials have come to stay!
Build everything you want and upgrade your city to destroy others!

In this case we will talk about STONE!

### UI Dessign


View Player:                       View Player:
┌───────────────────┐              ┌─────────────────┐
│Game created       │              │Game created     │
├───────────────────┤              ├─────────────────┤
│Player marta       │              │Player arnau     │
│Inventory:         ├─────────────►│Inventory:       ├────────┐
│Stone: 50          │              │Stone: 50        │        │
│                   │              │                 │        │
│                   │              │                 │        │
│                   │              │                 │        │
└───────────────────┘              └─────────────────┘        │
                                                              │
                                                              │
View Player:                       View Player:               │
┌───────────────────┐              ┌─────────────────┐        │
│Next turn          │              │Next turn        │        │
├───────────────────┤              ├─────────────────┤        │
│Player arnau       │              │Player marta     │        │
│Inventory:         │◄─────────────┤Inventory:       │        │
│Stone: 75          │              │Stone: 75        │◄───────┘
│                   │              │                 │
│                   │              │                 │
└───────────────────┘              └─────────────────┘



## Playing game

### We need to create a game and join

Create and start playing one of your games:

 * Given there is "arnau" playing their game "together".
 <!-- SNAPSHOT status=200 -->  
 * You should be at the game screen.
 * "arnau" should be the current player.
 * Playing game should be "together" created by "arnau".

Just make sure, that the next player is marta.

 * Given there is the next player "marta".
 <!-- SNAPSHOT status=200 -->
 * You should be at the game screen.
 * "marta" should be the current player.
 * Playing game should be "together" created by "arnau".

And back.

 * Go to Next player.
 <!-- SNAPSHOT status=200 -->
 * You should be at the game screen.
 * "arnau" should be the current player.
 * Playing game should be "together" created by "arnau".

### See your materials

You can see your materials in the game screen.

 * "arnau" should have a quantity of 50 material "STONE".

 * Go to Next player.
 <!-- SNAPSHOT status=200 -->
 * You should be at the game screen.
 * "marta" should be the current player.
 * "marta" should have a quantity of 50 material "STONE".

And also in the general list.

 * You should be at the game screen.
 * "marta" should be the current player.
 * "marta" should have a quantity of 50 material "STONE".

### Obtaining Materials

Every player will get 25 wood each turn.

 * End the round.
 <!-- SNAPSHOT status=200 -->
 * You should be at the game screen.
 * Game round should be 2.
 * Go to Next player.
 <!-- SNAPSHOT status=200 -->
 * "arnau" should be the current player.
 * "arnau" should have a quantity of 75 material "STONE".

 * Go to Next player.
 <!-- SNAPSHOT status=200 -->
 * You should be at the game screen.
 * "marta" should be the current player.
 * "marta" should have a quantity of 75 material "STONE".
