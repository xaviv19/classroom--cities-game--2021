# Create Game

Every player can create games to play 
alone, or with friends. 

This post explains how to create those games.

## Your first Game

### Login

To create a game, you need to login first:

 > Given there is your player.    
 > Go to the login.  
 > Enter your player name.    
 > Enter your password.  
 > Click the login button.  
 <!-- SNAPSHOT status=200 -->

 > You should be in the player page.    
 
### Creating a game

Do you want to create a game, just:

 > Go to create game.  
 > Add "mygame" as game name.  
 > Click the create game button.  
 <!-- SNAPSHOT status=200 -->
 > You should be in the player page.  
 > You should see a message saying that "The mygame game has been created successfully".    

## Listing your games

You can see your games, if you create a game:

 > Given there is your player.  
 > And you have been logged in.  
  <!-- SNAPSHOT status=200 -->  

 > Go to create game.  
 > Add "mygame" as game name.    
 > Click the create game button.    
 <!-- SNAPSHOT status=200 -->  

And go to see the games:

 > Go to my games.  
 <!-- SNAPSHOT status=200 -->  
 > There should be 1 game.  
 > You should see the game "mygame".    

## Creating more games

You can create as many games as you want.

 > Given there is your player.  
 > And you have been logged in.  
 <!-- SNAPSHOT status=200 -->  

Create one game:

 > Go to create game.  
 > Add "mygame" as game name.  
 > Click the create game button.  
 <!-- SNAPSHOT status=200 -->  

And create a second game:

 > Go to create game, again.  
 > Add "secondgame" as game name.  
 > Click the create game button.  
 <!-- SNAPSHOT status=200 -->
 > You should be in the player page.    
 > You should see a message saying that "The secondgame game has been created successfully".  

And you can see the game in the game list:

 > Go to my games.  
 <!-- SNAPSHOT status=200 -->  
 > There should be 2 games.  
 > You should see the game "mygame".    
 > You should see the game "secondgame".  

## Checking data

### Game name is mandatory

The name of the game is mandatory.

 > Given there is your player.  
 > And you have been logged in.  
 <!-- SNAPSHOT status=200 -->  
 > Go to create game.  
 > Click the create game button.  
 <!-- SNAPSHOT status=400 -->  

But it fails:

 > You should be in the player page.      
 > You should see an error message saying that "Game name should be present".  

And game list, is empty:

 > Go to my games.  
 <!-- SNAPSHOT status=200 -->
 > There should be no games.  
 > You should see no game "mygame".  

### Game name cannot be repeated

Create a game:

 > Given there is your player.  
 > And you have been logged in.  
 <!-- SNAPSHOT status=200 -->
 > Go to create game.  
 > Add "mygame" as game name.  
 > Click the create game button.  
 <!-- SNAPSHOT status=200 -->  
 > You should be in the player page.      
 > You should see a message saying that "The mygame game has been created successfully".  

And try to create the same game again:

 > Go to create game.  
 > Add "mygame" as game name.  
 > Click the create game button.  
 <!-- SNAPSHOT status=400 -->
 > You should be in the player page.      
 > You should see an error message saying that "The mygame game already exists".  

And check for no duplicates:

 > Go to my games.  
 <!-- SNAPSHOT status=200 -->
 > There should be 1 game.  
 > You should see the game "mygame".  

### Other may choose the same name

You cannot have two games with the same name, 
but others can use the same name for their own games.

 > Given there is the player "penny".  
 > And "penny" has been logged in.  
 <!-- SNAPSHOT status=200 -->

Penny cannot see your games:

 > Go to my games.  
 <!-- SNAPSHOT status=200 -->
 > There should be no games.  
 > You should see no game "mygame".  

Penny creates the same game:

 > Go to create game.  
 > Add "mygame" as game name.  
 > Click the create game button.  
 <!-- SNAPSHOT status=200 -->  
 > You should be in the player page.      
 > You should see a message saying that "The mygame game has been created successfully".  

And she can see her game:

 > Go to my games.  
 <!-- SNAPSHOT status=200 -->
 > There should be 1 game.  
 > You should see the game "mygame".  

