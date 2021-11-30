---
writer: drpicox
coder: drpicox
---
# Population

Until this moment cities were a little bit too sad,
but now, we add population.

The people live in the city, and make the city grow!

## People, population, and cities

### City population

Actually, people lives in city. They are not too big,
but at least they have 10 people just in the beginning.

Create and start playing one of your games: 

 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * Go to the "leonard" "city" "Capital".
 * The resource "population" count should be 10.

And the same for all players:

 * Go to the next player "penny"
 <!-- SNAPSHOT status=200 -->
 * Go to the "penny" "city" "Capital".
 * The resource "population" count should be 10.

### Population grows

With time, population grows in one each round:

 * End the round.
 <!-- SNAPSHOT status=200 -->
 * You should be at the "game" screen.
 * The game round should be 2.
 * Go to the "penny" "city" "Capital".
 * The resource "population" count should be 11.

And grows:

 * End the round.
 <!-- SNAPSHOT status=200 -->
 * You should be at the "game" screen.
 * The game round should be 3.
 * Go to the "penny" "city" "Capital".
 * The resource "population" count should be 12.

Until it reaches the population maximum:

 * The resource "population" maximum should be 20.
 * Skip 8 rounds.
 <!-- SNAPSHOT status=200 -->  
 * You should be at the screen of a "city".
 * The game round should be 11.
 * The resource "population" count should be 20.

And stops growing:

 * End the round.
 <!-- SNAPSHOT status=200 -->
 * You should be at the "game" screen.
 * The game round should be 12.
 * Go to the "penny" "city" "Capital".
 * The resource "population" count should be 20.
 * The resource "population" maximum should be 20.

For every player.

 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * The game round should be 12.
 * Go to the "leonard" "city" "Capital".
 * The resource "population" count should be 20.
 * The resource "population" maximum should be 20.





