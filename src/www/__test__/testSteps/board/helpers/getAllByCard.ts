import { getAllByTestId } from "@testing-library/dom";

export function getAllByCard(
  container: HTMLElement,
  type: string
): HTMLElement[] {
  return getAllByTestId(container, `card-${type}`);
}
