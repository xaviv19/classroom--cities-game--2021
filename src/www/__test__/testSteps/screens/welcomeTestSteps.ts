import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/react";

export const welcomeTestSteps: PostLineStep[] = [
  step(/Go to the Welcome screen/, () => {
    screen.getByRole("link", { name: /^Welcome$/ }).click();
  }),
];
