---
writer: nobody
coder: drpicox 
---
# City Information

Information about your city is now available!

From now on we will add a new tab were the player can see all the information related to their city. This tab should show the location, the population, the resources availables, the buildings and the troops.

### UI Design

``` 
  View My Cities:                                                                    View My City:

┌────────────────────────────────────────────────────────┐                          ┌───────────────────────────────────────────────────────┐
│                                                        │                          │                                                       │
│                     ...topbar...                       │                          │                      ...topbar...                     │
│                                                        │                          │                                                       │
├────────────────────────────────────────────────────────┤                          ├───────────────────────────────────────────────────────┤
│                                                        │                          │                                                       │
│                   Player leo..ard                      │                          │                    Player leo..ard                    │
│                                                        │                          │                                                       │
├────────────────────────────────────────────────────────┤                          ├───────────────────────────────────────────────────────┤
│                                                        │                          │                                                       │
│                      ...game...                        │                          │                                                       │
│                                                        │                          │   Capital city of leonard:                            │
├────────────────────────────────────────────────────────┤                          │                                                       │
│                                                        │                          │                                                       │
│                                                        │                          │       Location: ...                                   │
│     Cities:                                            │                          │                                                       │
│                                                        ├─────────────────────────►│                                                       │
│       (Capital city of leonard)                        │                          │       Population: ...                                 │
│                                                        │                          │                                                       │
└────────────────────────────────────────────────────────┘                          │                                                       │
                                                                                    │       Resources:                                      │
                                                                                    │                                                       │
                                                                                    │             Wood: ...                                 │
                                                                                    │                                                       │
                                                                                    │             Stone: ...                                │
                                                                                    │                                                       │
                                                                                    │             Iron: ...                                 │
                                                                                    │                                                       │
                                                                                    │                                                       │
                                                                                    │       (Trade Resources)                               │
                                                                                    │                                                       │
                                                                                    │                                                       │
                                                                                    │       (Buildings)                                     │
                                                                                    │                                                       │
                                                                                    │                                                       │
                                                                                    │       (Troops)                                        │
                                                                                    │                                                       │
                                                                                    │                                                       │
                                                                                    │       Dockeds:                                        │
                                                                                    │                                                       │
                                                                                    │             Ship: ...                                 │
                                                                                    │                                                       │
                                                                                    │       New Name: [ .... ]                              │
                                                                                    │                                                       │
                                                                                    │          (Change Name)                                │
                                                                                    │                                                       │
                                                                                    │                                                       │
                                                                                    │                                      (Go Back)        │
                                                                                    │                                                       │
                                                                                    │                                                       │
                                                                                    └───────────────────────────────────────────────────────┘                                            
```                                                                 

## Getting city information

Let's see how to see the cities information.

### Entering the information screen

Start a game with leonard, and take a look to the information screen.

 * Given there is "leonard" playing their game "together".
 <!-- SNAPSHOT status=200 -->  
 * Click on the "leonard" city "Capital".
 * You should be at the screen of a city.
 * The location should be 0.
 * The population should be 10.
 * The wood should be 500.
 * The stone should be 500.
 * The iron should be 500.
 * The trade resources option should be active.
 * The buildings option should be active.
 * The troops option should be active.
 * Go back to the previous screen.
 * You should be at the game screen.

And so the ship:

 * Click on the "leonard" owned ship "Beagle".
 * You should be at the screen of a ship.
 * The name should be "Beagle".
 * The change name option should be active.
 * Go back to the previous screen.
 * You should be at the game screen.

