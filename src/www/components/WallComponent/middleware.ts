import { Middleware } from "redux";
import { AppState } from "www/store";
import { gamePost } from "www/store/game/gamePost";
import {
  ComponentWallActionTypes,
  WallOrderedAction,
  WALL_ORDERED
} from "./types";

export const componentWallMiddleware: Middleware<{}, AppState> =
  (store: any) => (next) => async (action: ComponentWallActionTypes) => {
    next(action);

    if (action.type === WALL_ORDERED) await orderWall(store, action);
  };

async function orderWall(store: any, action: WallOrderedAction) {
  await gamePost(store, `/api/v1/quantity/${action.entityId}/createWall`, {});
}

