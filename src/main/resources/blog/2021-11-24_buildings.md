---
writer: drpicox
coder: drpicox
---
# Buildings

We add buildings to our cities. 
These buildings will allow lots of new functionalities,
like new type of resources, to many other things.

## Buildings, buildings, buildings

### Building builder

All the cities starts with a new special building,
the building builder. This building allow us to add
many more buildings.

 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * Go to the "leonard" "city" "Capital".
 * You should be at the screen of a "city".
 * There should contain at least 1 "building".
 * There should contain the "building" "Builder".

### Gold mine

Just before begging, look that we have no gold, 
no production of gold, and a maximum of 5 gold.

 * The resource "gold" count should be 0.
 * The resource "gold" round increment should be 0.
 * The resource "gold" maximum should be 5.

And from the city, through the Builder building,
you can create new buildings. 

 * Go to the contained "building" "Builder".
 * You should be at the screen of a "building".

Let's create the Gold mine that increases the
round increment of gold in 1, in this case, from 0 to 1,
and we should be able to see how it increases.

 * Build the "Gold mine".
 <!-- SNAPSHOT status=200 -->
 * You should be at the screen of a "city".
 * There should contain at least 2 "building".
 * There should contain the "building" "Builder".
 * There should contain the "building" "Gold mine".
 * The resource "gold" round increment should be 1.
 
And that means, that in each turn, the amount of gold
in the city will increase in 1.

 * The resource "gold" count should be 0.
 * End the round.
 <!-- SNAPSHOT status=200 -->
 * Go to the "leonard" "city" "Capital".
 * The resource "gold" count should be 1.

### Gold vault

But there is a maximum of 5 of gold.

 * The resource "gold" count should be 1.
 * The resource "gold" round increment should be 1.
 * The resource "gold" maximum should be 5.
 * Skip 5 rounds.
 <!-- SNAPSHOT status=200 -->
 * The resource "gold" count should be 5.
 * The resource "gold" round increment should be 1.
 * The resource "gold" maximum should be 5.
 
And it will increase no more. But we can build the
Gold vault, that increase the maximum in 5.

 * Go to the contained "building" "Builder".
 * Build the "Gold vault".
 <!-- SNAPSHOT status=200 -->
 * You should be at the screen of a "city".
 * There should contain at least 3 "building".
 * There should contain the "building" "Builder".
 * There should contain the "building" "Gold mine".
 * There should contain the "building" "Gold vault".
 * The resource "gold" maximum should be 10.

And now we can surpass the limit.

 * The resource "gold" count should be 5.
 * The resource "gold" round increment should be 1.
 * The resource "gold" maximum should be 10.
 * Skip 1 rounds.
 <!-- SNAPSHOT status=200 -->
 * The resource "gold" count should be 6.
 * The resource "gold" round increment should be 1.
 * The resource "gold" maximum should be 10.

### Playing and cards

In the following parts of this post, we will
assume that we are in a more advance state of
the game, and we will have a varying amount
of resources, the amount necessary for the
next functionality.

For example, in the current game we have 6 of gold:

 * The resource "gold" count should be 6.

But we want to change it, so we describe it as follows:

 * Given that the "leonard" "city" "Capital" has resource "gold" count 5.

At this point the amount of gold is 5, but it is not yet
visible in the frontend, but just refreshing the game we can see it:

 * Refresh the game.
 <!-- SNAPSHOT status=200 -->
 * The resource "gold" count should be 5.

Refreshing the game is not always necessary. When the 
resource amount is changed, the game already knows it, and all
calculations work. So, no refresh is usually needed.


## Upgrade the Gold mine

The gold mine produces 1 gold, it is good, but not good enough.
We can upgrade it to level 2 and increase the production
from 1 to 2. But the upgrade takes 5 of gold.

First we make sure that we have everything that we need:

 * Given that "leonard" is playing.
 * Given that the "leonard" "city" "Capital" has built a "Gold mine"
 * Given that the "leonard" "city" "Capital" has resource "gold" count 5.
 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * Go to the "leonard" "city" "Capital".

Then we make the upgrade:

 * The resource "gold" round increment should be 1.
 * Go to the contained "building" "Gold mine".
 * The _level_ number should be 1.
 * The resource modifier for "gold" round increment should be 1.
 * Upgrade the level.
 <!-- SNAPSHOT status=200 -->
 * The _level_ number should be 2.
 * The resource modifier for "gold" round increment should be 2.
 * Go back to the previous screen.
 * The resource "gold" count should be 0.
 * The resource "gold" round increment should be 2.

## Upgrade the Gold vault

You can also upgrade the Gold vault, so you can keep more than 10 of
gold in your city up to 15. But it costs 5 of gold. 

First we make sure that we have everything that we need:

 * Given that "leonard" is playing.
 * Given that the "leonard" "city" "Capital" has built a "Gold vault"
 * Given that the "leonard" "city" "Capital" has resource "gold" count 5.
 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * Go to the "leonard" "city" "Capital".

Then we make the upgrade:

 * The resource "gold" maximum should be 10.
 * Go to the contained "building" "Gold vault".
 * The _level_ number should be 1.
 * The resource modifier for "gold" maximum should be 5.
 * Upgrade the level.
 <!-- SNAPSHOT status=200 -->
 * The _level_ number should be 2.
 * The resource modifier for "gold" maximum should be 10.
 * Go back to the previous screen.
 * The resource "gold" count should be 0.
 * The resource "gold" maximum should be 15.

## Wood mill

You can build a Wood mill for 5 of gold and will produce 1 of wood in each round.

