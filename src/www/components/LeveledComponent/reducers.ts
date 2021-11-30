import { ComponentLeveledActionTypes, ComponentLeveledState } from "./types";

export function componentLeveledReducer(
  state: ComponentLeveledState = null,
  action: ComponentLeveledActionTypes
) {
  switch (action.type) {
    default:
      return state;
  }
}
