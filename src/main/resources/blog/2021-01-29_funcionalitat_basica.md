# Funcionalitat Basica: Socialism

Some times some players got lucky and they got more
food cards that others during time, we do not like
to win with that unbalance, so we introduce Socialism:
players with less luck receive resources from the luckiest ones.

## Living in socialism

### Three players game

Create a three players game

 > Click _New Game_ in the main header.  
 > Type _SocialistGame_ into the _new game name_.    
 > Select _Socialism_ into the _game scenario_.  
 > Type _Martel_ into the _Player 1 name_.  
 <!-- MOCK take _field_ as _grain_ -->
 <!-- MOCK take _field_ as _grain_ -->
 <!-- MOCK take _event_ as _grain_ -->
 <!-- MOCK take _event_ as _grain_ -->
 <!-- MOCK take _event_ as _grain_ -->
 > Click the _Add player_ button.  
 > Type _Tyrell_ into the _Player 2 name_.  
 <!-- MOCK take _field_ as _grain_ -->
 <!-- MOCK take _field_ as _forest_ -->
 <!-- MOCK take _event_ as _grain_ -->
 <!-- MOCK take _event_ as _grain_ -->
 <!-- MOCK take _event_ as _forest_ -->
 > Click the _Add player_ button.  
 > Type _Lannis_ into the _Player 3 name_.  
 <!-- MOCK take _field_ as _sheep_ -->
 <!-- MOCK take _field_ as _sheep_ -->
 <!-- MOCK take _event_ as _forest_ -->
 <!-- MOCK take _event_ as _forest_ -->
 <!-- MOCK take _event_ as _forest_ -->
 > Click the _Create Game_ button.
 <!-- SNAPSHOT status=200 -->

### Total Food Counter

We add a new food counter, you can see how many food cards
did anyone received since the beginning, just look
beside the player number.

 > Use the browser of _Martel_.
 <!-- SNAPSHOT status=200 -->
 > _Martel_ has the total received food counter of _1_.
 > _Tyrell_ has the total received food counter of _1_.
 > _Lannis_ has the total received food counter of _1_.

All three have one because they just received one when
the game started. Let's see what have each player:

 > Use the browser of _Martel_.
 <!-- SNAPSHOT status=200 -->
 > _Martel_ has the total received food counter of _1_.
 > _Martel_ has in his hand _1_ _food_ cards.  
 > _Martel_ has in his hand _3_ _event_ cards of _grain_.
 > _Martel_ has at the square _1_ a _field_ card of _grain_
 > _Martel_ has at the square _2_ a _field_ card of _grain_

 > Use the browser of _Tyrell_.
 <!-- SNAPSHOT status=200 -->
 > _Tyrell_ has the total received food counter of _1_.
 > _Tyrell_ has in his hand _1_ _food_ cards.  
 > _Tyrell_ has in his hand _2_ _event_ cards of _grain_.
 > _Tyrell_ has in his hand _1_ _event_ cards of _forest_.
 > _Tyrell_ has at the square _1_ a _field_ card of _grain_
 > _Tyrell_ has at the square _2_ a _field_ card of _forest_

 > Use the browser of _Lannis_.
 <!-- SNAPSHOT status=200 -->
 > _Lannis_ has the total received food counter of _1_.  
 > _Lannis_ has in his hand _1_ _food_ cards.  
 > _Lannis_ has in his hand _3_ _event_ cards of _forest_.  
 > _Lannis_ has at the square _1_ a _field_ card of _sheep_.  
 > _Lannis_ has at the square _2_ a _field_ card of _sheep_.  

Wow, Lannis got so unlucky. Only sheep fields but no one has sheep event cards
available. 

### The balance

Now all players are balanced, so all of them have received
the same number of cards since the beginning, let's break the balance.

Let's make Martel play one event card of grain.


 > Use the browser of _Martel_.
 <!-- SNAPSHOT status=200 -->
 > _Martel_ plays an _event_ card of _grain_ into the _event_ pile.
 <!-- MOCK take _event_ as _grain_ -->
 > All players click _Ready_ and then _Refresh_ in the main header.
 <!-- SNAPSHOT status=200 --> 

Now the counters should have been updated.
 
 > _Martel_ has the total received food counter of _3_.
 > _Tyrell_ has the total received food counter of _2_.
 > _Lannis_ has the total received food counter of _1_.

Now Martel is ahead, the balance is broken.

### Faking luck

With the new Socialism rule, we do not allow that badluck
affects to our players, so, at this moment, if Martel
plays again a grain event... something new will happen.

 > Use the browser of _Martel_.
 <!-- SNAPSHOT status=200 -->
 > _Martel_ plays an _event_ card of _grain_ into the _event_ pile.
 <!-- MOCK take _event_ as _grain_ -->
 > All players click _Ready_ and then _Refresh_ in the main header.
 <!-- SNAPSHOT status=200 --> 
 
Now things have been changed:

 > _Martel_ has the total received food counter of _4_.
 > _Tyrell_ has the total received food counter of _3_.
 > _Lannis_ has the total received food counter of _2_.

Martel has received only one, instead of two cards, and the
other card has been assigned to Lannis. And all players
have received a message with that information:

 > There is a message that says "Socialism rules, one food from Martel goes to Lannis".

And every player has received it:

 > Use the browser of _Lannis_.
 > There is a message that says "Socialism rules, one food from Martel goes to Lannis".
 <!-- SNAPSHOT status=200 -->

 > Use the browser of _Tyrell_.
 > There is a message that says "Socialism rules, one food from Martel goes to Lannis".
 <!-- SNAPSHOT status=200 -->
