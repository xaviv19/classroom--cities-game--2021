import { Middleware } from "redux";
import { AppState } from "www/store";
import { gamePost } from "www/store/game/gamePost";
import {
  ComponentHouseActionTypes,
  HouseOrderedAction,
  HOUSE_ORDERED
} from "./types";

export const componentHouseMiddleware: Middleware<{}, AppState> =
  (store: any) => (next) => async (action: ComponentHouseActionTypes) => {
    next(action);

    if (action.type === HOUSE_ORDERED) await orderHouse(store, action);
  };

async function orderHouse(store: any, action: HouseOrderedAction) {
  await gamePost(store, `/api/v1/quantity/${action.entityId}/createHouse`, {});
}

