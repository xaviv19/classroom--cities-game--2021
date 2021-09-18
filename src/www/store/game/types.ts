export type GameState = null;

export const GAME_CREATED = "game/CREATED";
export interface GameCreatedAction {
  type: typeof GAME_CREATED;
  form: {
    gameName: string;
  };
}

export type GameActionTypes = GameCreatedAction;
