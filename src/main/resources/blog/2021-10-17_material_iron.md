---
writer: amoratoi
coder: garagon4
---
# Materials

Finally you have some way to create buildings and objects. Materials have come to stay!
Build everything you want and upgrade your city to destroy others!

In this case we will talk about IRON!
                       

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

 * "arnau" should have 20 iron. 
 * "marta" should have 20 iron.

And marta can see yours:

 * Go to Next player.
 <!-- SNAPSHOT status=200 -->
 * You should be at the game screen.
 * "marta" should be the current player.
 * "arnau" should have 20 iron.
 * "marta" should have 20 iron.
 
And also in the general list.

 * You should be at the game screen.
 * "marta" should be the current player.
 * "arnau" should have 20 iron.
 * "marta" should have 20 iron.

### Obtaining Materials

Every player will get 20 iron each turn.

 * Go to Next player.
 <!-- SNAPSHOT status=200 -->
 * You should be at the game screen.
 * "arnau" should be the current player.
 * "arnau" should have 40 iron.
 * "marta" should have 20 iron.

 * Go to Next player.
 <!-- SNAPSHOT status=200 -->
 * You should be at the game screen.
 * "marta" should be the current player.
 * "arnau" should have 40 iron.
 * "marta" should have 40 iron.
