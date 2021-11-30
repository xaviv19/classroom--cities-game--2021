import { combineReducers } from "redux";
import { componentsReducers } from "www/components/reducers";
import { widgetsReducers } from "www/widgets/reducers";
import { screensReducers } from "www/screens/reducers";
import { gameReducer } from "./game/reducers";

export const storeReducer = combineReducers({
  ...componentsReducers,
  ...widgetsReducers,
  ...screensReducers,
  game: gameReducer,
});
