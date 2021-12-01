import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/react";

export const resourcedModifierTestSteps: PostLineStep[] = [
  step(
    /The resource modifier for "([^"]+)" maximum should be (\d+)/,
    (line, [, resourceName, modifier]) => {
      const name = screen.getByTestId(`resource-modifier-name`);
      const resource = screen.getByTestId(`resource-modifier-maximum`);
      expect(name).toHaveTextContent(resourceName);
      expect(resource).toHaveTextContent(modifier);
    }
  ),
  step(
    /The resource modifier for "([^"]+)" round increment should be (\d+)/,
    (line, [, resourceName, modifier]) => {
      const name = screen.getByTestId(`resource-modifier-name`);
      const resource = screen.getByTestId(`resource-modifier-roundincrement`);
      expect(name).toHaveTextContent(resourceName);
      expect(resource).toHaveTextContent(modifier);
    }
  ),
];
