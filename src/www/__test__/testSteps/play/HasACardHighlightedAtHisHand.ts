import { AbstractPostLineStep } from "../AbstractPostLineStep";
import { getByHand } from "../board/helpers";
import { getByHighlighted } from "./helpers";

export class HasACardHighlightedAtHisHand extends AbstractPostLineStep {
  constructor() {
    super(/_([^_]+)_ has an? _([^_]+)_ card highlighted at h[ei][rs] hand/i);
  }

  async runMatch(_: any, match: string[]) {
    const [, player, type] = match;
    const hand = getByHand(document.body, player);

    const highlighted = getByHighlighted(hand);

    expect(highlighted).toBeInTheDocument();
    expect(highlighted).toHaveAttribute("data-testid", `card-${type}`);
  }
}
