import { AppState } from "www/store";

export function getGamesList(state: AppState) {
  return state.gamesList;
}
