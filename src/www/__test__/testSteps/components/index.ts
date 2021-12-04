import { ListOfSteps } from "www/__test__/testPost";
import { buildersTestSteps } from "./buildersTestSteps";
import { containedsTestSteps } from "./containedsTestSteps";
import { dockTestSteps } from "./dockTestSteps";
import { leveledTestSteps } from "./leveledTestSteps";
import { loadableTestSteps } from "./loadableTestSteps";
import { locatedTestSteps } from "./locatedTestSteps";
import { namedTestSteps } from "./namedTestSteps";
import { resourcedModifierTestSteps } from "./resourcedModifierTestSteps";
import { resourcedTestSteps } from "./resourcedTestSteps";
import { sailTestSteps } from "./sailTestSteps";

export const componentsTestSteps: ListOfSteps = [
  buildersTestSteps,
  containedsTestSteps,
  dockTestSteps,
  leveledTestSteps,
  loadableTestSteps,
  locatedTestSteps,
  namedTestSteps,
  resourcedModifierTestSteps,
  resourcedTestSteps,
  sailTestSteps,
];
