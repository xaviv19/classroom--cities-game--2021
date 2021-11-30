import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/dom";

export const locatedTestSteps: PostLineStep[] = [
  step(/The _location_ number should be (\d+)/, theLocationShouldBe),
];

function theLocationShouldBe(line: any, [, location]: string[]) {
  const main = screen.getByRole("main");
  expect(main).toHaveTextContent(new RegExp(`location[: ]+${location}`, "i"));
}
