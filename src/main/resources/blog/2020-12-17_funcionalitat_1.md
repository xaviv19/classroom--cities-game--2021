# Funcionalitat 1: Building townhall

There is a new building: the townhall. But is there a mayor?

## Play with the townhall

### New game

Just create one player game.

 > Click _New Game_ in the main header.  
 > Type _TownhallGame_ into the _new game name_.  
 > Select _Basic_ into the _game scenario_.  
 > Type _Martel_ into the _Player 1 name_.
 <!-- MOCK take _field_ as _grain_ -->
 <!-- MOCK take _event_ as _grain_ -->
 > Click the _Create Game_ button.

 <!-- SNAPSHOT status=200 -->

### Building the townhall

Let's play a little and get some materials.

 > Use the browser of _Martel_.
 <!-- SNAPSHOT status=200 -->
 <!-- CHEAT _Martel_ picks _1_ _material_ card of _wood_ at square _0_ -->
 <!-- CHEAT _Martel_ picks _1_ _material_ card of _hay_ at square _0_ -->
 <!-- Click _Refresh_ in the main header. -->
 <!-- SNAPSHOT status=200 --> 
 > _Martel_ has in his hand _1_ _material_ card of _wood_.
 > _Martel_ has in his hand _1_ _material_ card of _hay_.
 > _Martel_ has in his hand an _event_ card of _grain_.
 > _Martel_ has at the square _1_ a _field_ card of _grain_.

But we have no townhall:

 > _Martel_ has in his hand no _building_ cards.

If you have to build that building you have to play the construction
materials into the building pile.

 > _Martel_ plays 1 _hay_ and 1 _wood_ _material_ cards into the _build_ pile.
 > Click _Ready_ in the main header.
 <!-- SNAPSHOT status=200 --> 
 > _Martel_ has in his hand _1_ _building_ card of _townhall_.

And there it is in your hand.

### Playing the townhall

Just play the townhall into any square pile and it will be placed on that square.

 > _Martel_ plays _1_ _building_ card of _townhall_ into his square _1_ pile.
 > Click _Ready_ in the main header.
 <!-- SNAPSHOT status=200 --> 
 > _Martel_ has in his hand no _building_ cards.
 > _Martel_ has at the square _1_ a _building_ card of _townhall_.

### The mayor is the new worker 😮

Yes, the mayor is a real worker in this game. 
But you need to play hay and wool into the train pile.
Just skip some rounds to accumulate material.

 <!-- CHEAT _Martel_ picks _1_ _material_ card of _wool_ at square _0_ -->
 <!-- CHEAT _Martel_ picks _1_ _material_ card of _hay_ at square _0_ -->
 <!-- Click _Refresh_ in the main header. -->
 <!-- SNAPSHOT status=200 --> 
 > _Martel_ has in his hand _1_ _material_ card of _wool_.
 > _Martel_ has in his hand _1_ _material_ card of _hay_.
 > _Martel_ has in his hand no _worker_ cards.
 > _Martel_ plays 1 _hay_ and 1 _wool_ _material_ cards into the _train_ pile.
 > Click _Ready_ in the main header.
 <!-- SNAPSHOT status=200 --> 
 > _Martel_ has in his hand _1_ _worker_ card of _mayor_.

### Playing the mayor

Just place the mayor into the same square than the townhall.

 > _Martel_ plays _1_ _worker_ card of _mayor_ into his square _1_ pile.
 > Click _Ready_ in the main header.
 <!-- SNAPSHOT status=200 --> 
 > _Martel_ has in his hand no _worker_ cards.
 > _Martel_ has at the square _1_ a _worker_ card of _mayor_.

### Mayors at townhall gives gold! 😮

Yes, they do not do embezzle, they create gold, well, only one of gold per turn that they have an event...
(do they have more hidden gold?).

 > _Martel_ has in his hand an _event_ card of _grain_.
 > _Martel_ has at the square _1_ a _field_ card of _grain_.
 > _Martel_ has at the square _1_ a _worker_ card of _mayor_.
 > _Martel_ has at the square _1_ a _building_ card of _townhall_.
 > _Martel_ plays _1_ _event_ card of _grain_ into the _event_ pile.
 > _Martel_ has in his hand no _material_ cards of _gold_.
 > Click _Ready_ in the main header.
 <!-- SNAPSHOT status=200 --> 
 > _Martel_ has in his hand _1_ _material_ card of _gold_.

