import {
  ComponentWithBuildingsActionTypes,
  ComponentWithBuildingsState,
} from "./types";

export function componentWithBuildingsReducer(
  state: ComponentWithBuildingsState = null,
  action: ComponentWithBuildingsActionTypes
) {
  switch (action.type) {
    default:
      return state;
  }
}
