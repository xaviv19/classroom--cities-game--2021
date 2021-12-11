import { PostLineStep, step } from "../testPost";

export const backendTestSteps: PostLineStep[] = [
  step(/Given that "[^"]+" is playing/, () => {}),
  step(
    /Given that the "[^"]+" "[^"]+" "[^"]+" has built a "[^"]+"/,
    () => {}
  ),
  step(
    /Given that the "[^"]+" "[^"]+" "[^"]+" has resource "[^"]+" count \d+/,
    () => {}
  ),
];
