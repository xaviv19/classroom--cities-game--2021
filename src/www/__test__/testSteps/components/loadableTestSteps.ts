import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/react";

export const loadableTestSteps: PostLineStep[] = [
  step(/The load unload amount should be (\d+)/, (line, [, amount]) => {
    const main = screen.getByRole("main");
    expect(main).toHaveTextContent(
      new RegExp(`Load/unload amount[: ]+${amount}[^\\d]`, "i")
    );
  }),
  step(
    /The (load|unload) requested should be (active|inactive)/,
    (line, [, action, active]) => {
      const isActive = active === "active";
      const button = screen.getByRole("button", {
        name: new RegExp(`^${action}$`, "i"),
      });
      expect(button).toMatchObject({ disabled: isActive });
    }
  ),
  step(/Enter number (\d+) as _load unload amount_/, (line, [, amount]) => {
    enterLoadUnloadAmount(amount);
  }),
  step(/Load the resource "([^"]+)"/, (line, [, resourceName]) => {
    loadTheResource(resourceName);
  }),
  step(/Load (\d+) of "([^"]+)"/, (line, [, amount, resourceName]) => {
    enterLoadUnloadAmount(amount);
    loadTheResource(resourceName);
  }),
  step(/Unload the resource "([^"]+)"/, (line, [, resource]) => {
    const input = screen.getByLabelText("Resource:") as HTMLInputElement;
    input.value = resource;
    const button = screen.getByRole("button", { name: "Unload" });
    button.click();
  }),
];

function enterLoadUnloadAmount(amount: string) {
  const input = screen.getByLabelText(
    "Load/unload amount:"
  ) as HTMLInputElement;
  input.value = amount;
}

function loadTheResource(resourceName: string) {
  const input = screen.getByLabelText("Resource:") as HTMLInputElement;
  input.value = resourceName;
  const button = screen.getByRole("button", { name: "Load" });
  button.click();
}
