import { AbstractPostLineStep } from "../AbstractPostLineStep";
import { queryByHighlighted } from "./helpers";

export class ThereAreNoHighlightedCards extends AbstractPostLineStep {
  constructor() {
    super(/There are no highlighted cards/i);
  }

  async runMatch(_: any, match: string[]) {
    const highlighted = queryByHighlighted(document.body);
    expect(highlighted).not.toBeInTheDocument();
  }
}
