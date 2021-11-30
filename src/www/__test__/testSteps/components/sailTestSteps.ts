import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/dom";
import userEvent from "@testing-library/user-event";

export const sailTestSteps: PostLineStep[] = [
  step(
    /The _destination location_ number should be (\d+)/,
    (line, [, location]) => {
      const main = screen.getByRole("main");
      expect(main).toHaveTextContent(
        new RegExp(`Destination location[: ]+${location}[^\\d]`, "i")
      );
    }
  ),
  step(/The _destination sail_ state should be _active_/, () => {
    const main = screen.getByRole("main");
    expect(main).toHaveTextContent(
      new RegExp(`Destination location.*(sailing)`, "i")
    );
  }),
  step(/The _destination sail_ state should be _inactive_/, () => {
    const main = screen.getByRole("main");
    expect(main).not.toHaveTextContent(
      new RegExp(`Destination location.*(sailing)`, "i")
    );
  }),
  step(/Enter number (\d+) as _destination location_/, (line, [, location]) => {
    const input = screen.getByLabelText("Destination location:");
    userEvent.type(input, location);
  }),
  step(/Set sail/, () => {
    const button = screen.getByRole("button", { name: "Sail" });
    userEvent.click(button);
  }),
  step(/Halt sailing/, () => {
    const button = screen.getByRole("button", { name: "Halt" });
    userEvent.click(button);
  }),
];
