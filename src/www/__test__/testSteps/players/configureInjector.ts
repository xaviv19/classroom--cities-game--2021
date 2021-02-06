import { Injector } from "www/injector";
import { PostLineStep } from "www/__test__/testPost";
import { AllPlayersClickReadyAndThenRefreshInTheMainHeader } from "./AllPlayersClickReadyAndThenRefreshInTheMainHeader";
import { ClickReadyInTheMainHeader } from "./ClickReadyInTheMainHeader";
import { ClickRefreshInTheMainHeader } from "./ClickRefreshInTheMainHeader";
import { HasAMaterialsCardCounterOf } from "./HasAMaterialsCardCounterOf";
import { HasTheTotalReceivedFoodCounterOf } from "./HasTheTotalReceivedFoodCounterOf";
import { UseTheBrowserOf } from "./UseTheBrowserOf";

export default function configureTestStepsPlayersInjector(injector: Injector) {
  injector.register(
    PostLineStep,
    AllPlayersClickReadyAndThenRefreshInTheMainHeader
  );
  injector.register(PostLineStep, ClickReadyInTheMainHeader);
  injector.register(PostLineStep, ClickRefreshInTheMainHeader);
  injector.register(PostLineStep, HasAMaterialsCardCounterOf);
  injector.register(PostLineStep, HasTheTotalReceivedFoodCounterOf);
  injector.register(PostLineStep, UseTheBrowserOf);
}