First we make sure that we have everything that we need:

 * Given that "leonard" is playing.
 * Given that the "leonard" "city" "Capital" has resource "gold" count 5.
 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * Go to the "leonard" "city" "Capital".

Then we make the upgrade:

 * The resource "wood" round increment should be 0.
 * Go to the contained "building" "Builder".
 * You should be at the screen of a "building".
 * Build the "Wood mill".
 <!-- SNAPSHOT status=200 -->
 * There should contain the "building" "Wood mill".
 * The resource "gold" count should be 0.
 * The resource "wood" round increment should be 1.
 * The resource "wood" count should be 0.

And we can see how it produces:

 * Skip 1 rounds.
 <!-- SNAPSHOT status=200 -->
 * The resource "wood" count should be 1.

## Wood depot

You can increase the store for wood in 5 creating the wood depot. But it also
cost 5 of gold.

First we make sure that we have everything that we need:

 * Given that "leonard" is playing.
 * Given that the "leonard" "city" "Capital" has built a "Wood mill"
 * Given that the "leonard" "city" "Capital" has resource "gold" count 5.
 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * Go to the "leonard" "city" "Capital".

Then we make the upgrade:

 * The resource "wood" maximum should be 5.
 * Go to the contained "building" "Builder".
 * Build the "Wood depot".
 <!-- SNAPSHOT status=200 -->
 * There should contain the "building" "Wood depot".
 * The resource "gold" count should be 0.
 * The resource "wood" maximum should be 10.

And because we also have the Wood mill,
now we can see that the amount of wood increases
until the new maximum.

 * The resource "wood" round increment should be 1.
 * The resource "wood" count should be 0.
 * Skip 11 rounds.
 <!-- SNAPSHOT status=200 -->
 * The resource "wood" count should be 10.

### Mall

Malls are machines of creating money, but also creating relationships.
The population of your city go to the Mall to get known one each
other and it helps to increase the population.
You can increase the round increment of people per round creating a Mall,
but it costs 5 of gold and 2 of wood.

 * Given that the "leonard" "city" "Capital" has resource "gold" count 5.
 * Given that the "leonard" "city" "Capital" has resource "wood" count 5.
 * Refresh the game.
 <!-- SNAPSHOT status=200 -->
 * The resource "gold" count should be 5.
 * The resource "wood" count should be 5.
 * The resource "population" round increment should be 1.
 * Go to the contained "building" "Builder".
 * Build the "Mall".
 <!-- SNAPSHOT status=200 -->
 * There should contain the "building" "Mall".
 * The resource "gold" count should be 0.
 * The resource "wood" count should be 3.
 * The resource "population" round increment should be 2.

And we can see how it increments in two.

 * Given that the "leonard" "city" "Capital" has resource "population" count 10.
 * Skip 1 rounds.
 <!-- SNAPSHOT status=200 -->
 * The resource "population" count should be 12.

### House

A city can have up to 20 people, but this is not too much,
we can increase the limit in 5 building houses. But houses have a cost,
it is 2 gold and 5 wood.

 * Given that the "leonard" "city" "Capital" has resource "gold" count 5.
 * Given that the "leonard" "city" "Capital" has resource "wood" count 5.
 * The resource "population" maximum should be 20.
 * Go to the contained "building" "Builder".
 * Build the "House".
 <!-- SNAPSHOT status=200 -->
 * There should contain the "building" "House".
 * The resource "gold" count should be 3.
 * The resource "wood" count should be 0.
 * The resource "population" maximum should be 25.

And after some rounds, we can see that we will reach the maximum.

 * The resource "population" count should be 12.
 * Skip 10 rounds.
 <!-- SNAPSHOT status=200 -->
 * The resource "population" count should be 25.


### Steel mill

You can build a Steel mill for 5 of wood and will produce 1 of steel in each round.

 * You should be at the screen of a "city".
 * Given that the "leonard" "city" "Capital" has resource "wood" count 5.
 * The resource "steel" count should be 0.
 * The resource "steel" round increment should be 0.
 * The resource "steel" maximum should be 5.
 * Go to the contained "building" "Builder".
 * You should be at the screen of a "building".
 * Build the "Steel mill".
 <!-- SNAPSHOT status=200 -->
 * You should be at the screen of a "city".
 * There should contain the "building" "Steel mill".
 * The resource "steel" round increment should be 1.
 * The resource "wood" count should be 0.

And the steel should increase in each round:

 * The resource "steel" count should be 0.
 * Skip 1 rounds.
 <!-- SNAPSHOT status=200 -->
 * The resource "steel" count should be 1.

### Banana plantation

Why have plain and simple food when we can have delicious
bananas just before their extinction? Now you can make a banana
plantation. It takes 3 wood and 1 steel, and gives one banana in each round.

 * You should be at the screen of a "city".
 * Given that the "leonard" "city" "Capital" has resource "wood" count 3.
 * Given that the "leonard" "city" "Capital" has resource "steel" count 1.
 * The resource "banana" count should be 0.
 * The resource "banana" round increment should be 0.
 * The resource "banana" maximum should be 5.
 * Go to the contained "building" "Builder".
 * You should be at the screen of a "building".
 * Build the "Banana plantation".
 <!-- SNAPSHOT status=200 -->
 * You should be at the screen of a "city".
 * There should contain the "building" "Banana plantation".
 * The resource "banana" round increment should be 1.
 * The resource "wood" count should be 0.
 * The resource "steel" count should be 0.

And the steel should increase in each round:

 * The resource "banana" count should be 0.
 * Skip 1 rounds.
 <!-- SNAPSHOT status=200 -->
 * The resource "banana" count should be 1.
