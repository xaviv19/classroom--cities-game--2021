import { Injector } from "www/injector";
import { ReduxStore } from "./ReduxStore";
import configureBlogInjector from "./blog";
import configureCardsInjector from "./cards";
import configureCurrentUserInjector from "./currentUser";
import configureGameInjector from "./game";
import configureLoadingInjector from "./loading";
import configureNewGameInjector from "./newGame";
import configureSelectedCardInjector from "./selectedCard";
import configureViewInjector from "./view";

export default function configureDucksnjector(injector: Injector) {
  injector.configure(configureBlogInjector);
  injector.configure(configureCardsInjector);
  injector.configure(configureCurrentUserInjector);
  injector.configure(configureGameInjector);
  injector.configure(configureLoadingInjector);
  injector.configure(configureNewGameInjector);
  injector.configure(configureSelectedCardInjector);
  injector.configure(configureViewInjector);

  injector.register(ReduxStore);
}
