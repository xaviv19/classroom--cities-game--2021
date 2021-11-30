type EntityState = {
  id: string;
  [key: string]: any;
};

export type GameState = null | {
  roundNumber: number;
  playerName: string;
  token: string;
  entities: {
    [id: string]: EntityState;
  };
};

export const GAME_PLAYED = "game/PLAYED";
export interface GamePlayedAction {
  type: typeof GAME_PLAYED;
  playerName: string;
}

export const GAME_REFRESHED = "game/REFRESHED";
export interface GameRefreshedAction {
  type: typeof GAME_REFRESHED;
}

export const GAME_REPLACED = "game/REPLACED";
export interface GameReplacedAction {
  type: typeof GAME_REPLACED;
  game: GameState;
}

export const ROUND_ENDED = "game/ROUND_ENDED";
export interface RoundEndedAction {
  type: typeof ROUND_ENDED;
}

export type GameActionTypes =
  | GamePlayedAction
  | GameRefreshedAction
  | GameReplacedAction
  | RoundEndedAction;
