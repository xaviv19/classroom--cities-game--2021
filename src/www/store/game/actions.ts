import { GameCreatedAction, GAME_CREATED } from "./types";

export function gameCreated(gameName: string): GameCreatedAction {
  return {
    type: GAME_CREATED,
    form: {
      gameName,
    },
  };
}
