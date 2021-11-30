import { Middleware } from "redux";
import { AppState } from "www/store";
import { gamePost } from "www/store/game/gamePost";
import { screenPushed } from "www/widgets/ScreenStackWidget/actions";
import { ComponentBuilderActionTypes, BUILDED } from "./types";

export const componentBuilderMiddleware: Middleware<{}, AppState> =
  (store: any) => (next) => async (action: ComponentBuilderActionTypes) => {
    next(action);

    if (action.type === BUILDED) {
      await gamePost(
        store,
        `/api/v1/builders/${action.entityId}/build`,
        action.form,
        () => store.dispatch(screenPushed("entity", action.containerId))
      );
    }
  };
