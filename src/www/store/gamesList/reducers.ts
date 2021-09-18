import {
  GamesListActionTypes,
  GamesListState,
  GAMES_LIST_REPLACED,
} from "./types";

export function gamesListReducer(
  state: GamesListState = null,
  action: GamesListActionTypes
) {
  switch (action.type) {
    case GAMES_LIST_REPLACED:
      return action.gamesList;
    default:
      return state;
  }
}
