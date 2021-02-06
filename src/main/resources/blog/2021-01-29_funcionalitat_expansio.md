# Funcionalitat Expansio: Socialism Tied Up

What happens when there is a tie? 
Who pays and who receives?
Only one pays, and only one receives, randomly.

## Ties...

### Four players game

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
 <!-- MOCK take _field_ as _grain_ -->
 > Click the _Add player_ button.  
 > Type _Lannis_ into the _Player 3 name_.
 <!-- MOCK take _field_ as _forest_ -->
 <!-- MOCK take _field_ as _forest_ -->
 > Click the _Add player_ button.  
 > Type _Starky_ into the _Player 4 name_.
 <!-- MOCK take _field_ as _forest_ -->
 <!-- MOCK take _field_ as _forest_ -->
 > Click the _Create Game_ button.
 <!-- SNAPSHOT status=200 -->

### The current setup

In this game, we have the following board:

 > Use the browser of _Martel_.
 <!-- SNAPSHOT status=200 -->
 > _Martel_ has the total received food counter of _1_.
 > _Tyrell_ has the total received food counter of _1_.
 > _Lannis_ has the total received food counter of _1_.
 > _Starky_ has the total received food counter of _1_.

 > _Martel_ has in his hand _1_ _food_ cards.  
 > _Martel_ has in his hand _3_ _event_ cards of _grain_.
 > _Martel_ has at the square _1_ a _field_ card of _grain_
 > _Martel_ has at the square _2_ a _field_ card of _grain_
 > _Tyrell_ has at the square _1_ a _field_ card of _grain_
 > _Tyrell_ has at the square _2_ a _field_ card of _grain_
 > _Lannis_ has at the square _1_ a _field_ card of _forest_.  
 > _Lannis_ has at the square _2_ a _field_ card of _forest_.  
 > _Starky_ has at the square _1_ a _field_ card of _forest_.  
 > _Starky_ has at the square _2_ a _field_ card of _forest_.  

Martel and Tyrell have 2 grain fields and 
Lannis and Starky have forest fields.

### Creating imbalance

Let's play grain cards like in the previous post:

 > _Martel_ plays an _event_ card of _grain_ into the _event_ pile.
 <!-- MOCK take _event_ as _grain_ -->
 > All players click _Ready_ and then _Refresh_ in the main header.
 <!-- SNAPSHOT status=200 --> 

Now the counters should have been updated.

 > _Martel_ has the total received food counter of _3_.
 > _Tyrell_ has the total received food counter of _3_.
 > _Lannis_ has the total received food counter of _1_.
 > _Starky_ has the total received food counter of _1_.

Note that Martel and Tyrell are tied to 3, and Lannis and Starky to 1.

### The flow of the imbalance

If we play again, either of Martel or Tyrell can pay one to either Lannis or Stary:

 > _Martel_ plays an _event_ card of _grain_ into the _event_ pile.
 <!-- MOCK take _event_ as _grain_ -->
 <!-- MOCK choose player _Martel_ -->
 <!-- MOCK choose player _Lannis_ -->
 > All players click _Ready_ and then _Refresh_ in the main header.
 <!-- SNAPSHOT status=200 --> 
 > _Martel_ has the total received food counter of _4_.
 > _Tyrell_ has the total received food counter of _5_.
 > _Lannis_ has the total received food counter of _2_.
 > _Starky_ has the total received food counter of _1_.
 > There is a message that says "Socialism rules, one food from Martel goes to Lannis".

This time, randomly, was Martel who has donated one to to Lannis.
Tyrell got lucky, and Starky unlucky.

But if we repeat, things will balance again:

 > _Martel_ plays an _event_ card of _grain_ into the _event_ pile.
 <!-- MOCK take _event_ as _grain_ -->
 > All players click _Ready_ and then _Refresh_ in the main header.
 <!-- SNAPSHOT status=200 --> 
 > _Martel_ has the total received food counter of _6_.
 > _Tyrell_ has the total received food counter of _6_.
 > _Lannis_ has the total received food counter of _2_.
 > _Starky_ has the total received food counter of _2_.
 > There is a message that says "Socialism rules, one food from Tyrell goes to Starky".

But because it was random, the first balance was Martel who paid
to Lannis, but this can change later:

 > _Martel_ plays an _event_ card of _grain_ into the _event_ pile.
 <!-- MOCK take _event_ as _grain_ -->
 <!-- MOCK choose player _Tyrell_ -->
 <!-- MOCK choose player _Starky_ -->
 > All players click _Ready_ and then _Refresh_ in the main header.
 <!-- SNAPSHOT status=200 --> 
 > _Martel_ has the total received food counter of _8_.
 > _Tyrell_ has the total received food counter of _7_.
 > _Lannis_ has the total received food counter of _2_.
 > _Starky_ has the total received food counter of _3_.
 > There is a message that says "Socialism rules, one food from Tyrell goes to Starky".

