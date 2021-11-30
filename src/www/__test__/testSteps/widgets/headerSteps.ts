import { PostLineStep, step } from "../../testPost";
// TODO: should be react
import { screen } from "@testing-library/dom";

export const headerSteps: PostLineStep[] = [
  step(/Enter "([^"]+)" as player name/, (line, [, playerName]) => {
    enterPlayerName(playerName);
  }),
  step(/Click the play button/, () => {
    clickPlay();
  }),
  step(/Go to the next player "([^"]+)"/, (line, [, playerName]) => {
    enterPlayerName(playerName);
    clickPlay();
  }),
];

export function enterPlayerName(playerName: string) {
  const input = screen.getByTestId(`input-player-name`) as HTMLInputElement;
  input.value = playerName;
}

export function clickPlay() {
  screen.getByTestId(`button-play`).click();
}
