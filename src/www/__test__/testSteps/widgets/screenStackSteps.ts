import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/dom";

export const screenStackSteps: PostLineStep[] = [
  step(/You should be at the "([^"]+)" screen/, (line, [, screenName]) => {
    const found = screen.getByTestId(`screen-${screenName}`);
    expect(found).toBeInTheDocument();
  }),
];
