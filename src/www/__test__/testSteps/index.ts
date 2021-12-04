import { ListOfSteps } from "../testPost";
import { backendTestSteps } from "./backendTestSteps";
import { componentsTestSteps } from "./components";
import { screensTestSteps } from "./screens";
import { widgetsTestSteps } from "./widgets";

export const customTestSteps: ListOfSteps = [
  backendTestSteps,
  componentsTestSteps,
  screensTestSteps,
  widgetsTestSteps,
];
