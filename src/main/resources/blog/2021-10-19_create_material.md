---
writer: Belda7
coder: amoratoi
---
# Create Material

Until this moment cities were a little bit too sad,
but now, we add materials.

The materials can be found in the city, and may be used to make the city grow, feed the population or build new areas!
You can also trade materials with other players.

### UI Design

```                                                                                
     View City:                                           end     View Game
   +---------------------------------------------------+  turn   +---------------------+
   | ©               …topbar… ( End Turn )             | ------> | ©               …top|
   +---------------------------------------------------+         +---------------------+
   | < | Player leo...ard                              |         |  Player leonar...ard|
   +---------------------------------------------------+         +---------------------+
   |  City Capital                                     |         |  Round 1.           |
   |  Population:  #10                                 |         |  ....               |
   :                                                   :         :                     :
   +---------------------------------------------------+         +---------------------+                                                                                              
```                                                                 

## Growing the city

### Let's see the population

Create and start playing one of your games:

 * Given there is "leonard" playing their game "together".
 <!-- SNAPSHOT status=200 -->  
 * Game round should be 1.
 * "leonard" should have 1 city.
 * "leonard" should have the "Capital" city.


You can see here the materials:

 * "leonard" should have a quantity of 20 material "GOLD".
 * "leonard" should have a quantity of 20 material "IRON".
 * "leonard" should have a quantity of 35 material "WOOD".
 * "leonard" should have a quantity of 50 material "WHEAT".
 * "leonard" should have a quantity of 25 material "STONE".

### And others players the same

Others players can also see their materials.

 * Given there is the next player "penny".
 <!-- SNAPSHOT status=200 -->
 * "penny" should have a quantity of 20 material "GOLD".
 * "penny" should have a quantity of 20 material "IRON".
 * "penny" should have a quantity of 35 material "WOOD".
 * "penny" should have a quantity of 50 material "WHEAT".
 * "penny" should have a quantity of 25 material "STONE".
