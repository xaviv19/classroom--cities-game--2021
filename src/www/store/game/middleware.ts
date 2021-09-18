import { Middleware } from "redux";
import { AppState } from "www/store";
import { fetchAndDispatchMessage } from "www/widgets/MessageWidget/fetchAndDispatchMessage";
import {
  loadingFinished,
  loadingStarted,
} from "www/widgets/LoadingWidget/actions";
import { screenPushed } from "www/widgets/ScreenStackWidget/actions";
import { GAME_CREATED } from "./types";
import { getPlayerToken } from "../player/selectors";

export const gameMiddleware: Middleware<{}, AppState> =
  (store: any) => (next) => async (action) => {
    next(action);

    if (action.type === GAME_CREATED) {
      await createGame(store, action);
    }
  };

async function createGame(store: any, action: any) {
  store.dispatch(loadingStarted());
  const token = getPlayerToken(store.getState());
  const result = await fetchAndDispatchMessage(
    "/api/v1/games",
    { method: "POST", body: { ...action.form, token } },
    store.dispatch
  );
  if (!result.isError) store.dispatch(screenPushed("player"));
  store.dispatch(loadingFinished());
}
