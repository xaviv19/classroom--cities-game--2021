import thunkMiddleware from "redux-thunk";
import { gameMiddleware } from "./game/middleware";
import { gamesListMiddleware } from "./gamesList/middleware";
import { multiplayerMiddleware } from "./multiplayer/middleware";
import { playerMiddleware } from "./player/middleware";

export const storeMiddlewares = [
  thunkMiddleware,
  // Add other middleware after this line
  gameMiddleware,
  gamesListMiddleware,
  multiplayerMiddleware,
  playerMiddleware,
];
