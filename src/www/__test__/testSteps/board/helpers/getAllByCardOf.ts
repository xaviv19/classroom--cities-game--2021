import { prettyDOM } from "@testing-library/dom";
import { getAllByCard } from "./getAllByCard";

export function getAllByCardOf(
  container: HTMLElement,
  type: string,
  name: string
): HTMLElement[] {
  const cards = getAllByCard(container, type);
  const result = cards.filter((c) => c.dataset.name === name);
  if (result.length !== 0) return result;

  let foundText = cards.length
    ? `It found a total of (${cards.length}) ${type} cards:\n` +
      cards
        .map(
          (c) =>
            ` - <element data-testid="card-${type}" data-name="${c.dataset.name}" />`
        )
        .join("\n")
    : `It found no (0) cards ${type} .`;

  foundText += "\n\nActual DOM:\n" + prettyDOM(container);

  throw new ReferenceError(
    `Cannot find a "${type}" card of "${name}".\n` +
      `Expected to find an element <element data-testid="card-${type}" data-name="${name}" />\n` +
      foundText
  );
}
