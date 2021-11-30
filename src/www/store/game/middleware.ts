import { Middleware } from "redux";
import { apiGet, apiPost } from "www/api";
import { AppState } from "www/store";
import {
  loadingFinished,
  loadingStarted,
} from "www/widgets/LoadingWidget/actions";
import { screenPushed } from "www/widgets/ScreenStackWidget/actions";
import {
  GamePlayedAction,
  GAME_PLAYED,
  GAME_REFRESHED,
  ROUND_ENDED,
} from "./types";
import { gameReplaced } from "./actions";
import { getGame } from "./selectors";
import { gamePost } from "./gamePost";

export const gameMiddleware: Middleware<{}, AppState> =
  (store: any) => (next) => async (action) => {
    next(action);

    if (action.type === GAME_PLAYED) {
      await playGame(store, action);
    }
    if (action.type === GAME_REFRESHED) {
      await refreshGame(store, action);
    }
    if (action.type === ROUND_ENDED) {
      await endRound(store);
    }
  };

async function playGame(store: any, action: GamePlayedAction) {
  store.dispatch(loadingStarted());

  const game = await apiGet(`/api/v1/games/play/${action.playerName}`);

  store.dispatch(gameReplaced(game));
  store.dispatch(screenPushed("game"));
  store.dispatch(loadingFinished());
}

async function refreshGame(store: any, action: any) {
  store.dispatch(loadingStarted());

  const playerName = getGame(store.getState())!.playerName;
  const game = await apiGet(`/api/v1/games/play/${playerName}`);

  store.dispatch(gameReplaced(game));
  store.dispatch(loadingFinished());
}

async function endRound(store: any) {
  await gamePost(store, `/api/v1/games/endRound`, {}, () =>
    store.dispatch(screenPushed("game"))
  );
}
