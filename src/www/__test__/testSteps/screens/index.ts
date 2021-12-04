import { ListOfSteps } from "www/__test__/testPost";
import { blogListTestSteps } from "./blogListTestSteps";
import { entityTestSteps } from "./entityTestSteps";
import { gameTestSteps } from "./gameTestSteps";
import { postListTestSteps } from "./postListTestSteps";
import { welcomeTestSteps } from "./welcomeTestSteps";

export const screensTestSteps: ListOfSteps = [
  blogListTestSteps,
  entityTestSteps,
  gameTestSteps,
  postListTestSteps,
  welcomeTestSteps,
];
