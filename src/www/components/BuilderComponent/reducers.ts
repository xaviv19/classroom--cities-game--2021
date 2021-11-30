import { ComponentBuilderActionTypes, ComponentBuilderState } from "./types";

export function componentBuilderReducer(
  state: ComponentBuilderState = null,
  action: ComponentBuilderActionTypes
) {
  switch (action.type) {
    default:
      return state;
  }
}
