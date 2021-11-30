import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/dom";
import userEvent from "@testing-library/user-event";

export const welcomeTestSteps: PostLineStep[] = [
  step(/Go to the Welcome screen/, () => {
    const link = screen.getByRole("link", { name: /^Welcome$/ });
    userEvent.click(link);
  }),
];
