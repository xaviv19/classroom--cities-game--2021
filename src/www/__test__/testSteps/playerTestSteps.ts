import { PostLineStep, step } from "../testPost";
import { screen } from "@testing-library/dom";

export const playerTestSteps: PostLineStep[] = [
  step(/You should be (back )?at the player screen/, () => {
    expect(
      screen.getByRole("heading", { name: /Welcome.*player!/ })
    ).toBeInTheDocument();
  }),
  step(/"([^"]+)" should be the current player/, (title, [, playerName]) => {
    expect(screen.getByTestId("player-header")).toHaveTextContent(playerName);
  }),
];
