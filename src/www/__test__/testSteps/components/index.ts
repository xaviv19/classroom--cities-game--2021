import { dockTestSteps } from "./dockTestSteps";
import { loadableTestSteps } from "./loadableTestSteps";
import { locatedTestSteps } from "./locatedTestSteps";
import { namedTestSteps } from "./namedTestSteps";
import { populatedTestSteps } from "./populatedTestSteps";
import { sailTestSteps } from "./sailTestSteps";
import {houseTestSteps} from "./houseTestSteps";
import {wallTestSteps} from "./wallTestSteps";

export const componentsTestSteps = [
  dockTestSteps,
  loadableTestSteps,
  locatedTestSteps,
  namedTestSteps,
  populatedTestSteps,
  sailTestSteps,
  houseTestSteps,
  wallTestSteps,
];
