import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/react";

export const loadableTestSteps: PostLineStep[] = [
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

    screen.getByRole("button", { name: "Unload" }).click();
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

  screen.getByRole("button", { name: "Load" }).click();
}
