import { PostLineStep, step } from "../testPost";
import { screen } from "@testing-library/dom";
import userEvent from "@testing-library/user-event";

export const gameListTestSteps: PostLineStep[] = [
  step(/Go to my created games/, () => {
    const link = screen.getByRole("link", { name: "My created games" });
    userEvent.click(link);
  }),
  step(/You should be at the list games screen/, () => {
    expect(
      screen.getByRole("heading", { name: "Games List!" })
    ).toBeInTheDocument();
  }),
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
];
function queryAllGameListItems(): HTMLElement[] {
  return screen.queryAllByRole("listitem");
}
