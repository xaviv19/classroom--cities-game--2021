import { BlogScreen } from "./BlogScreen";
import { EntityScreen } from "./EntityScreen/EntityScreen";
import { GameScreen } from "./GameScreen/GameScreen";
import { PostScreen } from "./PostScreen";
import { WelcomeScreen } from "./WelcomeScreen";

export const screenMap: { [screenName: string]: Function } = {
  blog: BlogScreen,
  entity: EntityScreen,
  game: GameScreen,
  post: PostScreen,
  welcome: WelcomeScreen,
};
