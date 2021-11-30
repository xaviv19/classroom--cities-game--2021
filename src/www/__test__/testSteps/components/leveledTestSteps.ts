import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/dom";

export const leveledTestSteps: PostLineStep[] = [
  step(
    /The _level_ number should be (\d+)/,
    (line: any, [, level]: string[]) => {
      const main = screen.getByRole("main");
      expect(main).toHaveTextContent(new RegExp(`level: ${level}`, "i"));
    }
  ),
  step(/Upgrade the level/, () => {
    screen.getByRole("button", { name: "Upgrade" }).click();
  }),
];
