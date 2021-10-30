import {PostLineStep, step} from "../../testPost";
import {screen} from "@testing-library/dom";
import userEvent from "@testing-library/user-event";

export const houseTestSteps: PostLineStep[] = [
step(/Click the Create House button/, () => {
  const button = screen.getByRole("button", { name: "Create House" });
  userEvent.click(button);
}),
  ];
