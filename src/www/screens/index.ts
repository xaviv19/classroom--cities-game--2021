import { AddNextPlayerScreen } from "./AddNextPlayerScreen";
import { CreateGameScreen } from "./CreateGameScreen";
import { EntityScreen } from "./EntityScreen/EntityScreen";
import { GameScreen } from "./GameScreen/GameScreen";
import { GamesListScreen } from "./GamesListScreen";
import { LoginScreen } from "./LoginScreen";
import { PlayerScreen } from "./PlayerScreen";
import { SignUpScreen } from "./SignUpScreen";
import { WelcomeScreen } from "./WelcomeScreen";

export const screenMap: { [screenName: string]: Function } = {
  addNextPlayer: AddNextPlayerScreen,
  createGame: CreateGameScreen,
  entity: EntityScreen,
  game: GameScreen,
  gamesList: GamesListScreen,
  login: LoginScreen,
  player: PlayerScreen,
  signup: SignUpScreen,
  welcome: WelcomeScreen,
};