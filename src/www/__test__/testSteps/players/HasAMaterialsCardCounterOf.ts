import { screen } from "@testing-library/dom";
import { Injector } from "www/injector";
import { AbstractPostLineStep } from "../AbstractPostLineStep";

export class HasAMaterialsCardCounterOf extends AbstractPostLineStep {
  constructor(injector: Injector) {
    super(/_([^_]+)_ has a materials card counter of _([^_]+)_/i);
  }

  async runMatch(_: any, match: string[]) {
    const [, playerName, count] = match;

    const cardCounter = screen.getByTestId(`player-${playerName}-card-counter`);
    expect(cardCounter).toHaveTextContent(count);
  }
}
