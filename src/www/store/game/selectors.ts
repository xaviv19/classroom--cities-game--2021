import { AppState } from "www/store";

export function getGame(state: AppState) {
  return state.game;
}
