import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/react";

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
    screen.getByRole("link", { name: "« Back" }).click();
  }),
  step(/There should (be|be no) "([^"]+)" emoji/, (line, [, be, resource]) => {
    var isBe = be === "be";
    var listItem = screen.queryAllByTestId("entity-list-item");
    var text = listItem[1].textContent;
    var icon = text?.includes("\ud83e\udd54");
    expect(icon).toBe(isBe);
  }),
];
