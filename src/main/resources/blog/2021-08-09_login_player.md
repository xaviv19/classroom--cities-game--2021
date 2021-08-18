# Login Player

You know how to create your player
to play. Now you need to login.

Login allows to identify yourself
and play with your games.

Welcome inside.

## Login the Game

### Create a player

But before start, you need to create a player.

 > Go to the signup.  
 > Add your name as player name.  
 > Set your password.  
 > Click the signup button.  
 <!-- SNAPSHOT status=200 -->

At this point,
 
 > You should back to the welcome page.  
 > You should see a message saying that "The leonard player has been added successfully".  

### Login inside

You have now a player, now you can login.

 > Go to the login.  
 > Enter your player name.  
 > Enter your password.  
 > Click the login button.  
 <!-- SNAPSHOT status=200 -->

 > You should be in the player page.  
 > You should see a message saying that "The leonard player has been logged successfully".  

## Multiplayer

You can have more than one player. So,

 > Given there is your player,  
 > And there is the player "penny" with password "payforyourmeal12".  

Now we have two users, and we can login with each one.

 > Go to the login  
 > Enter your player name.  
 > Enter your password.  
 > Click the login button.  
 <!-- SNAPSHOT status=200 -->

 > You should be in the player page.  
 > You should see a message saying that "The leonard player has been logged successfully".  

But you can also login, with "penny" player.

 > Go to the login  
 > Enter "penny" as player name.  
 > Enter "payforyourmeal12" as password.  
 > Click the login button.  
 <!-- SNAPSHOT status=200 -->

 > You should be in the player page.  
 > You should see a message saying that "The penny player has been logged successfully".  

## Checking data

We are all human, (are we?), and we can
fail, so we have few failsafe to avoid
errors.

But before, we need a player.

 > Given there is your player.  

### Unkown player

If the player does not exists, you cannot login.

 > Go to the login.  
 > Enter "wrongplayer" as player name.  
 > Enter your password.  
 > Click the login button.  
 <!-- SNAPSHOT status=400 -->
 > You should see an error message saying that "The login credentials are wrong".    

### Wrong password

 > Go to the login.  
 > Enter your player name.  
 > Enter "wrongpassword" as password.  
 > Click the login button.  
 <!-- SNAPSHOT status=400 -->
 > You should see an error message saying that "The login credentials are wrong".  

 > Add "jo" as player name.  
 > Click the signup button.  
 <!-- SNAPSHOT status=400 -->
 > You should see an error message saying that "Player name should be at least three characters long".    
