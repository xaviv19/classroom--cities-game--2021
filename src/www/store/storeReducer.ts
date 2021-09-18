import { combineReducers } from "redux";
import { widgetsReducers } from "www/widgets/reducers";
import { gameReducer } from "./game/reducers";
import { gamesListReducer } from "./gamesList/reducers";
import { playerReducer } from "./player/reducers";

export const storeReducer = combineReducers({
  ...widgetsReducers,
  game: gameReducer,
  gamesList: gamesListReducer,
  player: playerReducer,
});
