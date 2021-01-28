# Funcionalitat 2: Material Counter

Now we know in a glance how many materials have your opponent.

## Counting materials

### Two players game

Create a basic game for two players.

 > Click _New Game_ in the main header.  
 > Type _CountingGame_ into the _new game name_.  
 > Select _Basic_ into the _game scenario_.  
 > Type _Martel_ into the _Player 1 name_.
 > Click the _Add player_ button.  
 > Type _Tyrell_ into the _Player 2 name_.
 > Click the _Create Game_ button.

 <!-- SNAPSHOT status=200 -->

### No one has materials in the beginning

 > Use the browser of _Martel_.
 <!-- SNAPSHOT status=200 -->
 > _Martel_ has a materials card counter of _0_.
 > _Tyrell_ has a materials card counter of _0_.

And this matches with their hands:

 > _Martel_ has in his hand no _material_ cards.
 > _Tyrell_ has in his hand no _material_ cards.

### Receiving materials

Once you start playing, accumulate some materials.

 <!-- CHEAT _Martel_ picks _1_ _material_ card of _wood_ at square _0_ -->
 <!-- CHEAT _Martel_ picks _2_ _material_ card of _hay_ at square _0_ -->
 <!-- CHEAT _Tyrell_ picks _1_ _material_ card of _wool_ at square _0_ -->
 <!-- Click _Refresh_ in the main header. -->
 <!-- SNAPSHOT status=200 -->
 > _Martel_ has in his hand _1_ _material_ card of _wood_.
 > _Martel_ has in his hand _2_ _material_ card of _hay_.
 > _Tyrell_ has in his hand _1_ _material_ card.

And counters shows it:

 > _Martel_ has a materials card counter of _3_.
 > _Tyrell_ has a materials card counter of _1_.


