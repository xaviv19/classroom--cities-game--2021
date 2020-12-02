import { prettyDOM } from "@testing-library/dom";
import { queryByHighlighted } from "./queryByHighlighted";

export function getByHighlighted(container: HTMLElement): HTMLElement {
  var highlighted = queryByHighlighted(container);

  if (highlighted !== null) return highlighted;

  throw new Error(
    `It found no (0) highlighted cards.\n\nActual DOM:\n` + prettyDOM(container)
  );
}
