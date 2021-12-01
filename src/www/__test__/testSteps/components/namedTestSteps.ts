import { PostLineStep, step } from "../../testPost";
import { screen } from "@testing-library/react";

export const namedTestSteps: PostLineStep[] = [
  step(/Enter new name "([^"]+)"/, (line, [, text]) => {
    enterNewName(text);
  }),
  step(/Ask to change the name/, () => {
    askChangeName();
  }),
  step(/Change the name to "([^"]+)"/, (line, [, text]) => {
    enterNewName(text);
    askChangeName();
  }),
  step(/There should be no _change name_/, (line, [, text]) => {
    const button = screen.queryByRole("button", { name: "Change name" });
    expect(button).toBeNull();
  }),
];

function enterNewName(newName: string) {
  const input = screen.getByLabelText("New name:") as HTMLInputElement;
  input.value = newName;
}

function askChangeName() {
  screen.getByRole("button", { name: "Change name" }).click();
}
