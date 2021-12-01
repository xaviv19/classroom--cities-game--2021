import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/react";

export const gameTestSteps: PostLineStep[] = [
  step(/"([^"]+)" should be the current player/, (title, [, playerName]) => {
    const item = screen.getByTestId("player-name");
    expect(item).toHaveTextContent(playerName);
  }),
  step(
    /"([^"]+)" should have (\d+) "([^"]+)"/,
    (title, [, owner, count, type]) => {
      const items = queryAllEntityListItem(owner, type);
      expect(items).toHaveLength(+count);
    }
  ),
  step(
    /"([^"]+)" should have the "([^"]+)" "([^"]+)"/,
    (title, [, owner, name, type]) => {
      const item = getEntityListItem(owner, type, name);
      expect(item).toBeInTheDocument();
    }
  ),
  step(
    /Go to the "([^"]+)" "([^"]+)" "([^"]+)"/,
    (title, [, owner, type, name]) => {
      getEntityListItem(owner, type, name).click();
    }
  ),
  step(/The game round should be (\d+)/, (title, [, round]) => {
    const item = screen.getByTestId("game-round");
    expect(item).toHaveTextContent(round);
  }),
  step(/End the round/, endRound),
  step(/Skip \d+ rounds/, refresh),
  step(/Refresh the game/, refresh),
];

export function getEntityListItem(owner: string, type: string, name: string) {
  const items = screen
    .queryAllByTestId("entity-list-item")
    .filter((i) => i.textContent!.includes(owner))
    .filter((i) => i.textContent!.includes(type))
    .filter((i) => i.textContent!.includes(name));

  expect(items).toHaveLength(1);
  const item = items[0];
  return item;
}

export function queryAllEntityListItem(owner: string, type: string) {
  const items = screen
    .queryAllByTestId("entity-list-item")
    .filter((i) => i.textContent!.includes(owner))
    .filter((i) => i.textContent!.includes(type));

  return items;
}

function endRound() {
  screen.getByRole("button", { name: "End Round" }).click();
}

function refresh() {
  screen.getByRole("button", { name: "Refresh" }).click();
}
