import { createGameTestSteps } from "./createGameTestSteps";
import { entityTestSteps } from "./entityTestSteps";
import { entityListTestSteps } from "./entityListTestSteps";
import { gameTestSteps } from "./gameTestSteps";
import { gameListTestSteps } from "./gameListTestSteps";
import { loginTestSteps } from "./loginTestSteps";
import { multiplayerTestSteps } from "./multiplayerTestSteps";
import { playerTestSteps } from "./playerTestSteps";
import { signupTestSteps } from "./signupTestSteps";
import { welcomeTestSteps } from "./welcomeTestSteps";

export const screensTestSteps = [
  createGameTestSteps,
  entityTestSteps,
  entityListTestSteps,
  gameTestSteps,
  gameListTestSteps,
  loginTestSteps,
  multiplayerTestSteps,
  playerTestSteps,
  signupTestSteps,
  welcomeTestSteps,
];
