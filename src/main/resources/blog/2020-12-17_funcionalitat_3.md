# Funcionalitat 3: Deal event

It should be great to receive all gold cards from your opponents,
right?

## Dealing with the deal event

### Three players game

Create a basic game with three players:

 > Click _New Game_ in the main header.  
 > Type _MysteryGame_ into the _new game name_.  
 > Select _Basic_ into the _game scenario_.  
 > Type _Martel_ into the _Player 1 name_.
 <!-- MOCK take _event_ as _deal_ -->
 > Click the _Add player_ button.  
 > Type _Tyrell_ into the _Player 2 name_.
 > Click the _Add player_ button.  
 > Type _Lannis_ into the _Player 3 name_.
 > Click the _Create Game_ button.
 <!-- SNAPSHOT status=200 -->

### Earning materials

The deal event redistributes gold depending of the resources of
each player. It is a dangerous event that you might not want to play
unless you are sure, but... there it is, and the materials in each
player hands have a great role.

 > Use the browser of _Martel_.
 <!-- SNAPSHOT status=200 -->
 <!-- CHEAT _Martel_ picks _1_ _material_ card of _gold_ at square _0_ -->
 <!-- CHEAT _Martel_ picks _2_ _material_ card of _hay_ at square _0_ -->
 <!-- CHEAT _Martel_ picks _1_ _material_ card of _wood_ at square _0_ -->
 <!-- CHEAT _Tyrell_ picks _2_ _material_ card of _hay_ at square _0_ -->
 <!-- CHEAT _Tyrell_ picks _1_ _material_ card of _wool_ at square _0_ -->
 <!-- CHEAT _Lannis_ picks _3_ _material_ card of _gold_ at square _0_ -->
 <!-- Click _Refresh_ in the main header. -->
 <!-- SNAPSHOT status=200 -->
 > _Martel_ has in his hand _4_ _material_ cards.
 > _Martel_ has in his hand _1_ _material_ card of _gold_.
 > _Martel_ has in his hand _2_ _material_ card of _hay_.
 > _Martel_ has in his hand _1_ _material_ card of _wood_.

 > Use the browser of _Tyrell_.
 <!-- SNAPSHOT status=200 -->
 > _Tyrell_ has in his hand _3_ _material_ cards.
 > _Tyrell_ has in his hand _2_ _material_ card of _hay_.
 > _Tyrell_ has in his hand _1_ _material_ card of _wool_.

 > Use the browser of _Lannis_.
 <!-- SNAPSHOT status=200 -->
 > _Lannis_ has in his hand _3_ _material_ cards.
 > _Lannis_ has in his hand _3_ _material_ card of _gold_.

### Playing the deal event

The deal event moves all gold material cards from the player with more
materials to the one with less.

 > Use the browser of _Martel_.
 <!-- SNAPSHOT status=200 -->
 > _Martel_ has in his hand _1_ _event_ card of _deal_.
 > _Martel_ plays an _event_ card of _deal_ into the _event_ pile.
 > All players click _Ready_ and then _Refresh_ in the main header.
 <!-- SNAPSHOT status=200 --> 
 > _Martel_ has in his hand _7_ _material_ cards.
 > _Martel_ has in his hand _4_ _material_ card of _gold_.
 > _Martel_ has in his hand _2_ _material_ card of _hay_.
 > _Martel_ has in his hand _1_ _material_ card of _wood_.

 > Use the browser of _Tyrell_.
 <!-- SNAPSHOT status=200 -->
 > _Tyrell_ has in his hand _3_ _material_ cards.
 > _Tyrell_ has in his hand _2_ _material_ card of _hay_.
 > _Tyrell_ has in his hand _1_ _material_ card of _wool_.

 > Use the browser of _Lannis_.
 <!-- SNAPSHOT status=200 -->
 > _Lannis_ has in his hand no _material_ cards.
 > _Lannis_ has in his hand no _material_ cards of _gold_.
