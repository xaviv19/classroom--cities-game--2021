import { Middleware } from "redux";
import { AppState } from "www/store";
import { gamePost } from "www/store/game/gamePost";
import { ComponentLeveledActionTypes, UPGRADED } from "./types";

export const componentLeveledMiddleware: Middleware<{}, AppState> =
  (store: any) => (next) => async (action: ComponentLeveledActionTypes) => {
    next(action);

    if (action.type === UPGRADED) {
      await gamePost(store, `/api/v1/leveleds/${action.entityId}/upgrade`, {});
    }
  };
