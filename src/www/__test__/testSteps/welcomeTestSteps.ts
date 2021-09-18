import { PostLineStep, step } from "../testPost";
import { screen } from "@testing-library/dom";

export const welcomeTestSteps: PostLineStep[] = [
  step(/You should be (back )?at the welcome screen/, () => {
    expect(
      screen.getByRole("heading", { name: "Welcome to the game!" })
    ).toBeInTheDocument();
  }),
];
