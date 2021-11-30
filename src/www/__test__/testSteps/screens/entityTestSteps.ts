import { PostLineStep, step } from "../../testPost";
import { screen, within } from "@testing-library/dom";
import userEvent from "@testing-library/user-event";

export const entityTestSteps: PostLineStep[] = [
  step(/You should be at the screen of a "([^"]+)"/, (line, [, type]) => {
    var title = screen.getByTestId("screen-entity-title");
    expect(title).toHaveTextContent(type);
  }),
  step(/The _name_ content should be "([^"]+)"/, (line, [, name]) => {
    var title = screen.getByTestId("screen-entity-title");
    expect(title).toHaveTextContent(name);
  }),
  step(/The _owner_ content should be "([^"]+)"/, (line, [, owner]) => {
    var title = screen.getByTestId("screen-entity-title");
    expect(title).toHaveTextContent(owner);
  }),
  step(/The _type_ content should be "([^"]+)"/, (line, [, type]) => {
    var title = screen.getByTestId("screen-entity-title");
    expect(title).toHaveTextContent(type);
  }),
  step(/Go back to the previous screen/, (line, [, name]) => {
    const button = screen.getByRole("link", { name: "« Back" });
    userEvent.click(button);
  }),
  step(/There should not be a back button/, (line, [, name]) => {
    // TODO: check if it is needed
    const button = screen.queryByRole("link", { name: "« Back" });
    expect(button).toBeNull();
  }),
];
