import {PostLineStep, step} from "../../testPost";
import {screen} from "@testing-library/dom";
import userEvent from "@testing-library/user-event";

export const houseTestSteps: PostLineStep[] = [

  step(/Click the Create house button/, () => {
    const button = screen.getByRole("button", { name: "Create house" });
    userEvent.click(button);
  }),

];
