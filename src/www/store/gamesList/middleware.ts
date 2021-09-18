import { Middleware } from "redux";
import { AppState } from "www/store";
import { fetchAndDispatchMessage } from "www/widgets/MessageWidget/fetchAndDispatchMessage";
import {
  loadingFinished,
  loadingStarted,
} from "www/widgets/LoadingWidget/actions";
import { screenPushed } from "www/widgets/ScreenStackWidget/actions";
import { GAMES_BY_CREATOR_LISTED, MY_CREATED_GAMES_LISTED } from "./types";
import { getPlayerName } from "../player/selectors";
import { gamesByCreatorListed, gamesListReplaced } from "./actions";

export const gamesListMiddleware: Middleware<{}, AppState> =
  (store: any) => (next) => async (action) => {
    next(action);

    if (action.type === MY_CREATED_GAMES_LISTED) {
      await listByCurrentPlayer(store);
    }
    if (action.type === GAMES_BY_CREATOR_LISTED) {
      await listByPlayer(store, action);
    }
  };

async function listByCurrentPlayer(store: any) {
  const playerName = getPlayerName(store.getState())!;
  store.dispatch(gamesByCreatorListed(playerName));
}

async function listByPlayer(store: any, action: any) {
  store.dispatch(loadingStarted());
  const result = await fetchAndDispatchMessage(
    "/api/v1/games/byPlayer",
    { method: "POST", body: action.form },
    store.dispatch
  );
  if (!result.isError) {
    store.dispatch(screenPushed("gamesList"));
    store.dispatch(gamesListReplaced(result.games));
  }
  store.dispatch(loadingFinished());
}
