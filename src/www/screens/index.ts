import { CreateGameScreen } from "./CreateGameScreen";
import { GamesListScreen } from "./GamesListScreen";
import { LoginScreen } from "./LoginScreen";
import { PlayerScreen } from "./PlayerScreen";
import { SignUpScreen } from "./SignUpScreen";
import { WelcomeScreen } from "./WelcomeScreen";

export const screenMap: { [screenName: string]: Function } = {
  createGame: CreateGameScreen,
  gamesList: GamesListScreen,
  login: LoginScreen,
  player: PlayerScreen,
  signup: SignUpScreen,
  welcome: WelcomeScreen,
};
