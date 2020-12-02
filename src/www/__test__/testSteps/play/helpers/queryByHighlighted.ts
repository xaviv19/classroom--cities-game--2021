import { prettyDOM } from "@testing-library/dom";
import { queryAllByHighlighted } from "./queryAllByHighlighted";

export function queryByHighlighted(container: HTMLElement): HTMLElement | null {
  var highlighteds = queryAllByHighlighted(container);

  if (highlighteds.length === 1) return highlighteds[0];
  if (highlighteds.length === 0) return null;

  throw new Error(
    `It found a total of (${highlighteds.length}) highlighted cards but only (0) or (1) expected:\n` +
      highlighteds
        .map(
          (c) =>
            ` - <element data-testid="${c.dataset.testid}" data-highlighted="yes" data-name="${c.dataset.name}" />`
        )
        .join("\n") +
      `\n\nActual DOM:\n${prettyDOM(container)}`
  );
}
