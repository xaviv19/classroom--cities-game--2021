import { AbstractPostLineStep } from "../AbstractPostLineStep";
import { getByAlert } from "./helpers";

export class ThereIsAMessageThatSays extends AbstractPostLineStep {
  constructor() {
    super(/There is a message that says "([^"]+)"/i);
  }

  async runMatch(_: any, match: string[]) {
    const [, message] = match;
    const alert = getByAlert(document.body);
    expect(alert).toHaveTextContent(message);
  }
}
