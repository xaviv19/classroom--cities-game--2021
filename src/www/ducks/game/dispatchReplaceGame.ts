import { ReduxStore } from "../ReduxStore";
import { setView } from "../view";
import { replaceGame } from "./replaceGame";
import { replaceAlert } from "../alert";

export function dispatchReplaceGame(reduxStore: ReduxStore, game: any) {
  reduxStore.dispatch(replaceGame(game));
  reduxStore.dispatch(setView({ root: "Board" }));

  if (game.message)
    reduxStore.dispatch(replaceAlert({ message: game.message }));
}
