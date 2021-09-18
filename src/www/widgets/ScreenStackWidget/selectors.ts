import { AppState } from "www/store";

export function getCurrentScreenName(state: AppState) {
  return state.widgetScreenStack[state.widgetScreenStack.length - 1].name;
}
