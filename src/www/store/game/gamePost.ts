import { apiPost } from "www/api";
import {
  loadingFinished,
  loadingStarted,
} from "www/widgets/LoadingWidget/actions";
import { gameReplaced } from "./actions";
import { GameState } from "./types";
import { getGame } from "./selectors";

export async function gamePost(
  store: any,
  url: string,
  body: any,
  success: (game: GameState) => Promise<void> | void = () => {}
) {
  store.dispatch(loadingStarted());

  const game = getGame(store.getState());
  const playerName = game?.playerName;
  const result = await apiPost(`${url}?playerName=${playerName}`, body);

  store.dispatch(gameReplaced(result));
  await success(result);

  store.dispatch(loadingFinished());
}
