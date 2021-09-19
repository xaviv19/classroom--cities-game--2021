import { PostLineStep, step } from "../testPost";
import { screen } from "@testing-library/dom";
import userEvent from "@testing-library/user-event";
import { getByRole, queryByRole } from "@testing-library/react";

export const gameTestSteps: PostLineStep[] = [
  step(/You should be at the game screen/, () => {
    expect(screen.getByRole("heading", { name: "Game!" })).toBeInTheDocument();
  }),
  step(
    /Playing game should be "([^"]+)" created by "([^"]+)"/,
    (title, [, gameName, creatorName]) => {
      const header = screen.getByTestId("game-header");
      expect(header).toHaveTextContent(`${gameName} created by ${creatorName}`);
    }
  ),

  /*
  step(/There should be (\d)+ game/, (line, match) => {
    const count = +match[1];

    expect(queryAllGameListItems()).toHaveLength(count);
  }),
  step(/Games list should be empty/, () => {
    expect(queryAllGameListItems()).toHaveLength(0);
  }),
  step(/You should see the game "([^"]+)"/, (line, match) => {
    const gameName = match[1];

    const list = queryAllGameListItems();
    const game = list.find((item) => item.textContent?.includes(gameName));
    expect(game).toBeInTheDocument();
  }),
  step(/You should see no game "([^"]+)"/, (line, match) => {
    const gameName = match[1];

    const list = queryAllGameListItems();
    const games = list.filter((item) => item.textContent?.includes(gameName));
    expect(games).toHaveLength(0);
  }),
  step(/Return from the list games/, () => {
    const button = screen.getByRole("button", { name: "Cancel" });
    userEvent.click(button);
  }),
  step(/Join on the game "([^"]+)" created by "([^"]+)"/, (line, match) => {
    const [, gameName, creatorName] = match;
    const item = getGameListItemByNameAndCreator(gameName, creatorName);
    const button = getByRole(item, "button", { name: "Join" });
    userEvent.click(button);
  }),
  step(
    /You should have joined the game "([^"]+)" created by "([^"]+)"/,
    (line, [, gameName, creatorName]) => {
      const item = getGameListItemByNameAndCreator(gameName, creatorName);
      expect(getByRole(item, "button", { name: "Play" })).toBeInTheDocument();
    }
  ),
  step(
    /You should have not joined the game "([^"]+)" created by "([^"]+)"/,
    (line, [, gameName, creatorName]) => {
      const item = getGameListItemByNameAndCreator(gameName, creatorName);
      expect(queryByRole(item, "button", { name: "Play" })).toBeNull();
    }
  ),
  step(/Play on the game "([^"]+)" created by "([^"]+)"/, (line, match) => {
    const [, gameName, creatorName] = match;
    const item = getGameListItemByNameAndCreator(gameName, creatorName);
    const button = getByRole(item, "button", { name: "Play" });
    userEvent.click(button);
  }),
  */
];
