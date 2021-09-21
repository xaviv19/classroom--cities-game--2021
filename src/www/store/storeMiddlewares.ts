import thunkMiddleware from "redux-thunk";
import { componentsMiddlewares } from "www/components/middleware";
import { gameMiddleware } from "./game/middleware";
import { gamesListMiddleware } from "./gamesList/middleware";
import { multiplayerMiddleware } from "./multiplayer/middleware";
import { playerMiddleware } from "./player/middleware";

export const storeMiddlewares = [
  thunkMiddleware,
  ...componentsMiddlewares,
  // Add other middleware after this line
  gameMiddleware,
  gamesListMiddleware,
  multiplayerMiddleware,
  playerMiddleware,
];
