---
writer: amoratoi
coder: garagon4
---
# Material Iron

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

 * "arnau" should have a quantity of 20 material IRON. 
 
 * Go to Next player.
 <!-- SNAPSHOT status=200 -->
 * You should be at the game screen.
 * "marta" should be the current player.
 * "marta" should have a quantity of 20 material IRON.
 
And also in the general list.

 * You should be at the game screen.
 * "marta" should be the current player.
 * "marta" should have a quantity of 20 material IRON.

### Obtaining Materials

Every player will get 20 iron each turn.

 * End the round.
 * <!-- SNAPSHOT status=200 -->
 * Game round should be 2.
 * Go to Next player.
 * <!-- SNAPSHOT status=200 -->
 * "arnau" should be the current player.
 * "arnau" should have a quantity of 40 material IRON.

 * Go to Next player.
 <!-- SNAPSHOT status=200 -->
 * You should be at the game screen.
 * "marta" should be the current player.
 * "marta" should have a quantity of 40 material IRON.
