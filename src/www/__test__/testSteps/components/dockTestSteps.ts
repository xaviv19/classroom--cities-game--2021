import { screen, within } from "@testing-library/react";
import { PostLineStep, step } from "../../testPost";
import {
  getEntityListItem,
  queryAllEntityListItem,
} from "../screens/gameTestSteps";

export const dockTestSteps: PostLineStep[] = [
  step(
    /There should be (\d+) docked "([^"]+)" "([^"]+)"/,
    (line, [, count, owner, type]) => {
      const item = queryAllEntityListItem(owner, type);
      expect(item).toHaveLength(+count);
    }
  ),
  step(
    /There should be docked the "([^"]+)" "([^"]+)" "([^"]+)"/,
    (line, [, owner, type, name]) => {
      const item = getEntityListItem(owner, type, name);
      expect(item).toBeInTheDocument();
    }
  ),
  step(
    /Go to see the docked "([^"]+)" "([^"]+)" "([^"]+)"/,
    (line, [, owner, type, name]) => {
      getEntityListItem(owner, type, name).click();
    }
  ),
  step(
    /It should be docked at the "([^"]+)" "([^"]+)" "([^"]+)"/,
    (line, [, owner, type, name]) => {
      const main = screen.getByRole("main");
      const dockedAt = within(main).getByText(/docked at:/i);

      expect(dockedAt).toHaveTextContent(owner);
      expect(dockedAt).toHaveTextContent(type);
      expect(dockedAt).toHaveTextContent(name);
    }
  ),
  step(/Go to see the dock/, () => {
    screen.getByRole("button", { name: "See the dock" }).click();
  }),
  step(/It should not be docked/, () => {
    const main = screen.getByRole("main");
    const dockedAt = within(main).queryByText(/docked at:/i);

    expect(dockedAt).toBeNull();
  }),
  step(
    /The dock resource "([^"]+)" count should be (\d+)/,
    (line, [, resourceName, count]) => {
      var resource = screen.getByTestId(`dock-resource-${resourceName}`);
      expect(resource).toHaveTextContent(new RegExp(`: ${count}/`));
    }
  ),
  step(
    /The dock resource "([^"]+)" maximum should be (\d+)/,
    (line, [, resourceName, count]) => {
      var resource = screen.getByTestId(`dock-resource-${resourceName}`);
      expect(resource).toHaveTextContent(new RegExp(`/${count} `));
    }
  ),
];
