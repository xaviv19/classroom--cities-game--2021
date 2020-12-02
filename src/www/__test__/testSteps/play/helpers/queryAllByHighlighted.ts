export function queryAllByHighlighted(container: HTMLElement): HTMLElement[] {
  return Array.from(
    container.querySelectorAll('[data-testid^="card-"][data-highlighted="yes"]')
  ) as HTMLElement[];
}
