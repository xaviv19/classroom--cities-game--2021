import { queryAllByTestId } from "@testing-library/dom";

export function queryAllByCard(
  container: HTMLElement,
  type: string
): HTMLElement[] {
  return queryAllByTestId(container, `card-${type}`);
}
