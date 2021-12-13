---
writer: xaviv19
coder: xaviv19
---

# Patata emoji

## Potato emoji exist
 * Given that "leonard" is playing.
 * Go to the next player "leonard"
 <!-- SNAPSHOT status=200 -->
 * There should be no "potato" emoji.
 * Go to the "leonard" "ship" "Beagle"
 * The resource "potato" maximum should be 0.

 * Given that the "leonard" "city" "Capital" has resource "potato" count 5.
 * Given that the "leonard" "city" "Capital" has resource "wood" count 4.

 * Go to the contained "deck" "Builder".
 * Build the "Potato store".
 <!-- SNAPSHOT status=200 -->
 * The resource "potato" maximum should be 5.
 * End the round.
 <!-- SNAPSHOT status=200 -->
 * There should be "potato" emoji.
