import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/dom";

export const resourcedTestSteps: PostLineStep[] = [
  step(
    /The resource "([^"]+)" count should be (\d+)/,
    (line, [, resourceName, count]) => {
      var resource = screen.getByTestId(`resource-${resourceName}`);
      expect(resource).toHaveTextContent(new RegExp(`: ${count}/`));
    }
  ),
  step(
    /The resource "([^"]+)" maximum should be (\d+)/,
    (line, [, resourceName, maximum]) => {
      var resource = screen.getByTestId(`resource-${resourceName}`);
      expect(resource).toHaveTextContent(new RegExp(`/${maximum} `));
    }
  ),
  step(
    /The resource "([^"]+)" round increment should be (\d+)/,
    (line, [, resourceName, roundIncrement]) => {
      var resource = screen.getByTestId(`resource-${resourceName}`);
      expect(resource).toHaveTextContent(
        new RegExp(`\\(\\+${roundIncrement}\\)`)
      );
    }
  ),
];
