import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/dom";
import userEvent from "@testing-library/user-event";

export const informedTestSteps: PostLineStep[] = [
  step(/The wood should be (\d+)/, (line, [, amount]) => {
    const main = screen.getByRole("main");
    expect(main).toHaveTextContent(new RegExp(`Wood[: ]+${amount}[^\\d]`, "i"));
  }),
  step(/The stone should be (\d+)/, (line, [, amount]) => {
    const main = screen.getByRole("main");
    expect(main).toHaveTextContent(
      new RegExp(`Stone[: ]+${amount}[^\\d]`, "i")
    );
  }),
  step(/The iron should be (\d+)/, (line, [, amount]) => {
    const main = screen.getByRole("main");
    expect(main).toHaveTextContent(new RegExp(`Iron[: ]+${amount}[^\\d]`, "i"));
  }),
  step(/The trade resources option should be active/, () => {
    const main = screen.getByRole("main");
    expect(main).toHaveTextContent(
      new RegExp(`Trade resources.*(active)`, "i")
    );
  }),
  step(/The buildings option should be active/, () => {
    const main = screen.getByRole("main");
    expect(main).toHaveTextContent(new RegExp(`Buildings.*(active)`, "i"));
  }),
  step(/The troops option should be active/, () => {
    const main = screen.getByRole("main");
    expect(main).toHaveTextContent(new RegExp(`Troops.*(active)`, "i"));
  }),
  /*
  step(/Enter new name "([^"]+)"/, (line, [, text]) => {
    const input = screen.getByLabelText("New name:");
    userEvent.clear(input);
    userEvent.type(input, text);
  }),
  step(/Click the change name button/, (line, [, text]) => {
    const button = screen.getByRole("button", { name: "Change name" });
    userEvent.click(button);
  }),
  step(/There is no new city name formulary/, (line, [, text]) => {
    const button = screen.queryByRole("button", { name: "Change name" });
    expect(button).toBeNull();
  }),
  */
];
