import { getByTestId } from "@testing-library/dom";

export function getBySquare(
  container: HTMLElement,
  player: string,
  square: number
): HTMLElement {
  return getByTestId(container, `${player}-square-${square}`);
}
