import { AppState } from "www/store";
import { createSelector } from "reselect";

export function getGame(state: AppState) {
  return state.game;
}

export function getEntityById(
  state: AppState,
  { entityId }: { entityId: string }
) {
  return state.game?.entities[entityId];
}

export function makeGetAllGameEntities() {
  return createSelector(getGame, (game) =>
    game ? Object.values(game.entities) : []
  );
}
