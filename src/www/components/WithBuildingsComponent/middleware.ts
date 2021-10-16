import { Middleware } from "redux";
import { AppState } from "www/store";
import { gamePost } from "www/store/game/gamePost";
import {
  ComponentWithBuildingsActionTypes,
  BUILD_ORDERED,
  BuildOrderedAction,
} from "./types";

export const componentWithBuildingsMiddleware: Middleware<{}, AppState> =
  (store: any) =>
  (next) =>
  async (action: ComponentWithBuildingsActionTypes) => {
    next(action);

    if (action.type === BUILD_ORDERED) await orderBuild(store, action);
  };

async function orderBuild(store: any, action: BuildOrderedAction) {
  await gamePost(
    store,
    `/api/v1/with-buildings/${action.entityId}/order-build`,
    action.form
  );
}
