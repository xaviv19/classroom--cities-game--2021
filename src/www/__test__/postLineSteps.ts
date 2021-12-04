import { PostLineStep, systemPostLineSteps } from "./testPost";
import { customTestSteps } from "./testSteps";

export const postLineSteps: PostLineStep[] = [
  systemPostLineSteps,
  customTestSteps,
].flat(Infinity) as any;
