import { combineReducers } from "redux";
import { widgetsReducers } from "www/widgets/reducers";
import { screensReducers } from "www/screens/reducers";
import { gameReducer } from "./game/reducers";
import { gamesListReducer } from "./gamesList/reducers";
import { multiplayerReducer } from "./multiplayer/reducers";
import { playerReducer } from "./player/reducers";

export const storeReducer = combineReducers({
  ...widgetsReducers,
  ...screensReducers,
  game: gameReducer,
  gamesList: gamesListReducer,
  multiplayer: multiplayerReducer,
  player: playerReducer,
});
