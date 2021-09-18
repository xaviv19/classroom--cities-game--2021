import { PostLineStep, step } from "../testPost";

export const backendTestSteps: PostLineStep[] = [
  step(/there is your player/, () => {}),
  step(/there is the player "[^"]+"( with password "[^"]+")?/, () => {}),
];
