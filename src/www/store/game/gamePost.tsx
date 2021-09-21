import { fetchAndDispatchMessage } from "www/widgets/MessageWidget/fetchAndDispatchMessage";
import {
  loadingFinished,
  loadingStarted,
} from "www/widgets/LoadingWidget/actions";
import { getPlayerToken } from "../player/selectors";
import { gameReplaced } from "./actions";

export async function gamePost(store: any, url: string, body: any) {
  store.dispatch(loadingStarted());
  const token = getPlayerToken(store.getState());
  const result = await fetchAndDispatchMessage(
    `${url}?token=${token}`,
    { method: "POST", body },
    store.dispatch
  );
  if (!result.isError) {
    store.dispatch(gameReplaced(result));
  }
  store.dispatch(loadingFinished());
}
