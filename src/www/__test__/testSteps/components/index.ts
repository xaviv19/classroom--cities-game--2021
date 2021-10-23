import { dockTestSteps } from "./dockTestSteps";
import { informedTestSteps } from "./informedTestSteps";
import { loadableTestSteps } from "./loadableTestSteps";
import { locatedTestSteps } from "./locatedTestSteps";
import { namedTestSteps } from "./namedTestSteps";
import { populatedTestSteps } from "./populatedTestSteps";
import { sailTestSteps } from "./sailTestSteps";
import { withBuildingsTestSteps } from "./withBuildingsTestSteps";

export const componentsTestSteps = [
  dockTestSteps,
  informedTestSteps,
  loadableTestSteps,
  locatedTestSteps,
  namedTestSteps,
  populatedTestSteps,
  sailTestSteps,
  withBuildingsTestSteps,
];
