import { screen } from "@testing-library/dom";
import { Injector } from "www/injector";
import { AbstractPostLineStep } from "../AbstractPostLineStep";

export class HasTheTotalReceivedFoodCounterOf extends AbstractPostLineStep {
  constructor(injector: Injector) {
    super(/_([^_]+)_ has the total received food counter of _([^_]+)_/i);
  }

  async runMatch(_: any, match: string[]) {
    const [, playerName, count] = match;

    const cardCounter = screen.getByTestId(
      `player-${playerName}-total-food-counter`
    );
    expect(cardCounter).toHaveTextContent(count);
  }
}
