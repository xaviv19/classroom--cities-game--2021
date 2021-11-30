import { getByText, queryByText, screen } from "@testing-library/dom";
import userEvent from "@testing-library/user-event";
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
      const item = getEntityListItem(owner, type, name);
      item.click();
    }
  ),
  step(
    /It should be docked at the "([^"]+)" "([^"]+)" "([^"]+)"/,
    (line, [, owner, type, name]) => {
      const main = screen.getByRole("main");
      const dockedAt = getByText(main, /docked at:/i);

      expect(dockedAt).toHaveTextContent(owner);
      expect(dockedAt).toHaveTextContent(type);
      expect(dockedAt).toHaveTextContent(name);
    }
  ),
  step(/Go to see the dock/, () => {
    const main = screen.getByRole("button", { name: "See the dock" });
    userEvent.click(main);
  }),
  step(/It should not be docked/, () => {
    const main = screen.getByRole("main");
    const dockedAt = queryByText(main, /docked at:/i);

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
