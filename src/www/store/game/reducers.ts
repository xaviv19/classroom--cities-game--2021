import { GameActionTypes, GameState } from "./types";

export function gameReducer(state: GameState = null, action: GameActionTypes) {
  switch (action.type) {
    default:
      return state;
  }
}
