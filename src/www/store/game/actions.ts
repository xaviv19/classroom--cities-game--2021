import {
  GamePlayedAction,
  GameReplacedAction,
  GameState,
  GAME_PLAYED,
  GAME_REPLACED,
  GameRefreshedAction,
  GAME_REFRESHED,
  RoundEndedAction,
  ROUND_ENDED,
} from "./types";

export function gamePlayed(playerName: string): GamePlayedAction {
  return {
    type: GAME_PLAYED,
    playerName,
  };
}

export function gameReplaced(game: GameState): GameReplacedAction {
  return {
    type: GAME_REPLACED,
    game,
  };
}

export function gameRefreshed(): GameRefreshedAction {
  return {
    type: GAME_REFRESHED,
  };
}

export function roundEnded(): RoundEndedAction {
  return {
    type: ROUND_ENDED,
  };
}
