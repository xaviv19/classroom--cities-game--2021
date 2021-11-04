import {PostLineStep, step} from "../../testPost";
import {screen} from "@testing-library/dom";
import userEvent from "@testing-library/user-event";

export const wallTestSteps: PostLineStep[] = [

  step(/Click the Create wall button/, () => {
    const button = screen.getByRole("button", { name: "Create wall" });
    userEvent.click(button);
  }),

];
