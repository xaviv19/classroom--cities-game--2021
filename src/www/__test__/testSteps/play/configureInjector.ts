import { Injector } from "www/injector";
import { PostLineStep } from "www/__test__/testPost";
import { HasACardOfHighlightedAtHisHand } from "./HasACardOfHighlightedAtHisHand";
import { HasNoCardOfHighlightedAtHisHand } from "./HasNoCardOfHighlightedAtHisHand";
import { PicksACardOfAtHisHand } from "./PicksACardOfAtHisHand";
import { PicksFromHandACard } from "./PicksFromHandACard";
import { PlacesTheCardIntoThePile } from "./PlacesTheCardIntoThePile";
import { PlaysACardIntoHisSquarePile } from "./PlaysACardIntoHisSquarePile";
import { PlaysACardIntoTheSquarePile } from "./PlaysACardIntoTheSquarePile";
import { PlaysACardOfIntoThePile } from "./PlaysACardOfIntoThePile";
import { PlaysNCardsIntoHisSquarePile } from "./PlaysNCardsIntoHisSquarePile";
import { PlaysNCardsIntoThePile } from "./PlaysNCardsIntoThePile";
import { PlaysNCardsIntoTheSquarePile } from "./PlaysNCardsIntoTheSquarePile";
import { PlaysNCardsOfIntoThePile } from "./PlaysNCardsOfIntoThePile";
import { PlaysNCardsOfIntoTheSquarePile } from "./PlaysNCardsOfIntoTheSquarePile";
import { ThereAreNoHighlightedCards } from "./ThereAreNoHighlightedCards";

export default function configureTestStepsPlayInjector(injector: Injector) {
  injector.register(PostLineStep, HasACardOfHighlightedAtHisHand);
  injector.register(PostLineStep, HasNoCardOfHighlightedAtHisHand);
  injector.register(PostLineStep, PicksACardOfAtHisHand);
  injector.register(PostLineStep, PicksFromHandACard);
  injector.register(PostLineStep, PlacesTheCardIntoThePile);
  injector.register(PostLineStep, PlaysACardIntoHisSquarePile);
  injector.register(PostLineStep, PlaysACardIntoTheSquarePile);
  injector.register(PostLineStep, PlaysACardOfIntoThePile);
  injector.register(PostLineStep, PlaysNCardsIntoHisSquarePile);
  injector.register(PostLineStep, PlaysNCardsIntoThePile);
  injector.register(PostLineStep, PlaysNCardsIntoTheSquarePile);
  injector.register(PostLineStep, PlaysNCardsOfIntoThePile);
  injector.register(PostLineStep, PlaysNCardsOfIntoTheSquarePile);
  injector.register(PostLineStep, ThereAreNoHighlightedCards);
}
