import { screen } from "@testing-library/react";
import { PostLineStep, step } from "../../testPost";

export const buildersTestSteps: PostLineStep[] = [
  step(/Build the "([^"]+)"/, (line, [, building]) => {
    const type = screen.getByLabelText("Building type:") as HTMLInputElement;
    type.value = building;
    const build = screen.getByRole("button", { name: "Build" });
    build.click();
  }),
];
