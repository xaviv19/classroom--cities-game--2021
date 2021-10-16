---
writer: drpicox
coder: drpicox
---
# Build Houses

The cities are a litlle bit empty, right?
You should like to see beautiful homes in it.

Since today you can add houses to your cities.


### UI Design

``` 
    City View                         City View                          City View
 ┌───────────────────────────┐     ┌───────────────────────────┐      ┌───────────────────────────┐
 │ ©               …topbar…  │     │ ©               …topbar…  │      │ ©               …topbar…  │
 ├───────────────────────────┤     ├───────────────────────────┤      ├───────────────────────────┤
 │ < | Player leo...ard      │     │ < | Player leo...ard      │      │ < | Player leo...ard      │
 ├───────────────────────────┤     ├───────────────────────────┤      ├───────────────────────────┤
 │  City Capital of leonard  │     │  City Capital of leonard  │      │  City Capital of leonard  │
 │  Population:  #10         │     │  Population:  #10         │      │  Population:  #10         │
 │                           │     │                           │      │                           │
 │         ...               │     │         ...               │      │         ...               │
 │                           │     │                           │      │                           │
 │                           │     │                           │      │                           │
 │  Buildings:               │     │  Buildings:               │      │  Buildings:               │
 │                           │     │                           │      │                           │
 │  [ Build House ]          │     │  Building House, [cancel] │      │  [ Build House ]          │
 │  Houses: 0                │     │  Houses: 0                │      │  Houses: 1                │
 │                           │     │                           │      │                           │
 └───────────────────────────┘     └───────────────────────────┘      └───────────────────────────┘                                                  
```                                                                 

## Building the House

You can add new Houses to you city. 

### Ordering a house

In any game, you can build a house in your city. Order it, and it will be built
at the end on the next turn.

 * Given there is "leonard" playing their game "together".
 <!-- SNAPSHOT status=200 -->  
 * Click on the "leonard" city "Capital".
 * There should be 0 houses.
 * The build house should be inactive.
 * Order build a new house.
 <!-- SNAPSHOT status=200 -->  

After give the order, you can see that it is ready to happen, but you
need to wait for the next round.

 * The build house should be active.
 * There should be 0 houses.

End round and look.

 * End the round.
 <!-- SNAPSHOT status=200 -->
 * Click on the "leonard" city "Capital".
 * There should be 1 houses.

And now you have your house.
