import {
  MY_CREATED_GAMES_LISTED,
  MyCreatedGamesListedAction,
  GamesByCreatorListedAction,
  GAMES_BY_CREATOR_LISTED,
  GamesList,
  GamesListReplacedAction,
  GAMES_LIST_REPLACED,
} from "./types";

export function gamesByCreatorListed(
  playerName: string
): GamesByCreatorListedAction {
  return {
    type: GAMES_BY_CREATOR_LISTED,
    form: { playerName },
  };
}

export function myCreatedGamesListed(): MyCreatedGamesListedAction {
  return {
    type: MY_CREATED_GAMES_LISTED,
  };
}

export function gamesListReplaced(
  gamesList: GamesList
): GamesListReplacedAction {
  return {
    type: GAMES_LIST_REPLACED,
    gamesList,
  };
}
